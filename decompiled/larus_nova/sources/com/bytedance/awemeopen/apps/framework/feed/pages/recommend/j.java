package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f195143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f195144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f195145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f195146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f195147e;

    public j() {
        this(null, 0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f195143a, r101.f195143a) == true) goto L12;
        return false;
    L12:
        if (this.f195144b == r101.f195144b) goto L15;
        return false;
    L15:
        if (this.f195145c == r101.f195145c) goto L18;
        return false;
    L18:
        if (this.f195146d == r101.f195146d) goto L21;
        return false;
    L21:
        if (this.f195147e == r101.f195147e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f195143a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.f195144b) * 31) + this.f195145c) * 31) + this.f195146d) * 31;
        long r103 = this.f195147e;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HostCoverParam(hostCoverUrl=" + this.f195143a + ", hostCoverWidth=" + this.f195144b + ", hostCoverHeight=" + this.f195145c + ", excludedHeight=" + this.f195146d + ", doubleBallLoadingDelay=" + this.f195147e + ')';
    }

    public j(String r100, int r101, int r102, int r103, long r104) {
        this.f195143a = r100;
        this.f195144b = r101;
        this.f195145c = r102;
        this.f195146d = r103;
        this.f195147e = r104;
    }
}
