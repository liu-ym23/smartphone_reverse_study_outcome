package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = null;
    final transient Object[] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f275302c;

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    static {
        EMPTY = new RegularImmutableList(new Object[0], 0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f275302c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f275302c;
    }

    @Override // java.util.List
    public E get(int r100) {
        com.google.common.base.m.j(r100, this.f275302c);
        E r101 = (E) this.array[r100];
        Objects.requireNonNull(r101);
        return r101;
    }

    public RegularImmutableList(Object[] r100, int r101) {
        this.array = r100;
        this.f275302c = r101;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        System.arraycopy(this.array, 0, r100, r101, this.f275302c);
        return r101 + this.f275302c;
    }
}
