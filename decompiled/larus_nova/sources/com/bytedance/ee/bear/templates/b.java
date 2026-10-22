package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f238841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f238843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f238844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f238845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f238846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f238847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f238848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f238849i;

    public b() {
        this(null, null, null, null, null, 0, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f238841a, r101.f238841a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f238842b, r101.f238842b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f238843c, r101.f238843c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f238844d, r101.f238844d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f238845e, r101.f238845e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f238846f, r101.f238846f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f238847g, r101.f238847g) == true) goto L30;
        return false;
    L30:
        if (this.f238848h == r101.f238848h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f238849i, r101.f238849i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f238841a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f238842b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f238843c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f238844d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f238845e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f238846f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f238847g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.f238848h) * 31;
        String r122 = this.f238849i;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "SetTemplateClickReportParams(clickType=" + this.f238841a + ", templateToken=" + this.f238842b + ", templateName=" + this.f238843c + ", setId=" + this.f238844d + ", templateCenterSource=" + this.f238845e + ", folderToken=" + this.f238846f + ", fileId=" + this.f238847g + ", objType=" + this.f238848h + ", templateType=" + this.f238849i + ')';
    }

    public /* synthetic */ b(String r110, String r111, String r112, String r113, String r114, int r115, String r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r116 = "";
    L31:
        if ((r211 & 128) == 0) goto L33;
        int r117 = -1;
    L35:
        if ((r211 & 256) == 0) goto L37;
        String r118 = "";
    L38:
        this(r100, r101, r102, r103, r104, r105, r116, r117, r118);
        return;
    L37:
        r118 = r210;
        goto L38
    L33:
        r117 = r115;
        goto L35
    L29:
        r116 = null;
        goto L31
    L25:
        r105 = null;
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

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r107, String r108) {
        this.f238841a = r100;
        this.f238842b = r101;
        this.f238843c = r102;
        this.f238844d = r103;
        this.f238845e = r104;
        this.f238846f = r105;
        this.f238847g = r106;
        this.f238848h = r107;
        this.f238849i = r108;
    }
}
