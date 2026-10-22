package com.larus.video.impl.sdk.prefetch;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f375849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f375850b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f375849a == r101.f375849a) goto L12;
        return false;
    L12:
        if (this.f375850b == r101.f375850b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f375849a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f375850b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "CachedFirstClickCardData(cacheValidTimeStamp=" + this.f375849a + ", isFirstClickMessage=" + this.f375850b + ')';
    }

    public c(long r100) {
        this.f375849a = r100;
        this.f375850b = false;
    }
}
