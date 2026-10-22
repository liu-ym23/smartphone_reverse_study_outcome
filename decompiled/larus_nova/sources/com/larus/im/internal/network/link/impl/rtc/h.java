package com.larus.im.internal.network.link.impl.rtc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RTCConnectRetryReason f349315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f349316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f349317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RTCConnectRetryAction f349318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f349319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f349320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f349321g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f349315a == r101.f349315a) goto L12;
        return false;
    L12:
        if (this.f349316b == r101.f349316b) goto L15;
        return false;
    L15:
        if (this.f349317c == r101.f349317c) goto L18;
        return false;
    L18:
        if (this.f349318d == r101.f349318d) goto L21;
        return false;
    L21:
        if (this.f349319e == r101.f349319e) goto L24;
        return false;
    L24:
        if (this.f349320f == r101.f349320f) goto L27;
        return false;
    L27:
        if (this.f349321g == r101.f349321g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f349315a.hashCode() * 31) + this.f349316b) * 31;
        long r101 = this.f349317c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f349318d.hashCode()) * 31;
        int r103 = 1231;
        if (this.f349319e == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f349320f == true) goto L10;
        r103 = 1237;
    L10:
        long r106 = this.f349321g;
        return ((r105 + r103) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "RTCConnectRetryPlan(reason=" + this.f349315a + ", attempt=" + this.f349316b + ", delayMs=" + this.f349317c + ", action=" + this.f349318d + ", clearTokenCache=" + this.f349319e + ", recoverEngine=" + this.f349320f + ", deadlineMs=" + this.f349321g + ')';
    }

    public h(RTCConnectRetryReason r100, int r101, long r102, RTCConnectRetryAction r103, boolean r104, boolean r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r103, "action");
        this.f349315a = r100;
        this.f349316b = r101;
        this.f349317c = r102;
        this.f349318d = r103;
        this.f349319e = r104;
        this.f349320f = r105;
        this.f349321g = r106;
    }
}
