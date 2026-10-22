package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
public interface Marker extends Serializable {
    public static final String ANY_MARKER = "*";
    public static final String ANY_NON_NULL_MARKER = "+";

    void add(Marker r100);

    boolean contains(String r100);

    boolean contains(Marker r100);

    boolean equals(Object r100);

    String getName();

    boolean hasChildren();

    boolean hasReferences();

    int hashCode();

    Iterator<Marker> iterator();

    boolean remove(Marker r100);
}
