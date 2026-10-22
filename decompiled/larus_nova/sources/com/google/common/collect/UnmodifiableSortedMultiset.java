package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements n2<E> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient UnmodifiableSortedMultiset<E> f275423a;

    @Override // com.google.common.collect.n2
    public n2<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> r100 = this.f275423a;
        if (r100 != null) goto L6;
        UnmodifiableSortedMultiset<E> r101 = new UnmodifiableSortedMultiset(delegate().descendingMultiset());
        r101.f275423a = this;
        this.f275423a = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.n2, com.google.common.collect.l2
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return Sets.f(delegate().elementSet());
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public n2<E> delegate() {
        return (n2) super.delegate();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.y1
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ y1 delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.n0, com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    public UnmodifiableSortedMultiset(n2<E> r100) {
        super(r100);
    }

    @Override // com.google.common.collect.n2
    public n2<E> headMultiset(@ParametricNullness E r100, BoundType r101) {
        n2<E> r102 = delegate().headMultiset(r100, r101);
        r102.getClass();
        return new UnmodifiableSortedMultiset(r102);
    }

    @Override // com.google.common.collect.n2
    public n2<E> tailMultiset(@ParametricNullness E r100, BoundType r101) {
        n2<E> r102 = delegate().tailMultiset(r100, r101);
        r102.getClass();
        return new UnmodifiableSortedMultiset(r102);
    }

    @Override // com.google.common.collect.n2
    public n2<E> subMultiset(@ParametricNullness E r100, BoundType r101, @ParametricNullness E r102, BoundType r103) {
        n2<E> r104 = delegate().subMultiset(r100, r101, r102, r103);
        r104.getClass();
        return new UnmodifiableSortedMultiset(r104);
    }
}
