package com.larus.dora.dorag.res;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f331856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f331857b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Double.compare(this.f331856a, r101.f331856a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f331857b, r101.f331857b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f331856a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f331857b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "MmtTargetBitrateSnapshot(avgKbps=" + this.f331856a + ", minKbps=" + this.f331857b + ')';
    }

    public /* synthetic */ n(int r100) {
        this(-1.0d, -1.0d);
    }

    public n(double r100, double r101) {
        this.f331856a = r100;
        this.f331857b = r101;
    }
}
