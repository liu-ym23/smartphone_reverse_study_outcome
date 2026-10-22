package com.larus.video.impl.sdk.prefetch;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f375845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f375846b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f375845a == r101.f375845a) goto L12;
        return false;
    L12:
        if (this.f375846b == r101.f375846b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f375845a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f375846b == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "CachedFirstBindPreloadData(cacheValidTimeStamp=" + this.f375845a + ", isFirstBindPreload=" + this.f375846b + ')';
    }

    public a(long r100) {
        this.f375845a = r100;
        this.f375846b = false;
    }
}
