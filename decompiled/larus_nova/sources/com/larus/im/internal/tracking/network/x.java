package com.larus.im.internal.tracking.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f350442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f350443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f350445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f350446e;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f350442a, r101.f350442a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350443b, r101.f350443b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350444c, r101.f350444c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350445d, r101.f350445d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350446e, r101.f350446e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f350442a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f350443b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f350444c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f350445d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f350446e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetworkTrackResponse(statusCode=" + this.f350442a + ", errorCode=" + this.f350443b + ", logId=" + this.f350444c + ", requestBodyBytes=" + this.f350445d + ", responseBodyBytes=" + this.f350446e + ')';
    }

    public /* synthetic */ x(int r100) {
        this(null, null, null, null, null);
    }

    public x(Long r100, Long r101, String r102, Long r103, Long r104) {
        this.f350442a = r100;
        this.f350443b = r101;
        this.f350444c = r102;
        this.f350445d = r103;
        this.f350446e = r104;
    }
}
