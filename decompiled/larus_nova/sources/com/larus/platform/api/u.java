package com.larus.platform.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f365284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FlowDriveFileType f365285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f365287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f365288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f365289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f365290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f365291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f365292m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f365280a, r101.f365280a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365281b, r101.f365281b) == true) goto L15;
        return false;
    L15:
        if (this.f365282c == r101.f365282c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365283d, r101.f365283d) == true) goto L21;
        return false;
    L21:
        if (this.f365284e == r101.f365284e) goto L24;
        return false;
    L24:
        if (this.f365285f == r101.f365285f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365286g, r101.f365286g) == true) goto L30;
        return false;
    L30:
        if (this.f365287h == r101.f365287h) goto L33;
        return false;
    L33:
        if (this.f365288i == r101.f365288i) goto L36;
        return false;
    L36:
        if (this.f365289j == r101.f365289j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f365290k, r101.f365290k) == true) goto L42;
        return false;
    L42:
        if (this.f365291l == r101.f365291l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f365292m, r101.f365292m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f365280a.hashCode() * 31) + this.f365281b.hashCode()) * 31;
        long r101 = this.f365282c;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f365283d.hashCode()) * 31) + this.f365284e) * 31) + this.f365285f.hashCode()) * 31;
        String r103 = this.f365286g;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((r102 + r105) * 31) + this.f365287h) * 31;
        long r107 = this.f365288i;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f365289j;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f365290k;
        if (r111 != null) goto L9;
        int r112 = 0;
    L10:
        int r113 = (((r110 + r112) * 31) + this.f365291l) * 31;
        Map<String, String> r114 = this.f365292m;
        if (r114 == null) goto L15;
        r104 = r114.hashCode();
    L15:
        return r113 + r104;
    L9:
        r112 = r111.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowSelectedFileItem(fileUri=" + this.f365280a + ", fileName=" + this.f365281b + ", fileSize=" + this.f365282c + ", visitTime=" + this.f365283d + ", iconRes=" + this.f365284e + ", fileType=" + this.f365285f + ", fileUrl=" + this.f365286g + ", ccmType=" + this.f365287h + ", openTime=" + this.f365288i + ", editTime=" + this.f365289j + ", iconInfo=" + this.f365290k + ", isOwner=" + this.f365291l + ", extra=" + this.f365292m + ')';
    }

    public static u a(u r210, long r211, Map r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = r210.f365280a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r210.f365281b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = r210.f365282c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r103 = r210.f365283d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r110 = r210.f365284e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        FlowDriveFileType r111 = r210.f365285f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r112 = r210.f365286g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r113 = r210.f365287h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        long r114 = r210.f365288i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        long r115 = r210.f365289j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        String r104 = r210.f365290k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        int r105 = r210.f365291l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        Map r214 = r210.f365292m;
    L54:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r100, "fileUri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r103, "visitTime");
        Intrinsics.checkNotNullParameter(r111, "fileType");
        return new u(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r104, r105, r214);
    L53:
        r214 = r212;
        goto L54
    L49:
        r105 = 0;
        goto L51
    L45:
        r104 = null;
        goto L47
    L41:
        r115 = 0;
        goto L43
    L37:
        r114 = 0;
        goto L39
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = 0;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public /* synthetic */ u(String r210, String r211, long r212, String r213, int r214, FlowDriveFileType r215, String r216, int r217, Map r310, int r311) {
        if ((r311 & 4) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r311 & 32) == 0) goto L9;
        FlowDriveFileType r110 = FlowDriveFileType.FILE;
    L11:
        if ((r311 & 64) == 0) goto L13;
        String r111 = null;
    L15:
        if ((r311 & 128) == 0) goto L17;
        int r112 = 12;
    L19:
        if ((r311 & 2048) == 0) goto L21;
        int r113 = 1;
    L23:
        if ((r311 & 4096) == 0) goto L25;
        Map r114 = null;
    L26:
        this(r210, r211, r100, r213, r214, r110, r111, r112, 0, 0, null, r113, r114);
        return;
    L25:
        r114 = r310;
        goto L26
    L21:
        r113 = 0;
        goto L23
    L17:
        r112 = r217;
        goto L19
    L13:
        r111 = r216;
        goto L15
    L9:
        r110 = r215;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public u(String r100, String r101, long r102, String r110, int r111, FlowDriveFileType r112, String r113, int r114, long r115, long r116, String r210, int r211, Map<String, String> r212) {
        Intrinsics.checkNotNullParameter(r100, "fileUri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r110, "visitTime");
        Intrinsics.checkNotNullParameter(r112, "fileType");
        this.f365280a = r100;
        this.f365281b = r101;
        this.f365282c = r102;
        this.f365283d = r110;
        this.f365284e = r111;
        this.f365285f = r112;
        this.f365286g = r113;
        this.f365287h = r114;
        this.f365288i = r115;
        this.f365289j = r116;
        this.f365290k = r210;
        this.f365291l = r211;
        this.f365292m = r212;
    }
}
