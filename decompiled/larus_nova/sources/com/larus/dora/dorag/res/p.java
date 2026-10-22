package com.larus.dora.dorag.res;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f331858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f331859b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Double.compare(this.f331858a, r101.f331858a) == 0) goto L12;
        return false;
    L12:
        if (this.f331859b == r101.f331859b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f331858a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f331859b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "RtcAverageBitrateSample(kbps=" + this.f331858a + ", receivedAtMs=" + this.f331859b + ')';
    }

    public p(double r100, long r101) {
        this.f331858a = r100;
        this.f331859b = r101;
    }
}
