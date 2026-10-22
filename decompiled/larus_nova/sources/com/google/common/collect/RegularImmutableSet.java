package com.google.common.collect;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f275316f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f275317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f275318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f275319e;
    final transient Object[] elements;
    final transient Object[] table;

    static {
        Object[] r100 = new Object[0];
        f275316f = r100;
        EMPTY = new RegularImmutableSet(r100, 0, r100, 0, 0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.f275319e);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public z2<E> iterator() {
        return asList().iterator();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f275317c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f275319e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f275319e;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        Object[] r101 = this.table;
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r101.length == 0) goto L16;
        int r102 = u0.c(r100);
    L8:
        int r103 = r102 & this.f275318d;
        Object r104 = r101[r103];
        if (r104 == null) goto L10;
        if (r104.equals(r100) == true) goto L13;
        r102 = r103 + 1;
        goto L8
    L13:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r100, int r101) {
        System.arraycopy(this.elements, 0, r100, r101, this.f275319e);
        return r101 + this.f275319e;
    }

    public RegularImmutableSet(Object[] r100, int r101, Object[] r102, int r103, int r104) {
        this.elements = r100;
        this.f275317c = r101;
        this.table = r102;
        this.f275318d = r103;
        this.f275319e = r104;
    }
}
