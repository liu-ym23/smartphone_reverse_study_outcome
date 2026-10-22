package com.google.common.collect;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.y1
    public abstract /* synthetic */ int count(@CheckForNull Object r100);

    public static <E> ImmutableSortedMultiset.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMultisetFauxverideShim() {
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(E[] r100) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100, E r101) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100, E r101, E r102) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100, E r101, E r102, E r103) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100, E r101, E r102, E r103, E r104) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableSortedMultiset<E> of(E r100, E r101, E r102, E r103, E r104, E r105, E... r106) {
        throw new UnsupportedOperationException();
    }
}
