package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f435403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f435404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f435405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f435406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f435407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f435408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f435409j;

    public b() {
        this(null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f435400a, r101.f435400a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435401b, r101.f435401b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435402c, r101.f435402c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435403d, r101.f435403d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435404e, r101.f435404e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435405f, r101.f435405f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435406g, r101.f435406g) == true) goto L30;
        return false;
    L30:
        if (this.f435407h == r101.f435407h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f435408i, r101.f435408i) == true) goto L36;
        return false;
    L36:
        if (this.f435409j == r101.f435409j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f435400a.hashCode() * 31) + this.f435401b.hashCode()) * 31) + this.f435402c.hashCode()) * 31) + this.f435403d.hashCode()) * 31) + this.f435404e.hashCode()) * 31) + this.f435405f.hashCode()) * 31) + this.f435406g.hashCode()) * 31;
        int r101 = 1231;
        if (this.f435407h == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f435408i.hashCode()) * 31;
        if (this.f435409j == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmD1204RecordingEventMetadata(hardwareUniqueId=" + this.f435400a + ", sessionId=" + this.f435401b + ", hardwareDeviceId=" + this.f435402c + ", recordingSource=" + this.f435403d + ", recordingTraceId=" + this.f435404e + ", userId=" + this.f435405f + ", tenantId=" + this.f435406g + ", hardwareStarted=" + this.f435407h + ", onlineMeetingId=" + this.f435408i + ", onlineTokenReady=" + this.f435409j + ')';
    }

    public /* synthetic */ b(String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r111 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r111 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r111 & 256) == 0) goto L33;
        String r112 = "";
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, false, r112, false);
        return;
    L33:
        r112 = null;
        goto L34
    L29:
        r106 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r103, "recordingSource");
        Intrinsics.checkNotNullParameter(r104, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r105, "userId");
        Intrinsics.checkNotNullParameter(r106, "tenantId");
        Intrinsics.checkNotNullParameter(r110, "onlineMeetingId");
        this.f435400a = r100;
        this.f435401b = r101;
        this.f435402c = r102;
        this.f435403d = r103;
        this.f435404e = r104;
        this.f435405f = r105;
        this.f435406g = r106;
        this.f435407h = r107;
        this.f435408i = r110;
        this.f435409j = r111;
    }

    public static b a(b r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, String r118, boolean r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = r110.f435400a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.f435401b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = r110.f435402c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = r110.f435403d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r104 = r110.f435404e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r105 = r110.f435405f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r106 = r110.f435406g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        boolean r107 = r110.f435407h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        String r119 = r110.f435408i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        boolean r108 = r110.f435409j;
    L42:
        Intrinsics.checkNotNullParameter(r100, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r103, "recordingSource");
        Intrinsics.checkNotNullParameter(r104, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r105, "userId");
        Intrinsics.checkNotNullParameter(r106, "tenantId");
        Intrinsics.checkNotNullParameter(r119, "onlineMeetingId");
        return new b(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r210;
        goto L42
    L37:
        r119 = r118;
        goto L39
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = null;
        goto L7
    }
}
