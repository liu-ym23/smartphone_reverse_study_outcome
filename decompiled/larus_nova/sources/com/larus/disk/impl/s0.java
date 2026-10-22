package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f330813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f330814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f330815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f330816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f330817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f330818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f330819i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f330811a, r101.f330811a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330812b, r101.f330812b) == true) goto L15;
        return false;
    L15:
        if (this.f330813c == r101.f330813c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330814d, r101.f330814d) == true) goto L21;
        return false;
    L21:
        if (this.f330815e == r101.f330815e) goto L24;
        return false;
    L24:
        if (this.f330816f == r101.f330816f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f330817g, r101.f330817g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f330818h, r101.f330818h) == true) goto L33;
        return false;
    L33:
        if (this.f330819i == r101.f330819i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f330811a.hashCode() * 31) + this.f330812b.hashCode()) * 31;
        long r101 = this.f330813c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f330814d.hashCode()) * 31;
        int r103 = 1231;
        if (this.f330815e == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f330816f == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        Long r108 = this.f330817g;
        int r109 = 0;
        if (r108 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r107 + r110) * 31;
        Long r112 = this.f330818h;
        if (r112 == null) goto L18;
        r109 = r112.hashCode();
    L18:
        int r113 = (r111 + r109) * 31;
        if (this.f330819i == true) goto L23;
        r103 = 1237;
    L23:
        return r113 + r103;
    L13:
        r110 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "RegisteredCacheUsageInfo(business=" + this.f330811a + ", biz=" + this.f330812b + ", sizeBytes=" + this.f330813c + ", storageScope=" + this.f330814d + ", autoCleanable=" + this.f330815e + ", manualCleanable=" + this.f330816f + ", autoCleanableBytes=" + this.f330817g + ", manualCleanableBytes=" + this.f330818h + ", collectionComplete=" + this.f330819i + ')';
    }

    public s0(String r100, String r101, long r102, String r103, boolean r104, boolean r105, Long r106, Long r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r101, "biz");
        Intrinsics.checkNotNullParameter(r103, "storageScope");
        this.f330811a = r100;
        this.f330812b = r101;
        this.f330813c = r102;
        this.f330814d = r103;
        this.f330815e = r104;
        this.f330816f = r105;
        this.f330817g = r106;
        this.f330818h = r110;
        this.f330819i = r111;
    }
}
