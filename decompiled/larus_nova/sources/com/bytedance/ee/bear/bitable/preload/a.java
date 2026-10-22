package com.bytedance.ee.bear.bitable.preload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f214979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f214980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f214981c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f214979a == r101.f214979a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f214980b, r101.f214980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f214981c, r101.f214981c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f214979a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f214980b.hashCode()) * 31) + this.f214981c.hashCode();
    }

    public final String toString() {
        return "BaseAppJsDispatchMeta(expireAtMs=" + this.f214979a + ", preloadTag=" + this.f214980b + ", from=" + this.f214981c + ')';
    }

    public a(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "preloadTag");
        Intrinsics.checkNotNullParameter(r102, "from");
        this.f214979a = r100;
        this.f214980b = r101;
        this.f214981c = r102;
    }
}
