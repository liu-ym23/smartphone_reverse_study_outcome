package com.larus.disk.impl;

/* JADX INFO: loaded from: classes27.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f330798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f330799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f330800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f330801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f330802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f330803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f330804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f330805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f330806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f330807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f330808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f330809l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Double.compare(this.f330798a, r101.f330798a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f330799b, r101.f330799b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f330800c, r101.f330800c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f330801d, r101.f330801d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f330802e, r101.f330802e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f330803f, r101.f330803f) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.f330804g, r101.f330804g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.f330805h, r101.f330805h) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.f330806i, r101.f330806i) == 0) goto L36;
        return false;
    L36:
        if (Double.compare(this.f330807j, r101.f330807j) == 0) goto L39;
        return false;
    L39:
        if (this.f330808k == r101.f330808k) goto L42;
        return false;
    L42:
        if (this.f330809l == r101.f330809l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f330798a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f330799b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f330800c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f330801d);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.f330802e);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.f330803f);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = Double.doubleToLongBits(this.f330804g);
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = Double.doubleToLongBits(this.f330805h);
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = Double.doubleToLongBits(this.f330806i);
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = Double.doubleToLongBits(this.f330807j);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        int r120 = 1231;
        if (this.f330808k == false) goto L5;
        int r121 = 1231;
    L6:
        int r122 = (r119 + r121) * 31;
        if (this.f330809l == true) goto L11;
        r120 = 1237;
    L11:
        return r122 + r120;
    L5:
        r121 = 1237;
        goto L6
    }

    public final String toString() {
        return "PhoneAndAppDiskInfo(availableInternalSize=" + this.f330798a + ", totalInternalSize=" + this.f330799b + ", availableExternalSize=" + this.f330800c + ", totalExternalSize=" + this.f330801d + ", totalDataSize=" + this.f330802e + ", totalCacheSize=" + this.f330803f + ", internalCacheSize=" + this.f330804g + ", externalCacheSize=" + this.f330805h + ", bizFileCacheSize=" + this.f330806i + ", totalAppCacheSize=" + this.f330807j + ", isAvailableExternal=" + this.f330808k + ", isLowDisk=" + this.f330809l + ')';
    }

    public r0(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114, double r210, double r211, boolean r212, boolean r213) {
        this.f330798a = r100;
        this.f330799b = r101;
        this.f330800c = r102;
        this.f330801d = r110;
        this.f330802e = r111;
        this.f330803f = r112;
        this.f330804g = r113;
        this.f330805h = r114;
        this.f330806i = r210;
        this.f330807j = r211;
        this.f330808k = r212;
        this.f330809l = r213;
    }
}
