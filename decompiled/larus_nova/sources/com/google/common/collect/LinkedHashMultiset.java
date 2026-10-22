package com.google.common.collect;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public static <E> LinkedHashMultiset<E> create() {
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

    public LinkedHashMultiset(int r100) {
        super(r100);
    }

    public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> r100) {
        LinkedHashMultiset<E> r101 = create(Multisets.c(r100));
        a1.a(r101, r100);
        return r101;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100) {
        return super.contains(r100);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public c2<E> newBackingMap(int r100) {
        return new d2(r100);
    }

    public static <E> LinkedHashMultiset<E> create(int r100) {
        return new LinkedHashMultiset(r100);
    }
}
