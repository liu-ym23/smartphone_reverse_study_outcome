package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public class BasicMarker implements Marker {
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private final List<Marker> referenceList;

    @Override // org.slf4j.Marker
    public boolean hasReferences() {
        if (this.referenceList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.slf4j.Marker
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Marker
    public Iterator<Marker> iterator() {
        return this.referenceList.iterator();
    }

    @Override // org.slf4j.Marker
    public boolean hasChildren() {
        return hasReferences();
    }

    public String toString() {
        if (hasReferences() == false) goto L5;
        Iterator<Marker> r100 = iterator();
        StringBuilder r101 = new StringBuilder(getName());
        r101.append(" [ ");
    L8:
        if (r100.hasNext() == false) goto L12;
        r101.append(r100.next().getName());
        if (r100.hasNext() == false) goto L8;
        r101.append(", ");
        goto L8
    L12:
        r101.append(" ]");
        return r101.toString();
    L5:
        return getName();
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.name;
    }

    public BasicMarker(String r100) {
        this.referenceList = new CopyOnWriteArrayList();
        if (r100 == null) goto L7;
        this.name = r100;
        return;
    L7:
        throw new IllegalArgumentException("A marker name cannot be null");
    }

    @Override // org.slf4j.Marker
    public void add(Marker r100) {
        if (r100 == null) goto L12;
        if (contains(r100) == false) goto L7;
        return;
    L7:
        if (r100.contains(this) == false) goto L9;
        return;
    L9:
        this.referenceList.add(r100);
        return;
    L12:
        throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
    }

    @Override // org.slf4j.Marker
    public boolean contains(String r100) {
        if (r100 == null) goto L17;
        if (this.name.equals(r100) == false) goto L7;
        return true;
    L7:
        if (hasReferences() == false) goto L14;
        Iterator<Marker> r101 = this.referenceList.iterator();
    L10:
        if (r101.hasNext() == false) goto L21;
        if (r101.next().contains(r100) == false) goto L10;
        return true;
    L21:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalArgumentException("Other cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof Marker) == true) goto L12;
        return false;
    L12:
        return this.name.equals(((Marker) r100).getName());
    }

    @Override // org.slf4j.Marker
    public boolean remove(Marker r100) {
        return this.referenceList.remove(r100);
    }

    @Override // org.slf4j.Marker
    public boolean contains(Marker r100) {
        if (r100 == null) goto L17;
        if (equals(r100) == false) goto L7;
        return true;
    L7:
        if (hasReferences() == false) goto L14;
        Iterator<Marker> r101 = this.referenceList.iterator();
    L10:
        if (r101.hasNext() == false) goto L21;
        if (r101.next().contains(r100) == false) goto L10;
        return true;
    L21:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalArgumentException("Other cannot be null");
    }
}
