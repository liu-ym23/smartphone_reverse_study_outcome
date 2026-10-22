package com.google.common.collect;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient ImmutableSortedMultiset<E> f275008d;

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public ImmutableSortedSet<E> elementSet() {
        return this.f275008d.elementSet().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> firstEntry() {
        return this.f275008d.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f275008d.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    @CheckForNull
    public y1.a<E> lastEntry() {
        return this.f275008d.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public int size() {
        return this.f275008d.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f275008d;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> r100) {
        this.f275008d = r100;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        return this.f275008d.count(r100);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public y1.a<E> getEntry(int r100) {
        return this.f275008d.entrySet().asList().reverse().get(r100);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public ImmutableSortedMultiset<E> headMultiset(E r100, BoundType r101) {
        return this.f275008d.tailMultiset(r100, r101).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public ImmutableSortedMultiset<E> tailMultiset(E r100, BoundType r101) {
        return this.f275008d.headMultiset(r100, r101).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 headMultiset(Object r100, BoundType r101) {
        return headMultiset(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 tailMultiset(Object r100, BoundType r101) {
        return tailMultiset(r100, r101);
    }
}
