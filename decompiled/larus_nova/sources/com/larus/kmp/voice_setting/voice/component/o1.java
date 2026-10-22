package com.larus.kmp.voice_setting.voice.component;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o1 implements m1a.d {
    public final y5 A;
    public final VoiceDialogKind B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f352410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceDialogKind f352411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f352412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f352413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.dialog.h f352414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.dialog.w1 f352415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.dialog.s2 f352416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.dialog.v2.g f352417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e0 f352418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e0 f352419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e0 f352420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k0 f352421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l0 f352422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f352423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f352424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f352425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f352426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f352427r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f352428s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f352429t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f352430u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f352431v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f352432w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f352433x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r f352434y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final r f352435z;

    public o1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (this.f352410a == r101.f352410a) goto L12;
        return false;
    L12:
        if (this.f352411b == r101.f352411b) goto L15;
        return false;
    L15:
        if (this.f352412c == r101.f352412c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352413d, r101.f352413d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352414e, r101.f352414e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352415f, r101.f352415f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352416g, r101.f352416g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352417h, r101.f352417h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352418i, r101.f352418i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352419j, r101.f352419j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352420k, r101.f352420k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f352421l, r101.f352421l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f352422m, r101.f352422m) == true) goto L48;
        return false;
    L48:
        if (this.f352423n == r101.f352423n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f352424o, r101.f352424o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f352425p, r101.f352425p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f352426q, r101.f352426q) == true) goto L60;
        return false;
    L60:
        if (this.f352427r == r101.f352427r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f352428s, r101.f352428s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f352429t, r101.f352429t) == true) goto L69;
        return false;
    L69:
        if (this.f352430u == r101.f352430u) goto L72;
        return false;
    L72:
        if (this.f352431v == r101.f352431v) goto L75;
        return false;
    L75:
        if (this.f352432w == r101.f352432w) goto L78;
        return false;
    L78:
        if (this.f352433x == r101.f352433x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f352434y, r101.f352434y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f352435z, r101.f352435z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f352410a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f352411b.hashCode()) * 31;
        long r103 = this.f352412c;
        int r104 = (((((((((((((((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f352413d.hashCode()) * 31) + this.f352414e.hashCode()) * 31) + this.f352415f.hashCode()) * 31) + this.f352416g.hashCode()) * 31) + this.f352417h.hashCode()) * 31) + this.f352418i.hashCode()) * 31) + this.f352419j.hashCode()) * 31) + this.f352420k.hashCode()) * 31) + this.f352421l.hashCode()) * 31) + this.f352422m.hashCode()) * 31;
        if (this.f352423n == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r104 + r105) * 31) + this.f352424o.hashCode()) * 31;
        String r107 = this.f352425p;
        int r108 = 0;
        if (r107 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r106 + r109) * 31;
        String r111 = this.f352426q;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f352427r == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        String r116 = this.f352428s;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f352429t;
        if (r119 == null) goto L30;
        r108 = r119.hashCode();
    L30:
        int r120 = (r118 + r108) * 31;
        if (this.f352430u == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f352431v == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (r122 + r123) * 31;
        if (this.f352432w == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        if (this.f352433x == true) goto L47;
        r100 = 1237;
    L47:
        return ((((((((r126 + r100) * 31) + this.f352434y.hashCode()) * 31) + this.f352435z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode();
    L41:
        r125 = 1237;
        goto L42
    L37:
        r123 = 1237;
        goto L38
    L33:
        r121 = 1237;
        goto L34
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceDialogStateData(visible=" + this.f352410a + ", activeDialogKind=" + this.f352411b + ", requestToken=" + this.f352412c + ", args=" + this.f352413d + ", authorizeState=" + this.f352414e + ", editState=" + this.f352415f + ", optimizeState=" + this.f352416g + ", createState=" + this.f352417h + ", deleteConfirmState=" + this.f352418i + ", clearConfirmState=" + this.f352419j + ", infoConfirmState=" + this.f352420k + ", nameInputState=" + this.f352421l + ", photoPreviewState=" + this.f352422m + ", loading=" + this.f352423n + ", localVoiceId=" + this.f352424o + ", filePath=" + this.f352425p + ", freeTalkContent=" + this.f352426q + ", isPublic=" + this.f352427r + ", avatarUri=" + this.f352428s + ", avatarUrl=" + this.f352429t + ", editIsDefaultName=" + this.f352430u + ", editIsDefaultAvatar=" + this.f352431v + ", editRequiresModifyInfo=" + this.f352432w + ", optimizeAvatarIsDefault=" + this.f352433x + ", flowDraft=" + this.f352434y + ", originalFlowDraft=" + this.f352435z + ", recordSession=" + this.A + ", returnDialogKind=" + this.B + ')';
    }

    public /* synthetic */ o1(int r310) {
        VoiceDialogKind r210 = VoiceDialogKind.NONE;
        this(false, r210, 0, new d0(null, null, null, null, null, null, 255), new com.larus.kmp.voice_setting.voice.dialog.h(0), new com.larus.kmp.voice_setting.voice.dialog.w1(0), new com.larus.kmp.voice_setting.voice.dialog.s2(null, null, null, null, null, null, null, null, null, null, null, false, null, 131071), new com.larus.kmp.voice_setting.voice.dialog.v2.g(0), new e0(null, null, null, null, 15), new e0(null, null, null, null, 15), new e0(null, null, null, null, 15), new k0(null, null, null, null, false, 127), new l0(0), false, "", null, null, false, null, null, true, true, false, false, new r(0), new r(0), new y5(0, 0, null, 255), r210);
    }

    public o1(boolean r110, VoiceDialogKind r111, long r112, d0 r210, com.larus.kmp.voice_setting.voice.dialog.h r211, com.larus.kmp.voice_setting.voice.dialog.w1 r212, com.larus.kmp.voice_setting.voice.dialog.s2 r213, com.larus.kmp.voice_setting.voice.dialog.v2.g r214, e0 r215, e0 r216, e0 r217, k0 r218, l0 r310, boolean r311, String r312, String r313, String r314, boolean r315, String r316, String r317, boolean r318, boolean r319, boolean r410, boolean r411, r r412, r r413, y5 r414, VoiceDialogKind r415) {
        Intrinsics.checkNotNullParameter(r111, "activeDialogKind");
        Intrinsics.checkNotNullParameter(r210, "args");
        Intrinsics.checkNotNullParameter(r211, "authorizeState");
        Intrinsics.checkNotNullParameter(r212, "editState");
        Intrinsics.checkNotNullParameter(r213, "optimizeState");
        Intrinsics.checkNotNullParameter(r214, "createState");
        Intrinsics.checkNotNullParameter(r215, "deleteConfirmState");
        Intrinsics.checkNotNullParameter(r216, "clearConfirmState");
        Intrinsics.checkNotNullParameter(r217, "infoConfirmState");
        Intrinsics.checkNotNullParameter(r218, "nameInputState");
        Intrinsics.checkNotNullParameter(r310, "photoPreviewState");
        Intrinsics.checkNotNullParameter(r312, "localVoiceId");
        Intrinsics.checkNotNullParameter(r412, "flowDraft");
        Intrinsics.checkNotNullParameter(r413, "originalFlowDraft");
        Intrinsics.checkNotNullParameter(r414, "recordSession");
        Intrinsics.checkNotNullParameter(r415, "returnDialogKind");
        this.f352410a = r110;
        this.f352411b = r111;
        this.f352412c = r112;
        this.f352413d = r210;
        this.f352414e = r211;
        this.f352415f = r212;
        this.f352416g = r213;
        this.f352417h = r214;
        this.f352418i = r215;
        this.f352419j = r216;
        this.f352420k = r217;
        this.f352421l = r218;
        this.f352422m = r310;
        this.f352423n = r311;
        this.f352424o = r312;
        this.f352425p = r313;
        this.f352426q = r314;
        this.f352427r = r315;
        this.f352428s = r316;
        this.f352429t = r317;
        this.f352430u = r318;
        this.f352431v = r319;
        this.f352432w = r410;
        this.f352433x = r411;
        this.f352434y = r412;
        this.f352435z = r413;
        this.A = r414;
        this.B = r415;
    }

    public static o1 a(o1 r110, boolean r111, VoiceDialogKind r210, long r211, d0 r212, com.larus.kmp.voice_setting.voice.dialog.h r213, com.larus.kmp.voice_setting.voice.dialog.w1 r214, com.larus.kmp.voice_setting.voice.dialog.s2 r215, com.larus.kmp.voice_setting.voice.dialog.v2.g r216, e0 r217, e0 r218, e0 r310, k0 r311, l0 r312, boolean r313, String r314, String r315, String r316, boolean r317, String r318, String r319, boolean r410, boolean r411, boolean r412, boolean r413, r r414, r r415, y5 r416, VoiceDialogKind r417, int r418) {
        if ((r418 & 1) == 0) goto L5;
        boolean r100 = r110.f352410a;
    L7:
        if ((r418 & 2) == 0) goto L9;
        VoiceDialogKind r101 = r110.f352411b;
    L11:
        if ((r418 & 4) == 0) goto L13;
        long r102 = r110.f352412c;
    L15:
        if ((r418 & 8) == 0) goto L17;
        d0 r103 = r110.f352413d;
    L19:
        if ((r418 & 16) == 0) goto L21;
        com.larus.kmp.voice_setting.voice.dialog.h r104 = r110.f352414e;
    L23:
        if ((r418 & 32) == 0) goto L25;
        com.larus.kmp.voice_setting.voice.dialog.w1 r105 = r110.f352415f;
    L27:
        if ((r418 & 64) == 0) goto L29;
        com.larus.kmp.voice_setting.voice.dialog.s2 r106 = r110.f352416g;
    L31:
        if ((r418 & 128) == 0) goto L33;
        com.larus.kmp.voice_setting.voice.dialog.v2.g r112 = r110.f352417h;
    L35:
        if ((r418 & 256) == 0) goto L37;
        e0 r113 = r110.f352418i;
    L39:
        if ((r418 & 512) == 0) goto L41;
        e0 r114 = r110.f352419j;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        e0 r115 = r110.f352420k;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        k0 r116 = r110.f352421l;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        l0 r117 = r110.f352422m;
    L54:
        long r219 = r102;
        if ((r418 & 8192) == 0) goto L57;
        boolean r107 = r110.f352423n;
    L59:
        if ((r418 & 16384) == 0) goto L61;
        String r108 = r110.f352424o;
    L62:
        boolean r320 = r107;
        if ((r418 & 32768) == 0) goto L65;
        String r109 = r110.f352425p;
    L66:
        String r321 = r109;
        if ((r418 & 65536) == 0) goto L69;
        String r118 = r110.f352426q;
    L70:
        String r322 = r118;
        if ((r418 & 131072) == 0) goto L73;
        boolean r119 = r110.f352427r;
    L74:
        boolean r323 = r119;
        if ((r418 & 262144) == 0) goto L77;
        String r120 = r110.f352428s;
    L78:
        String r324 = r120;
        if ((r418 & 524288) == 0) goto L81;
        String r121 = r110.f352429t;
    L82:
        String r325 = r121;
        if ((r418 & 1048576) == 0) goto L85;
        boolean r122 = r110.f352430u;
    L86:
        boolean r419 = r122;
        if ((r418 & 2097152) == 0) goto L89;
        boolean r123 = r110.f352431v;
    L90:
        boolean r420 = r123;
        if ((r418 & 4194304) == 0) goto L93;
        boolean r124 = r110.f352432w;
    L94:
        boolean r421 = r124;
        if ((r418 & 8388608) == 0) goto L97;
        boolean r125 = r110.f352433x;
    L98:
        boolean r422 = r125;
        if ((r418 & 16777216) == 0) goto L101;
        r r126 = r110.f352434y;
    L102:
        boolean r127 = r100;
        if ((r418 & 33554432) == 0) goto L105;
        r r128 = r110.f352435z;
    L107:
        if ((r418 & 67108864) == 0) goto L109;
        y5 r129 = r110.A;
    L111:
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        VoiceDialogKind r130 = r110.B;
    L114:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "activeDialogKind");
        Intrinsics.checkNotNullParameter(r103, "args");
        Intrinsics.checkNotNullParameter(r104, "authorizeState");
        Intrinsics.checkNotNullParameter(r105, "editState");
        Intrinsics.checkNotNullParameter(r106, "optimizeState");
        Intrinsics.checkNotNullParameter(r112, "createState");
        Intrinsics.checkNotNullParameter(r113, "deleteConfirmState");
        Intrinsics.checkNotNullParameter(r114, "clearConfirmState");
        Intrinsics.checkNotNullParameter(r115, "infoConfirmState");
        Intrinsics.checkNotNullParameter(r116, "nameInputState");
        Intrinsics.checkNotNullParameter(r117, "photoPreviewState");
        Intrinsics.checkNotNullParameter(r108, "localVoiceId");
        Intrinsics.checkNotNullParameter(r126, "flowDraft");
        r r131 = r126;
        r r132 = r128;
        Intrinsics.checkNotNullParameter(r132, "originalFlowDraft");
        Intrinsics.checkNotNullParameter(r129, "recordSession");
        Intrinsics.checkNotNullParameter(r130, "returnDialogKind");
        return new o1(r127, r101, r219, r103, r104, r105, r106, r112, r113, r114, r115, r116, r117, r320, r108, r321, r322, r323, r324, r325, r419, r420, r421, r422, r131, r132, r129, r130);
    L113:
        r130 = r417;
        goto L114
    L109:
        r129 = r416;
        goto L111
    L105:
        r128 = r415;
        goto L107
    L101:
        r126 = r414;
        goto L102
    L97:
        r125 = r413;
        goto L98
    L93:
        r124 = r412;
        goto L94
    L89:
        r123 = r411;
        goto L90
    L85:
        r122 = r410;
        goto L86
    L81:
        r121 = r319;
        goto L82
    L77:
        r120 = r318;
        goto L78
    L73:
        r119 = r317;
        goto L74
    L69:
        r118 = r316;
        goto L70
    L65:
        r109 = r315;
        goto L66
    L61:
        r108 = r314;
        goto L62
    L57:
        r107 = r313;
        goto L59
    L53:
        r117 = r312;
        goto L54
    L49:
        r116 = r311;
        goto L51
    L45:
        r115 = r310;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
