package com.larus.disk.impl;

/* JADX INFO: loaded from: classes27.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f330820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f330821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f330822c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (this.f330820a == r101.f330820a) goto L12;
        return false;
    L12:
        if (this.f330821b == r101.f330821b) goto L15;
        return false;
    L15:
        if (this.f330822c == r101.f330822c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f330820a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f330821b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f330822c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "SystemStorageInfo(appBytes=" + this.f330820a + ", dataBytes=" + this.f330821b + ", cacheBytes=" + this.f330822c + ')';
    }

    public t0(long r100, long r101, long r102) {
        this.f330820a = r100;
        this.f330821b = r101;
        this.f330822c = r102;
    }
}
