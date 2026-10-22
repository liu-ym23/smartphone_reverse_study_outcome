package com.larus.disk.impl;

/* JADX INFO: loaded from: classes27.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f330829b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f330828a == r101.f330828a) goto L12;
        return false;
    L12:
        if (this.f330829b == r101.f330829b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330828a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f330829b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "DeviceStorageInfo(totalBytes=" + this.f330828a + ", availableBytes=" + this.f330829b + ')';
    }

    public final String a() {
        long r100 = this.f330828a;
        if (r100 > 34359738368L) goto L6;
        return "0_32_gib";
    L6:
        if (r100 > 68719476736L) goto L9;
        return "32_64_gib";
    L9:
        if (r100 > 137438953472L) goto L12;
        return "64_128_gib";
    L12:
        if (r100 > 274877906944L) goto L14;
        return "128_256_gib";
    L14:
        return "256_gib_plus";
    }

    public y(long r100, long r101) {
        this.f330828a = r100;
        this.f330829b = r101;
    }
}
