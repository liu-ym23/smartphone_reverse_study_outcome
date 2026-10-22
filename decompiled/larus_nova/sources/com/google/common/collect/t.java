package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class t<E> extends n0<E> implements n2<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient Ordering f275505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public transient o2.b f275506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    public transient s f275507c;

    @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public final y1<E> delegate() {
        return ((h.a) this).f275468d;
    }

    @Override // com.google.common.collect.n2
    public final n2<E> descendingMultiset() {
        return ((h.a) this).f275468d;
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> firstEntry() {
        return ((h.a) this).f275468d.lastEntry();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> lastEntry() {
        return ((h.a) this).f275468d.firstEntry();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> pollFirstEntry() {
        return ((h.a) this).f275468d.pollLastEntry();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public final y1.a<E> pollLastEntry() {
        return ((h.a) this).f275468d.pollFirstEntry();
    }

    @Override // com.google.common.collect.n2, com.google.common.collect.l2
    public final Comparator<? super E> comparator() {
        Ordering r100 = this.f275505a;
        if (r100 != null) goto L6;
        Ordering r101 = Ordering.from(((h.a) this).f275468d.comparator()).reverse();
        this.f275505a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.n0, com.google.common.collect.y1
    public final NavigableSet<E> elementSet() {
        o2.b r100 = this.f275506b;
        if (r100 != null) goto L6;
        o2.b r101 = new o2.b(this);
        this.f275506b = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.n0, com.google.common.collect.y1
    public final Set<y1.a<E>> entrySet() {
        s r100 = this.f275507c;
        if (r100 != null) goto L6;
        s r101 = new s(this);
        this.f275507c = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.o0
    public final String toString() {
        return entrySet().toString();
    }

    public t() {
    }

    @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public final Object delegate() {
        return ((h.a) this).f275468d;
    }

    @Override // com.google.common.collect.n0, com.google.common.collect.y1
    public final /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public final Collection delegate() {
        return ((h.a) this).f275468d;
    }

    @Override // com.google.common.collect.f0, java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] r100) {
        return (T[]) standardToArray(r100);
    }

    @Override // com.google.common.collect.n2
    public final n2<E> headMultiset(@ParametricNullness E r100, BoundType r101) {
        return ((h.a) this).f275468d.tailMultiset(r100, r101).descendingMultiset();
    }

    @Override // com.google.common.collect.n2
    public final n2<E> tailMultiset(@ParametricNullness E r100, BoundType r101) {
        return ((h.a) this).f275468d.headMultiset(r100, r101).descendingMultiset();
    }

    @Override // com.google.common.collect.n2
    public final n2<E> subMultiset(@ParametricNullness E r100, BoundType r101, @ParametricNullness E r102, BoundType r103) {
        return ((h.a) this).f275468d.subMultiset(r102, r103, r100, r101).descendingMultiset();
    }
}
