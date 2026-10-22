package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0 f330653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f330654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f330655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f330656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f330657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f330658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f330659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f330660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f330661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f330662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f330663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f330664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f330665n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f330666o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f330667p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f330668q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f330669r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f330670s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f330671t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f330672u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f330673v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f330674w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f330675x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a0 f330676y;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f330652a, r101.f330652a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330653b, r101.f330653b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330654c, r101.f330654c) == true) goto L18;
        return false;
    L18:
        if (this.f330655d == r101.f330655d) goto L21;
        return false;
    L21:
        if (this.f330656e == r101.f330656e) goto L24;
        return false;
    L24:
        if (this.f330657f == r101.f330657f) goto L27;
        return false;
    L27:
        if (this.f330658g == r101.f330658g) goto L30;
        return false;
    L30:
        if (this.f330659h == r101.f330659h) goto L33;
        return false;
    L33:
        if (this.f330660i == r101.f330660i) goto L36;
        return false;
    L36:
        if (this.f330661j == r101.f330661j) goto L39;
        return false;
    L39:
        if (this.f330662k == r101.f330662k) goto L42;
        return false;
    L42:
        if (this.f330663l == r101.f330663l) goto L45;
        return false;
    L45:
        if (this.f330664m == r101.f330664m) goto L48;
        return false;
    L48:
        if (this.f330665n == r101.f330665n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f330666o, r101.f330666o) == true) goto L54;
        return false;
    L54:
        if (this.f330667p == r101.f330667p) goto L57;
        return false;
    L57:
        if (this.f330668q == r101.f330668q) goto L60;
        return false;
    L60:
        if (this.f330669r == r101.f330669r) goto L63;
        return false;
    L63:
        if (this.f330670s == r101.f330670s) goto L66;
        return false;
    L66:
        if (this.f330671t == r101.f330671t) goto L69;
        return false;
    L69:
        if (Float.compare(this.f330672u, r101.f330672u) == 0) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f330673v, r101.f330673v) == true) goto L75;
        return false;
    L75:
        if (this.f330674w == r101.f330674w) goto L78;
        return false;
    L78:
        if (this.f330675x == r101.f330675x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f330676y, r101.f330676y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330652a.hashCode() * 31;
        t0 r101 = this.f330653b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        y r105 = this.f330654c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        long r106 = this.f330655d;
        int r107 = (((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f330656e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f330657f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f330658g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f330659h;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.f330660i;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f330661j;
        int r119 = (((((((((((((((r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.f330662k) * 31) + this.f330663l) * 31) + this.f330664m) * 31) + this.f330665n) * 31) + this.f330666o.hashCode()) * 31) + this.f330667p) * 31) + this.f330668q) * 31;
        int r120 = 1231;
        if (this.f330669r == false) goto L13;
        int r121 = 1231;
    L14:
        int r122 = (r119 + r121) * 31;
        if (this.f330670s == true) goto L18;
        r120 = 1237;
    L18:
        int r123 = (((((((r122 + r120) * 31) + this.f330671t) * 31) + Float.floatToIntBits(this.f330672u)) * 31) + this.f330673v.hashCode()) * 31;
        long r124 = this.f330674w;
        return ((((r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31) + this.f330675x) * 31) + this.f330676y.hashCode();
    L13:
        r121 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiskStorageSnapshot(snapshotId=" + this.f330652a + ", systemStorage=" + this.f330653b + ", deviceStorage=" + this.f330654c + ", externalTotalBytes=" + this.f330655d + ", externalAvailableBytes=" + this.f330656e + ", sandboxStorageBytes=" + this.f330657f + ", rootCacheStorageBytes=" + this.f330658g + ", registeredUsageBytes=" + this.f330659h + ", registeredAutoCleanableBytes=" + this.f330660i + ", registeredManualCleanableBytes=" + this.f330661j + ", registeredHandlerCount=" + this.f330662k + ", registeredHandlerExpectedCount=" + this.f330663l + ", registeredHandlerFailureCount=" + this.f330664m + ", registeredCandidateFailureCount=" + this.f330665n + ", registeredCollectionStatus=" + this.f330666o + ", businessGroupCount=" + this.f330667p + ", bizGroupCount=" + this.f330668q + ", isExternalStorageAvailable=" + this.f330669r + ", isLowDisk=" + this.f330670s + ", cleanType=" + this.f330671t + ", scanSampleRate=" + this.f330672u + ", samplingStrategy=" + this.f330673v + ", scanIntervalMs=" + this.f330674w + ", fileTypeScanDepth=" + this.f330675x + ", fileTypeSummary=" + this.f330676y + ')';
    }

    public g0(String r100, t0 r110, y r111, long r112, long r113, long r114, long r115, long r210, long r211, long r212, int r213, int r214, int r215, int r216, String r310, int r311, int r312, boolean r313, boolean r314, int r315, float r316, long r317, int r318, a0 r410) {
        Intrinsics.checkNotNullParameter(r100, "snapshotId");
        Intrinsics.checkNotNullParameter(r310, "registeredCollectionStatus");
        Intrinsics.checkNotNullParameter("stable_install_bucket", "samplingStrategy");
        Intrinsics.checkNotNullParameter(r410, "fileTypeSummary");
        this.f330652a = r100;
        this.f330653b = r110;
        this.f330654c = r111;
        this.f330655d = r112;
        this.f330656e = r113;
        this.f330657f = r114;
        this.f330658g = r115;
        this.f330659h = r210;
        this.f330660i = r211;
        this.f330661j = r212;
        this.f330662k = r213;
        this.f330663l = r214;
        this.f330664m = r215;
        this.f330665n = r216;
        this.f330666o = r310;
        this.f330667p = r311;
        this.f330668q = r312;
        this.f330669r = r313;
        this.f330670s = r314;
        this.f330671t = r315;
        this.f330672u = r316;
        this.f330673v = "stable_install_bucket";
        this.f330674w = r317;
        this.f330675x = r318;
        this.f330676y = r410;
    }
}
