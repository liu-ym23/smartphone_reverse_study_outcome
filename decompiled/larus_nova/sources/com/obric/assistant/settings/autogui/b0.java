package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricAutoGuiItemViewType f391897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricAutoGuiItemBgType f391898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f391900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.obric.assistant.settings.b f391901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f391902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f391903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f391904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f391905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f391906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f391907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f391908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f391909m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (this.f391897a == r101.f391897a) goto L12;
        return false;
    L12:
        if (this.f391898b == r101.f391898b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391899c, r101.f391899c) == true) goto L18;
        return false;
    L18:
        if (this.f391900d == r101.f391900d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f391901e, r101.f391901e) == true) goto L24;
        return false;
    L24:
        if (this.f391902f == r101.f391902f) goto L27;
        return false;
    L27:
        if (this.f391903g == r101.f391903g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f391904h, r101.f391904h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f391905i, r101.f391905i) == true) goto L36;
        return false;
    L36:
        if (this.f391906j == r101.f391906j) goto L39;
        return false;
    L39:
        if (this.f391907k == r101.f391907k) goto L42;
        return false;
    L42:
        if (this.f391908l == r101.f391908l) goto L45;
        return false;
    L45:
        if (this.f391909m == r101.f391909m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f391897a.hashCode() * 31) + this.f391898b.hashCode()) * 31) + this.f391899c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f391900d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        com.obric.assistant.settings.b r104 = this.f391901e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f391902f == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f391903g == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((((r108 + r109) * 31) + this.f391904h.hashCode()) * 31) + this.f391905i.hashCode()) * 31;
        if (this.f391906j == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f391907k == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (r112 + r113) * 31;
        if (this.f391908l == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (r114 + r115) * 31;
        if (this.f391909m == true) goto L35;
        r101 = 1237;
    L35:
        return r116 + r101;
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricAutoGuiItemUIModel(viewType=" + this.f391897a + ", bgType=" + this.f391898b + ", title=" + this.f391899c + ", beta=" + this.f391900d + ", appInfo=" + this.f391901e + ", autoGuiEnabled=" + this.f391902f + ", autoExecuteAuthEntryVisible=" + this.f391903g + ", riskPreferenceText=" + this.f391904h + ", fastModeUseText=" + this.f391905i + ", oUseClipboardEnabled=" + this.f391906j + ", skillExtensionAvailable=" + this.f391907k + ", skillExtensionEnabled=" + this.f391908l + ", showGoSettingArrow=" + this.f391909m + ')';
    }

    public static b0 a(b0 r110, boolean r111, String r210, int r211) {
        String r100 = null;
        if ((r211 & 1) == 0) goto L5;
        ObricAutoGuiItemViewType r101 = r110.f391897a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        ObricAutoGuiItemBgType r102 = r110.f391898b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r103 = r110.f391899c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        boolean r104 = r110.f391900d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        com.obric.assistant.settings.b r105 = r110.f391901e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        boolean r112 = r110.f391902f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        boolean r113 = r110.f391903g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        r100 = r110.f391904h;
    L33:
        String r114 = r100;
        if ((r211 & 256) == 0) goto L36;
        String r115 = r110.f391905i;
    L38:
        if ((r211 & 512) == 0) goto L40;
        boolean r116 = r110.f391906j;
    L42:
        if ((r211 & 1024) == 0) goto L44;
        boolean r117 = r110.f391907k;
    L46:
        if ((r211 & 2048) == 0) goto L48;
        boolean r118 = r110.f391908l;
    L50:
        if ((r211 & 4096) == 0) goto L52;
        boolean r119 = r110.f391909m;
    L53:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "viewType");
        Intrinsics.checkNotNullParameter(r102, "bgType");
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r114, "riskPreferenceText");
        Intrinsics.checkNotNullParameter(r115, "fastModeUseText");
        return new b0(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r118, r119);
    L52:
        r119 = false;
        goto L53
    L48:
        r118 = false;
        goto L50
    L44:
        r117 = false;
        goto L46
    L40:
        r116 = false;
        goto L42
    L36:
        r115 = r210;
        goto L38
    L29:
        r113 = false;
        goto L31
    L25:
        r112 = r111;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public b0(ObricAutoGuiItemViewType r100, ObricAutoGuiItemBgType r101, String r102, boolean r103, com.obric.assistant.settings.b r104, boolean r105, boolean r106, String r107, String r110, boolean r111, boolean r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        Intrinsics.checkNotNullParameter(r101, "bgType");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r107, "riskPreferenceText");
        Intrinsics.checkNotNullParameter(r110, "fastModeUseText");
        this.f391897a = r100;
        this.f391898b = r101;
        this.f391899c = r102;
        this.f391900d = r103;
        this.f391901e = r104;
        this.f391902f = r105;
        this.f391903g = r106;
        this.f391904h = r107;
        this.f391905i = r110;
        this.f391906j = r111;
        this.f391907k = r112;
        this.f391908l = r113;
        this.f391909m = r114;
    }

    public /* synthetic */ b0(ObricAutoGuiItemViewType r110, ObricAutoGuiItemBgType r111, String r112, boolean r210, com.obric.assistant.settings.b r211, boolean r212, boolean r213, String r214, String r215, boolean r216, boolean r217, boolean r218, boolean r219, int r310) {
        if ((r310 & 2) == 0) goto L5;
        ObricAutoGuiItemBgType r100 = ObricAutoGuiItemBgType.NONE;
    L7:
        if ((r310 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r310 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r310 & 16) == 0) goto L17;
        com.obric.assistant.settings.b r103 = null;
    L19:
        if ((r310 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r310 & 64) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r310 & 128) == 0) goto L29;
        String r113 = "";
    L31:
        if ((r310 & 256) == 0) goto L33;
        String r114 = "";
    L35:
        if ((r310 & 512) == 0) goto L37;
        boolean r115 = false;
    L39:
        if ((r310 & 1024) == 0) goto L41;
        boolean r116 = true;
    L43:
        if ((r310 & 2048) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r310 & 4096) == 0) goto L49;
        boolean r118 = false;
    L50:
        this(r110, r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118);
        return;
    L49:
        r118 = r219;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
