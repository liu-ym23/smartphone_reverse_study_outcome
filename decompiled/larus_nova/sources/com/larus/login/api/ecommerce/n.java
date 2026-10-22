package com.larus.login.api.ecommerce;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f357035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f357036b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f357035a == r101.f357035a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f357036b, r101.f357036b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f357035a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        m r102 = this.f357036b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "EcomTextConfigCacheEnvelope(cachedAtMs=" + this.f357035a + ", data=" + this.f357036b + ')';
    }

    public n(long r100, m r101) {
        this.f357035a = r100;
        this.f357036b = r101;
    }
}
