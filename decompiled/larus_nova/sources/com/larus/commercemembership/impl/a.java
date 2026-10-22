package com.larus.commercemembership.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f325842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f325843b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f325842a, r101.f325842a) == true) goto L12;
        return false;
    L12:
        if (this.f325843b == r101.f325843b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325842a.hashCode() * 31;
        long r101 = this.f325843b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ActivePcGuidePushBannerRequest(request=" + this.f325842a + ", expireAtElapsedRealtimeMs=" + this.f325843b + ')';
    }

    public a(i r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f325842a = r100;
        this.f325843b = r101;
    }
}
