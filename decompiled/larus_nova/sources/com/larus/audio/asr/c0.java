package com.larus.audio.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f288368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f288369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f288370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f288371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f288372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f288373h;

    public c0() {
        String r100 = null;
        this(r100, r100, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f288366a, r101.f288366a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288367b, r101.f288367b) == true) goto L15;
        return false;
    L15:
        if (this.f288368c == r101.f288368c) goto L18;
        return false;
    L18:
        if (this.f288369d == r101.f288369d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f288370e, r101.f288370e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f288371f, r101.f288371f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f288372g, r101.f288372g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f288373h, r101.f288373h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f288366a.hashCode() * 31) + this.f288367b.hashCode()) * 31) + this.f288368c) * 31) + this.f288369d) * 31;
        String r101 = this.f288370e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f288371f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f288372g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f288373h;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "AsrTraceInfo(traceId=" + this.f288366a + ", enterFrom=" + this.f288367b + ", isAudioComplement=" + this.f288368c + ", picCnt=" + this.f288369d + ", enterMethod=" + this.f288370e + ", showScene=" + this.f288371f + ", currentPage=" + this.f288372g + ", endStatus=" + this.f288373h + ')';
    }

    public /* synthetic */ c0(String r110, String r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r113 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r113 & 64) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r113 & 128) == 0) goto L25;
        String r114 = "";
    L26:
        this(r100, r101, r102, 0, null, r103, r104, r114);
        return;
    L25:
        r114 = null;
        goto L26
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static c0 a(c0 r110, int r111, String r112, String r113, String r114, String r115, int r116) {
        String r100 = null;
        if ((r116 & 1) == 0) goto L5;
        String r101 = r110.f288366a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        r100 = r110.f288367b;
    L9:
        String r102 = r100;
        if ((r116 & 4) == 0) goto L12;
        int r103 = r110.f288368c;
    L14:
        if ((r116 & 8) == 0) goto L16;
        int r104 = r110.f288369d;
    L18:
        if ((r116 & 16) == 0) goto L20;
        String r105 = r110.f288370e;
    L22:
        if ((r116 & 32) == 0) goto L24;
        String r117 = r110.f288371f;
    L26:
        if ((r116 & 64) == 0) goto L28;
        String r118 = r110.f288372g;
    L30:
        if ((r116 & 128) == 0) goto L32;
        String r119 = r110.f288373h;
    L33:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "traceId");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        return new c0(r101, r102, r103, r104, r105, r117, r118, r119);
    L32:
        r119 = r115;
        goto L33
    L28:
        r118 = r114;
        goto L30
    L24:
        r117 = r113;
        goto L26
    L20:
        r105 = r112;
        goto L22
    L16:
        r104 = r111;
        goto L18
    L12:
        r103 = 0;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public c0(String r100, String r101, int r102, int r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f288366a = r100;
        this.f288367b = r101;
        this.f288368c = r102;
        this.f288369d = r103;
        this.f288370e = r104;
        this.f288371f = r105;
        this.f288372g = r106;
        this.f288373h = r107;
    }
}
