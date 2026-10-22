package com.larus.commercemembership.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tc9.e f325872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f325874c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f325872a, r101.f325872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325873b, r101.f325873b) == true) goto L15;
        return false;
    L15:
        if (this.f325874c == r101.f325874c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325872a.hashCode() * 31;
        String r101 = this.f325873b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f325874c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingPcGuidePushBanner(banner=" + this.f325872a + ", source=" + this.f325873b + ", expireAtElapsedRealtimeMs=" + this.f325874c + ')';
    }

    public k(tc9.e r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "banner");
        this.f325872a = r100;
        this.f325873b = r101;
        this.f325874c = r102;
    }
}
