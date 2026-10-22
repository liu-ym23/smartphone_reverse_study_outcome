package com.google.common.collect;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    private static final long serialVersionUID = 0;

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public HashMultiset(int r100) {
        super(r100);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> r100) {
        HashMultiset<E> r101 = create(Multisets.c(r100));
        a1.a(r101, r100);
        return r101;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100) {
        return super.contains(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public c2<E> newBackingMap(int r100) {
        return new c2(r100);
    }

    public static <E> HashMultiset<E> create(int r100) {
        return new HashMultiset(r100);
    }
}
