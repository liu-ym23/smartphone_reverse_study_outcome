package com.bytedance.navigation.kmp.handler.projection;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f265854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f265855b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f265854a, r101.f265854a) == 0) goto L12;
        return false;
    L12:
        if (this.f265855b == r101.f265855b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f265854a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f265855b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "DeviceDirectionSample(direction=" + this.f265854a + ", timestamp=" + this.f265855b + ")";
    }

    public a(double r100, long r101) {
        this.f265854a = r100;
        this.f265855b = r101;
    }
}
