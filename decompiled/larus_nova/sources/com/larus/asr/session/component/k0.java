package com.larus.asr.session.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f287749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f287750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f287751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.audio.asr.c0 f287752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f287753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f287754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f287755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d58.a f287756h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f287749a, r101.f287749a) == true) goto L12;
        return false;
    L12:
        if (this.f287750b == r101.f287750b) goto L15;
        return false;
    L15:
        if (this.f287751c == r101.f287751c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f287752d, r101.f287752d) == true) goto L21;
        return false;
    L21:
        if (this.f287753e == r101.f287753e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f287754f, r101.f287754f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f287755g, r101.f287755g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f287756h, r101.f287756h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f287749a.hashCode() * 31;
        int r101 = 1231;
        if (this.f287750b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f287751c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((r103 + r101) * 31) + this.f287752d.hashCode()) * 31;
        long r105 = this.f287753e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        Long r107 = this.f287754f;
        int r108 = 0;
        if (r107 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r106 + r109) * 31;
        Integer r111 = this.f287755g;
        if (r111 == null) goto L19;
        r108 = r111.hashCode();
    L19:
        return ((r110 + r108) * 31) + this.f287756h.hashCode();
    L13:
        r109 = r107.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatAsrSessionRequest(itemId=" + this.f287749a + ", fromTextArea=" + this.f287750b + ", needVibrate=" + this.f287751c + ", traceInfo=" + this.f287752d + ", startTime=" + this.f287753e + ", preStartTime=" + this.f287754f + ", vuiId=" + this.f287755g + ", durationConfig=" + this.f287756h + ')';
    }

    public k0(String r100, boolean r101, boolean r102, com.larus.audio.asr.c0 r103, long r104, Long r105, Integer r106, d58.a r110) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        Intrinsics.checkNotNullParameter(r110, "durationConfig");
        this.f287749a = r100;
        this.f287750b = r101;
        this.f287751c = r102;
        this.f287752d = r103;
        this.f287753e = r104;
        this.f287754f = r105;
        this.f287755g = r106;
        this.f287756h = r110;
    }
}
