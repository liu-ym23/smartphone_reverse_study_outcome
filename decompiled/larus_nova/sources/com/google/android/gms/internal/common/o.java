package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
public abstract class o extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274651b;

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f274651b >= this.f274650a) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f274651b <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f274651b;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f274651b - 1;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        int r100 = this.f274651b;
        this.f274651b = r100 + 1;
        return ((d) this).f274646c.get(r100);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious() == false) goto L7;
        int r100 = this.f274651b - 1;
        this.f274651b = r100;
        return ((d) this).f274646c.get(r100);
    L7:
        throw new NoSuchElementException();
    }

    public o(int r100, int r101) {
        if (r101 < 0) goto L8;
        if (r101 > r100) goto L8;
        this.f274650a = r100;
        this.f274651b = r101;
        return;
    L8:
        throw new IndexOutOfBoundsException(m.c(r101, r100, "index"));
    }
}
