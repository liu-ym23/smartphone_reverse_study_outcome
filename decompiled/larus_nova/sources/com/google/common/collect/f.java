package com.google.common.collect;

import java.lang.Comparable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class f<C extends Comparable> implements g2<C> {
    public f() {
    }

    @Override // com.google.common.collect.g2
    public abstract boolean encloses(Range<C> r100);

    @CheckForNull
    public abstract Range<C> rangeContaining(C r100);

    public void clear() {
        remove(Range.all());
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.g2
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public final String toString() {
        return asRanges().toString();
    }

    public void add(Range<C> r100) {
        throw new UnsupportedOperationException();
    }

    public void addAll(Iterable<Range<C>> r100) {
        Iterator<Range<C>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        add(r101.next());
        goto L4
    }

    public boolean contains(C r100) {
        if (rangeContaining(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean enclosesAll(Iterable<Range<C>> r100) {
        Iterator<Range<C>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (encloses(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof g2) == true) goto L8;
        return false;
    L8:
        return asRanges().equals(((g2) r100).asRanges());
    }

    public boolean intersects(Range<C> r100) {
        return !subRangeSet(r100).isEmpty();
    }

    public void remove(Range<C> r100) {
        throw new UnsupportedOperationException();
    }

    public void removeAll(Iterable<Range<C>> r100) {
        Iterator<Range<C>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public void addAll(g2<C> r100) {
        addAll(r100.asRanges());
    }

    public boolean enclosesAll(g2<C> r100) {
        return enclosesAll(r100.asRanges());
    }

    @Override // com.google.common.collect.g2
    public void removeAll(g2<C> r100) {
        removeAll(r100.asRanges());
    }
}
