package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final NaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient Ordering<Comparable<?>> f275285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public transient Ordering<Comparable<?>> f275286b;

    public String toString() {
        return "Ordering.natural()";
    }

    static {
        INSTANCE = new NaturalOrdering();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsFirst() {
        Ordering<S> r100 = (Ordering<S>) this.f275285a;
        if (r100 != null) goto L6;
        Ordering<S> r101 = super.nullsFirst();
        this.f275285a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsLast() {
        Ordering<S> r100 = (Ordering<S>) this.f275286b;
        if (r100 != null) goto L6;
        Ordering<S> r101 = super.nullsLast();
        this.f275286b = r101;
        return r101;
    L6:
        return r100;
    }

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public int compare(Comparable<?> r100, Comparable<?> r101) {
        r100.getClass();
        r101.getClass();
        return r100.compareTo(r101);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r100, Object r101) {
        return compare((Comparable) r100, (Comparable) r101);
    }
}
