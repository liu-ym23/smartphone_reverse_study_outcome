package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public ReverseOrdering(Ordering<? super T> r100) {
        r100.getClass();
        this.forwardOrder = r100;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReverseOrdering) == true) goto L8;
        return false;
    L8:
        return this.forwardOrder.equals(((ReverseOrdering) r100).forwardOrder);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> r100) {
        return (E) this.forwardOrder.min(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> r100) {
        return (E) this.forwardOrder.max(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> r100) {
        return (E) this.forwardOrder.min(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> r100) {
        return (E) this.forwardOrder.max(r100);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T r100, @ParametricNullness T r101) {
        return this.forwardOrder.compare(r101, r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E r100, @ParametricNullness E r101) {
        return (E) this.forwardOrder.min(r100, r101);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E r100, @ParametricNullness E r101) {
        return (E) this.forwardOrder.max(r100, r101);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E r100, @ParametricNullness E r101, @ParametricNullness E r102, E... r103) {
        return (E) this.forwardOrder.min(r100, r101, r102, r103);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E r100, @ParametricNullness E r101, @ParametricNullness E r102, E... r103) {
        return (E) this.forwardOrder.max(r100, r101, r102, r103);
    }
}
