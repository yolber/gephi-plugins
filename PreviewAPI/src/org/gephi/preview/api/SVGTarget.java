/*
Copyright 2008-2011 Gephi
Authors : Mathieu Bastian
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.preview.api;

import java.awt.Color;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Rendering target to SVG format.
 * <p>
 * This target is used by renderers objects to render a graph to a SVG DOM and uses
 * the <a href="http://http://xmlgraphics.apache.org/batik/">Batik</a> library to
 * transcode the SVG DOM in a SVG document.
 * <p>
 * To allow further document further manipulation the DOM is organized with top
 * elements. Top elements are <code>nodes</code>, <code>edges</code>, <code>node-labels</code>, 
 * <code>edge-labels</code> and <code>arrows</code> and are elements to append
 * items to. For instance when a node label element is created it should be appended
 * to the <code>node-label</code> element instead of directly to the root. Use
 * the <code>getTopElement()</code> method to retrieve or create top elements.
 * @author Mathieu Bastian
 */
public interface SVGTarget extends RenderTarget {

    /**
     * SVG <code>Boolean<code> property whether to rescale stroke's width/thickness.
     */
    public static final String SCALE_STROKES = "svg.scale.strokes";
    /**
     * Default top element name for nodes
     */
    public static final String TOP_NODES = "nodes";
    /**
     * Default top element name for edges
     */
    public static final String TOP_EDGES = "edges";
    /**
     * Default top element name for node labels
     */
    public static final String TOP_NODE_LABELS = "node-labels";
    /**
     * Default top element name for node labels outline
     */
    public static final String TOP_NODE_LABELS_OUTLINE = "node-labels-outline";
    /**
     * Default top element name for edge labels
     */
    public static final String TOP_EDGE_LABELS = "edge-labels";
    /**
     * Default top element name for edge labels outline
     */
    public static final String TOP_EDGE_LABELS_OUTLINE = "edge-labels-outline";
    /**
     * Default top element name for arrows
     */
    public static final String TOP_ARROWS = "arrows";

    /**
     * Create a new element <code>qualifiedName</code> in the document.
     * @param qualifiedName the name of the element
     * @return the newly created element
     */
    public Element createElement(String qualifiedName);

    /**
     * Create a new text node with <code>data</code> in it.
     * @param data the text data
     * @return the newly created text node
     */
    public Text createTextNode(String data);

    /**
     * Returns the top element <code>name</code> in the document. Top elements are
     * direct children of the root node and help to organize the SVG document (e.g.
     * all edges in the same parent DOM node). Create the top element if it missing.
     * @param name the top element name to lookup
     * @return the top element
     */
    public Element getTopElement(String name);

    /**
     * Returns the SVG document
     * @return the SVG document
     */
    public Document getDocument();

    /**
     * When <code>SCALE_STROKES</code> property is <code>true</code> returns
     * the scale ratio to scale strokes with.
     * @return the current scale ratio
     */
    public float getScaleRatio();

    /**
     * Returns <code>color</code> in the hex format (e.g. #ff0000).
     * @param color the color to convert
     * @return the color in a hex format
     */
    public String toHexString(Color color);
}
