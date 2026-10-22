package com.larus.common.mssdk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f326396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f326397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f326398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f326399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f326400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f326401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f326402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f326403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f326404i;

    public a() {
        this(0, 0, 0, 0, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f326396a == r101.f326396a) goto L12;
        return false;
    L12:
        if (this.f326397b == r101.f326397b) goto L15;
        return false;
    L15:
        if (this.f326398c == r101.f326398c) goto L18;
        return false;
    L18:
        if (this.f326399d == r101.f326399d) goto L21;
        return false;
    L21:
        if (this.f326400e == r101.f326400e) goto L24;
        return false;
    L24:
        if (this.f326401f == r101.f326401f) goto L27;
        return false;
    L27:
        if (this.f326402g == r101.f326402g) goto L30;
        return false;
    L30:
        if (this.f326403h == r101.f326403h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f326404i, r101.f326404i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f326396a * 31) + this.f326397b) * 31) + this.f326398c) * 31) + this.f326399d) * 31;
        if (this.f326400e == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f326401f;
        return ((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f326402g) * 31) + this.f326403h) * 31) + this.f326404i.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FreqInfo(apiId=" + this.f326396a + ", count2Mark=" + this.f326397b + ", mark2Report=" + this.f326398c + ", interval=" + this.f326399d + ", checkBackground=" + this.f326400e + ", firstCallTime=" + this.f326401f + ", curCount=" + this.f326402g + ", curMark=" + this.f326403h + ", stack=" + this.f326404i + ')';
    }

    public /* synthetic */ a(int r110, int r111, int r112, int r113, boolean r114, int r210) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = Integer.MAX_VALUE;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = Integer.MAX_VALUE;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = Integer.MAX_VALUE;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r210 & 256) == 0) goto L25;
        String r105 = "";
    L26:
        this(r100, r101, r102, r103, r104, 0, 0, 0, r105);
        return;
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(int r100, int r101, int r102, int r103, boolean r104, long r105, int r106, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "stack");
        this.f326396a = r100;
        this.f326397b = r101;
        this.f326398c = r102;
        this.f326399d = r103;
        this.f326400e = r104;
        this.f326401f = r105;
        this.f326402g = r106;
        this.f326403h = r110;
        this.f326404i = r111;
    }
}
