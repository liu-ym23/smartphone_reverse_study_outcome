package com.bytedance.ee.bear.contract.route.parcelable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f217159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f217160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f217161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f217163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f217164f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f217159a, r101.f217159a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f217160b, r101.f217160b) == true) goto L15;
        return false;
    L15:
        if (this.f217161c == r101.f217161c) goto L18;
        return false;
    L18:
        if (this.f217162d == r101.f217162d) goto L21;
        return false;
    L21:
        if (this.f217163e == r101.f217163e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217164f, r101.f217164f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f217159a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f217160b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f217161c) * 31;
        int r107 = 1231;
        if (this.f217162d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f217163e == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        String r111 = this.f217164f;
        if (r111 == null) goto L23;
        r101 = r111.hashCode();
    L23:
        return r110 + r101;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TraceRouteEntry(wikiToken=" + this.f217159a + ", objToken=" + this.f217160b + ", objType=" + this.f217161c + ", inSpace=" + this.f217162d + ", redirected=" + this.f217163e + ", logId=" + this.f217164f + ')';
    }

    public k(String r100, String r101, int r102, boolean r103, String r104) {
        this.f217159a = r100;
        this.f217160b = r101;
        this.f217161c = r102;
        this.f217162d = false;
        this.f217163e = r103;
        this.f217164f = r104;
    }
}
