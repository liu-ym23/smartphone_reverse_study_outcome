package com.larus.disk.impl;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f330603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f330604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f330605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f330606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f330607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f330608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f330609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f330610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f330611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f330612j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f330603a, r101.f330603a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f330604b, r101.f330604b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f330605c, r101.f330605c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f330606d, r101.f330606d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f330607e, r101.f330607e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f330608f, r101.f330608f) == 0) goto L27;
        return false;
    L27:
        if (this.f330609g == r101.f330609g) goto L30;
        return false;
    L30:
        if (this.f330610h == r101.f330610h) goto L33;
        return false;
    L33:
        if (this.f330611i == r101.f330611i) goto L36;
        return false;
    L36:
        if (this.f330612j == r101.f330612j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f330603a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f330604b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f330605c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f330606d);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.f330607e);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.f330608f);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        int r112 = 1231;
        if (this.f330609g == false) goto L5;
        int r113 = 1231;
    L6:
        int r114 = (r111 + r113) * 31;
        if (this.f330610h == false) goto L9;
        int r115 = 1231;
    L10:
        int r116 = (r114 + r115) * 31;
        if (this.f330611i == true) goto L14;
        r112 = 1237;
    L14:
        int r117 = (r116 + r112) * 31;
        long r118 = this.f330612j;
        return r117 + ((int) (r118 ^ (r118 >>> 32)));
    L9:
        r115 = 1237;
        goto L10
    L5:
        r113 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppDiskClearModel(beforeAppUsedSize=" + this.f330603a + ", beforeAppCacheSize=" + this.f330604b + ", afterAppUsedSize=" + this.f330605c + ", afterAppCacheSize=" + this.f330606d + ", totalHandlerSize=" + this.f330607e + ", totalCleanSize=" + this.f330608f + ", isLowDisk=" + this.f330609g + ", isManual=" + this.f330610h + ", isCustomBizClean=" + this.f330611i + ", timeCost=" + this.f330612j + ')';
    }

    public a(double r100, double r101, double r102, double r110, double r111, double r112, boolean r113, boolean r114, boolean r115, long r116) {
        this.f330603a = r100;
        this.f330604b = r101;
        this.f330605c = r102;
        this.f330606d = r110;
        this.f330607e = r111;
        this.f330608f = r112;
        this.f330609g = r113;
        this.f330610h = r114;
        this.f330611i = r115;
        this.f330612j = r116;
    }
}
