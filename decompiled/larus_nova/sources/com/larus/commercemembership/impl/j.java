package com.larus.commercemembership.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f325870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f325871b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f325870a, r101.f325870a) == true) goto L12;
        return false;
    L12:
        if (this.f325871b == r101.f325871b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325870a.hashCode() * 31;
        long r101 = this.f325871b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PcGuidePushBannerTrigger(request=" + this.f325870a + ", expireAtElapsedRealtimeMs=" + this.f325871b + ')';
    }

    public j(i r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f325870a = r100;
        this.f325871b = r101;
    }
}
