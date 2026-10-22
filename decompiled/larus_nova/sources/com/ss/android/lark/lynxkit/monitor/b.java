package com.ss.android.lark.lynxkit.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f431521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f431522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f431523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f431524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f431525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f431526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f431527i;

    public b() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f431519a, r101.f431519a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431520b, r101.f431520b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f431521c, r101.f431521c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f431522d, r101.f431522d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f431523e, r101.f431523e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f431524f, r101.f431524f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f431525g, r101.f431525g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f431526h, r101.f431526h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f431527i, r101.f431527i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f431519a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f431520b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f431521c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f431522d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f431523e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f431524f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f431525g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f431526h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f431527i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "LynxKitMonitorInfo(templateUrl=" + this.f431519a + ", templatePath=" + this.f431520b + ", pageUrl=" + this.f431521c + ", renderSource=" + this.f431522d + ", tagForTemplateLoader=" + this.f431523e + ", tagForJsModule=" + this.f431524f + ", tagForBridgeMethodDispatcher=" + this.f431525g + ", tagForBridgeMethodGroup=" + this.f431526h + ", tagForCustomComponent=" + this.f431527i + ')';
    }

    public /* synthetic */ b(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r212 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r212 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r212 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r212 & 64) == 0) goto L25;
        String r116 = null;
    L27:
        if ((r212 & 128) == 0) goto L29;
        String r117 = null;
    L31:
        if ((r212 & 256) == 0) goto L33;
        String r118 = null;
    L34:
        this(r100, r101, null, r102, r103, r104, r116, r117, r118);
        return;
    L33:
        r118 = r211;
        goto L34
    L29:
        r117 = r210;
        goto L31
    L25:
        r116 = r115;
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
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.f431519a = r100;
        this.f431520b = r101;
        this.f431521c = r102;
        this.f431522d = r103;
        this.f431523e = r104;
        this.f431524f = r105;
        this.f431525g = r106;
        this.f431526h = r107;
        this.f431527i = r108;
    }
}
