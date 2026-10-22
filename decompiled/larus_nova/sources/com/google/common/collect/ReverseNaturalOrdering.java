package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    static {
        INSTANCE = new ReverseNaturalOrdering();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterable<E> r100) {
        return (E) NaturalOrdering.INSTANCE.min(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterable<E> r100) {
        return (E) NaturalOrdering.INSTANCE.max(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterator<E> r100) {
        return (E) NaturalOrdering.INSTANCE.min(r100);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterator<E> r100) {
        return (E) NaturalOrdering.INSTANCE.max(r100);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterable r100) {
        return max(r100);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterable r100) {
        return min(r100);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterator r100) {
        return max(r100);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterator r100) {
        return min(r100);
    }

    public int compare(Comparable<?> r100, Comparable<?> r101) {
        r100.getClass();
        if (r100 != r101) goto L7;
        return 0;
    L7:
        return r101.compareTo(r100);
    }

    public <E extends Comparable<?>> E max(E r100, E r101) {
        return (E) NaturalOrdering.INSTANCE.min(r100, r101);
    }

    public <E extends Comparable<?>> E min(E r100, E r101) {
        return (E) NaturalOrdering.INSTANCE.max(r100, r101);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r100, Object r101) {
        return compare((Comparable) r100, (Comparable) r101);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r100, Object r101) {
        return max((Comparable) r100, (Comparable) r101);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r100, Object r101) {
        return min((Comparable) r100, (Comparable) r101);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r100, Object r101, Object r102, Object[] r103) {
        return max((Comparable) r100, (Comparable) r101, (Comparable) r102, (Comparable[]) r103);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r100, Object r101, Object r102, Object[] r103) {
        return min((Comparable) r100, (Comparable) r101, (Comparable) r102, (Comparable[]) r103);
    }

    public <E extends Comparable<?>> E max(E r100, E r101, E r102, E... r103) {
        return (E) NaturalOrdering.INSTANCE.min(r100, r101, r102, r103);
    }

    public <E extends Comparable<?>> E min(E r100, E r101, E r102, E... r103) {
        return (E) NaturalOrdering.INSTANCE.max(r100, r101, r102, r103);
    }
}
