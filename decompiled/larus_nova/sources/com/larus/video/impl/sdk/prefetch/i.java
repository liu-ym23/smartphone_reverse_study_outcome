package com.larus.video.impl.sdk.prefetch;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f375869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f375870b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f375869a == r101.f375869a) goto L12;
        return false;
    L12:
        if (this.f375870b == r101.f375870b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f375869a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f375870b;
    }

    public final String toString() {
        return "CachedRefreshCount(cacheValidTimeStamp=" + this.f375869a + ", refreshCount=" + this.f375870b + ')';
    }

    public i(long r100, int r101) {
        this.f375869a = r100;
        this.f375870b = r101;
    }
}
