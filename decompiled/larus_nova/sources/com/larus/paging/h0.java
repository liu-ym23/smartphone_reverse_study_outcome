package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class h0<T> extends AbstractList<T> implements a0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PagingSource.b.c<?, T>> f363856a;

    @Override // com.larus.paging.a0
    public final int a() {
        return 0;
    }

    @Override // com.larus.paging.a0
    public final int d() {
        return 0;
    }

    @Override // com.larus.paging.a0
    public final int e() {
        return 0;
    }

    @Override // com.larus.paging.a0
    public final int getSize() {
        return 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "leading 0, storage 0, trailing 0 " + CollectionsKt.joinToString$default(this.f363856a, " ", null, null, 0, null, null, 62, null);
    }

    public h0() {
        this.f363856a = new ArrayList();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // com.larus.paging.a0
    public final T c(int r100) {
        int r101 = ((ArrayList) this.f363856a).size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        int r103 = ((PagingSource.b.c) ListProtector.get(this.f363856a, r102)).f363729a.size();
        if (r103 > r100) goto L9;
        r100 = r100 - r103;
        r102 = r102 + 1;
    L9:
        return (T) ListProtector.get(((PagingSource.b.c) ListProtector.get(this.f363856a, r102)).f363729a, r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int r100) {
        int r101 = r100 + 0;
        if (r100 < 0) goto L12;
        if (r100 >= 0) goto L12;
        if (r101 < 0) goto L9;
        if (r101 >= 0) goto L9;
        return c(r101);
    L9:
        return null;
    L12:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: 0");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int r100) {
        return (T) super.remove(r100);
    }
}
