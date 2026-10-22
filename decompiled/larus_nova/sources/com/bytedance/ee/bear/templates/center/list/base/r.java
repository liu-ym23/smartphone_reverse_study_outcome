package com.bytedance.ee.bear.templates.center.list.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f239023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f239024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f239025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f239026f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f239021a, r101.f239021a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f239022b, r101.f239022b) == true) goto L15;
        return false;
    L15:
        if (this.f239023c == r101.f239023c) goto L18;
        return false;
    L18:
        if (this.f239024d == r101.f239024d) goto L21;
        return false;
    L21:
        if (this.f239025e == r101.f239025e) goto L24;
        return false;
    L24:
        if (this.f239026f == r101.f239026f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f239021a.hashCode() * 31) + this.f239022b.hashCode()) * 31) + this.f239023c) * 31;
        if (this.f239024d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f239025e;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f239026f;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RequestParams(cacheKey=" + this.f239021a + ", lastIndex=" + this.f239022b + ", filterType=" + this.f239023c + ", isLoadMore=" + this.f239024d + ", categoryId=" + this.f239025e + ", pageNumber=" + this.f239026f + ')';
    }

    public r(String r100, String r101, int r102, boolean r103, long r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        Intrinsics.checkNotNullParameter(r101, "lastIndex");
        this.f239021a = r100;
        this.f239022b = r101;
        this.f239023c = r102;
        this.f239024d = r103;
        this.f239025e = r104;
        this.f239026f = r105;
    }

    public /* synthetic */ r(String r110, String r111, int r112, boolean r113, long r114, int r115, int r116) {
        if ((r115 & 2) == 0) goto L5;
        String r100 = "0";
    L7:
        if ((r115 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r115 & 16) == 0) goto L13;
        long r102 = -1;
    L14:
        this(r110, r100, r112, r101, r102, 0);
        return;
    L13:
        r102 = r114;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
