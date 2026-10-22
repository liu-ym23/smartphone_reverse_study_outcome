package com.google.common.collect;

import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    @Override // com.google.common.collect.ImmutableCollection
    @CheckForNull
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // java.util.List
    public E get(int r100) {
        return this.delegateList.get(r100);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public a3<E> listIterator(int r100) {
        return this.delegateList.listIterator(r100);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r100) {
        return listIterator(r100);
    }

    public RegularImmutableAsList(ImmutableCollection<E> r100, ImmutableList<? extends E> r101) {
        this.delegate = r100;
        this.delegateList = r101;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        return this.delegateList.copyIntoArray(r100, r101);
    }

    public RegularImmutableAsList(ImmutableCollection<E> r100, Object[] r101) {
        this(r100, ImmutableList.asImmutableList(r101));
    }

    public RegularImmutableAsList(ImmutableCollection<E> r100, Object[] r101, int r102) {
        this(r100, ImmutableList.asImmutableList(r101, r102));
    }
}
