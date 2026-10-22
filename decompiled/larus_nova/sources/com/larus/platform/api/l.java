package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f365198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f365199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f365201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f365202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f365203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f365204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f365205h;

    public l() {
        this(null, 0, 0, 0, 0, 0, -1, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f365198a, r101.f365198a) == true) goto L12;
        return false;
    L12:
        if (this.f365199b == r101.f365199b) goto L15;
        return false;
    L15:
        if (this.f365200c == r101.f365200c) goto L18;
        return false;
    L18:
        if (this.f365201d == r101.f365201d) goto L21;
        return false;
    L21:
        if (this.f365202e == r101.f365202e) goto L24;
        return false;
    L24:
        if (this.f365203f == r101.f365203f) goto L27;
        return false;
    L27:
        if (this.f365204g == r101.f365204g) goto L30;
        return false;
    L30:
        if (this.f365205h == r101.f365205h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f365198a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f365199b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f365200c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f365201d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f365202e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f365203f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f365204g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f365205h;
        return r113 + ((int) (r114 ^ (r114 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ColdLaunchTimeline(appRealInitTime=" + this.f365198a + ", appAttachEndTime=" + this.f365199b + ", appOnCreateStartTime=" + this.f365200c + ", appOnCreateEndTime=" + this.f365201d + ", mainActivityCreateTime=" + this.f365202e + ", mainActivityResumeTime=" + this.f365203f + ", mainFirstFrameDuration=" + this.f365204g + ", chatFirstFrameDuration=" + this.f365205h + ')';
    }

    public l(Long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112) {
        this.f365198a = r100;
        this.f365199b = r101;
        this.f365200c = r102;
        this.f365201d = r103;
        this.f365202e = r104;
        this.f365203f = r110;
        this.f365204g = r111;
        this.f365205h = r112;
    }
}
