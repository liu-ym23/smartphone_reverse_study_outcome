package com.bytedance.kmp.network.nqe;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f252545f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f252546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f252547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f252548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f252549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f252550e;

    public static final class a {
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f252546a == r101.f252546a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f252547b, r101.f252547b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f252548c, r101.f252548c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f252549d, r101.f252549d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f252550e, r101.f252550e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f252546a * 31;
        long r101 = Double.doubleToLongBits(this.f252547b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f252548c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.f252549d);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.f252550e);
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    }

    public final String toString() {
        return "PacketLoss(protocol=" + this.f252546a + ", upstreamLossRate=" + this.f252547b + ", upstreamLossRateVariance=" + this.f252548c + ", downstreamLossRate=" + this.f252549d + ", downstreamLossRateVariance=" + this.f252550e + ')';
    }

    static {
        f252545f = new c(0);
    }

    public /* synthetic */ c(int r110) {
        this(-1, -1.0d, -1.0d, -1.0d, -1.0d);
    }

    public c(int r100, double r101, double r102, double r103, double r104) {
        this.f252546a = r100;
        this.f252547b = r101;
        this.f252548c = r102;
        this.f252549d = r103;
        this.f252550e = r104;
    }
}
