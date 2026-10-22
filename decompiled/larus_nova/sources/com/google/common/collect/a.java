package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class a<E> extends a3<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f275424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f275425b;

    @ParametricNullness
    public abstract E a(int r100);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f275425b >= this.f275424a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f275425b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f275425b - 1;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    @ParametricNullness
    public final E next() {
        if (hasNext() == false) goto L7;
        int r100 = this.f275425b;
        this.f275425b = r100 + 1;
        return a(r100);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    @ParametricNullness
    public final E previous() {
        if (hasPrevious() == false) goto L7;
        int r100 = this.f275425b - 1;
        this.f275425b = r100;
        return a(r100);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f275425b;
    }

    public a(int r100, int r101) {
        com.google.common.base.m.m(r101, r100);
        this.f275424a = r100;
        this.f275425b = r101;
    }
}
