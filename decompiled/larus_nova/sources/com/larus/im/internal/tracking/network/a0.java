package com.larus.im.internal.tracking.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkTrackOutcome f350333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f350334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f350335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f350336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f350337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f350338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f350339g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f350333a == r101.f350333a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350334b, r101.f350334b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350335c, r101.f350335c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350336d, r101.f350336d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350337e, r101.f350337e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f350338f, r101.f350338f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f350339g, r101.f350339g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f350333a.hashCode() * 31;
        Long r101 = this.f350334b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f350335c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f350336d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        s r111 = this.f350337e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Long r114 = this.f350338f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f350339g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetworkTrackTerminalResult(outcome=" + this.f350333a + ", statusCode=" + this.f350334b + ", errorCode=" + this.f350335c + ", logId=" + this.f350336d + ", metrics=" + this.f350337e + ", requestBodyBytes=" + this.f350338f + ", responseBodyBytes=" + this.f350339g + ')';
    }

    public /* synthetic */ a0(NetworkTrackOutcome r100, Long r110, int r111) {
        if ((r111 & 64) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, null, null, null, null, null, r110);
    }

    public a0(NetworkTrackOutcome r100, Long r101, Long r102, String r103, s r104, Long r105, Long r106) {
        Intrinsics.checkNotNullParameter(r100, "outcome");
        this.f350333a = r100;
        this.f350334b = r101;
        this.f350335c = r102;
        this.f350336d = r103;
        this.f350337e = r104;
        this.f350338f = r105;
        this.f350339g = r106;
    }
}
