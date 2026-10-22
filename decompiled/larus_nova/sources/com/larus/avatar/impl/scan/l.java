package com.larus.avatar.impl.scan;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class l {
    public final Long A;
    public final String B;
    public final Boolean C;
    public final wj8.b D;
    public final String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wc9.e f291003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f291004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f291005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f291006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f291007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f291008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f291009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f291010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f291011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f291012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f291013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f291014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f291015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f291016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f291017o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f291018p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f291019q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ey9.k f291020r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f291021s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f291022t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f291023u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f291024v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f291025w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f291026x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f291027y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<String> f291028z;

    public l() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, false, false, 0, null, null, null, null, null, null, null, Integer.MAX_VALUE);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f291003a, r101.f291003a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f291004b, r101.f291004b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291005c, r101.f291005c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f291006d, r101.f291006d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f291007e, r101.f291007e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f291008f, r101.f291008f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f291009g, r101.f291009g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f291010h, r101.f291010h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f291011i, r101.f291011i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f291012j, r101.f291012j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f291013k, r101.f291013k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f291014l, r101.f291014l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f291015m, r101.f291015m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f291016n, r101.f291016n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f291017o, r101.f291017o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f291018p, r101.f291018p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f291019q, r101.f291019q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f291020r, r101.f291020r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f291021s, r101.f291021s) == true) goto L66;
        return false;
    L66:
        if (this.f291022t == r101.f291022t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f291023u, r101.f291023u) == true) goto L72;
        return false;
    L72:
        if (this.f291024v == r101.f291024v) goto L75;
        return false;
    L75:
        if (this.f291025w == r101.f291025w) goto L78;
        return false;
    L78:
        if (this.f291026x == r101.f291026x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f291027y, r101.f291027y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f291028z, r101.f291028z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L101;
        return false;
    L101:
        return true;
    }

    public final int hashCode() {
        wc9.e r100 = this.f291003a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f291004b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f291005c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f291006d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f291007e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f291008f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((((r115 + r117) * 31) + this.f291009g.hashCode()) * 31) + this.f291010h.hashCode()) * 31;
        String r119 = this.f291011i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f291012j;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((((((((r121 + r123) * 31) + this.f291013k.hashCode()) * 31) + this.f291014l.hashCode()) * 31) + this.f291015m.hashCode()) * 31) + this.f291016n.hashCode()) * 31;
        String r125 = this.f291017o;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f291018p;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((r127 + r129) * 31) + this.f291019q.hashCode()) * 31;
        ey9.k r131 = this.f291020r;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f291021s;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        int r137 = 1231;
        if (this.f291022t == false) goto L53;
        int r138 = 1231;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f291023u;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        if (this.f291024v == false) goto L61;
        int r143 = 1231;
    L62:
        int r144 = (r142 + r143) * 31;
        if (this.f291025w == true) goto L66;
        r137 = 1237;
    L66:
        int r145 = (((((r144 + r137) * 31) + this.f291026x) * 31) + this.f291027y.hashCode()) * 31;
        ArrayList<String> r146 = this.f291028z;
        if (r146 != null) goto L69;
        int r147 = 0;
    L70:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.A;
        if (r149 != null) goto L73;
        int r150 = 0;
    L74:
        int r151 = (r148 + r150) * 31;
        String r152 = this.B;
        if (r152 != null) goto L77;
        int r153 = 0;
    L78:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.C;
        if (r155 != null) goto L81;
        int r156 = 0;
    L82:
        int r157 = (r154 + r156) * 31;
        wj8.b r158 = this.D;
        if (r158 != null) goto L85;
        int r159 = 0;
    L86:
        int r160 = (r157 + r159) * 31;
        String r161 = this.E;
        if (r161 == null) goto L91;
        r101 = r161.hashCode();
    L91:
        return r160 + r101;
    L85:
        r159 = r158.hashCode();
        goto L86
    L81:
        r156 = r155.hashCode();
        goto L82
    L77:
        r153 = r152.hashCode();
        goto L78
    L73:
        r150 = r149.hashCode();
        goto L74
    L69:
        r147 = r146.hashCode();
        goto L70
    L61:
        r143 = 1237;
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = 1237;
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "ScanCameraInputParams(conversation=" + this.f291003a + ", conversationId=" + this.f291004b + ", prompt=" + this.f291005c + ", trackExtCreationTemplate=" + this.f291006d + ", previousPage=" + this.f291007e + ", replicaCreateId=" + this.f291008f + ", scene=" + this.f291009g + ", isFromTemplate=" + this.f291010h + ", templateId=" + this.f291011i + ", refMsgId=" + this.f291012j + ", enterMethod=" + this.f291013k + ", aiGenerateTabId=" + this.f291014l + ", aiGenerateTabType=" + this.f291015m + ", aiGenerateTabName=" + this.f291016n + ", botId=" + this.f291017o + ", chatType=" + this.f291018p + ", aiCreationRecommendFrom=" + this.f291019q + ", mainImage=" + this.f291020r + ", processType=" + this.f291021s + ", isFromOnboarding=" + this.f291022t + ", enterCreateFrom=" + this.f291023u + ", isRegenerateReplica=" + this.f291024v + ", isMockAvatar=" + this.f291025w + ", selectInstructionType=" + this.f291026x + ", avatarDoSamePrompt=" + this.f291027y + ", avatarRefResourceList=" + this.f291028z + ", targetInstructionItemId=" + this.A + ", videoInternalResourcesStr=" + this.B + ", isCreationPrivate=" + this.C + ", creationBtnReplayInfo=" + this.D + ", localMessageId=" + this.E + ')';
    }

    public l(String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, ey9.k r419, Integer r510, boolean r511, String r512, boolean r513, boolean r514, int r515, String r516, ArrayList r517, Long r518, String r519, Boolean r610, wj8.b r611, String r612, int r613) {
        if ((r613 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r613 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r613 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r613 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r613 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r613 & 64) == 0) goto L25;
        String r105 = BasicTestActionHandler.TEST_ACTION_RESET;
    L27:
        if ((r613 & 128) == 0) goto L29;
        String r106 = "0";
    L31:
        if ((r613 & 256) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r613 & 512) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r613 & 1024) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r613 & 2048) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r613 & 4096) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r613 & 8192) == 0) goto L53;
        String r107 = "";
    L55:
        if ((r613 & 16384) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r613 & 32768) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r613 & 65536) == 0) goto L65;
        String r117 = "";
    L67:
        if ((r613 & 131072) == 0) goto L69;
        ey9.k r118 = null;
    L71:
        if ((r613 & 262144) == 0) goto L73;
        Integer r210 = null;
    L75:
        if ((r613 & 524288) == 0) goto L77;
        boolean r211 = false;
    L79:
        if ((r613 & 1048576) == 0) goto L81;
        String r212 = null;
    L83:
        if ((r613 & 2097152) == 0) goto L85;
        boolean r213 = false;
    L87:
        if ((r613 & 4194304) == 0) goto L89;
        boolean r214 = false;
    L91:
        if ((r613 & 8388608) == 0) goto L93;
        int r215 = 4;
    L95:
        if ((r613 & 16777216) == 0) goto L97;
        String r119 = "";
    L99:
        if ((r613 & 33554432) == 0) goto L101;
        ArrayList r216 = null;
    L103:
        if ((r613 & 67108864) == 0) goto L105;
        Long r217 = null;
    L107:
        if ((r613 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r218 = null;
    L111:
        if ((r613 & 268435456) == 0) goto L113;
        Boolean r317 = null;
    L115:
        if ((r613 & 536870912) == 0) goto L117;
        wj8.b r318 = null;
    L119:
        if ((r613 & 1073741824) == 0) goto L121;
        String r219 = null;
    L122:
        Intrinsics.checkNotNullParameter(r105, "scene");
        Intrinsics.checkNotNullParameter(r106, "isFromTemplate");
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        Intrinsics.checkNotNullParameter(r113, "aiGenerateTabId");
        Intrinsics.checkNotNullParameter(r114, "aiGenerateTabType");
        Intrinsics.checkNotNullParameter(r107, "aiGenerateTabName");
        Intrinsics.checkNotNullParameter(r117, "aiCreationRecommendFrom");
        Intrinsics.checkNotNullParameter(r119, "avatarDoSamePrompt");
        this.f291003a = null;
        this.f291004b = r100;
        this.f291005c = r101;
        this.f291006d = r102;
        this.f291007e = r103;
        this.f291008f = r104;
        this.f291009g = r105;
        this.f291010h = r106;
        this.f291011i = r110;
        this.f291012j = r111;
        this.f291013k = r112;
        this.f291014l = r113;
        this.f291015m = r114;
        this.f291016n = r107;
        this.f291017o = r115;
        this.f291018p = r116;
        this.f291019q = r117;
        this.f291020r = r118;
        this.f291021s = r210;
        this.f291022t = r211;
        this.f291023u = r212;
        this.f291024v = r213;
        this.f291025w = r214;
        this.f291026x = r215;
        this.f291027y = r119;
        this.f291028z = r216;
        this.A = r217;
        this.B = r218;
        this.C = r317;
        this.D = r318;
        this.E = r219;
        return;
    L121:
        r219 = r612;
        goto L122
    L117:
        r318 = r611;
        goto L119
    L113:
        r317 = r610;
        goto L115
    L109:
        r218 = r519;
        goto L111
    L105:
        r217 = r518;
        goto L107
    L101:
        r216 = r517;
        goto L103
    L97:
        r119 = r516;
        goto L99
    L93:
        r215 = r515;
        goto L95
    L89:
        r214 = r514;
        goto L91
    L85:
        r213 = r513;
        goto L87
    L81:
        r212 = r512;
        goto L83
    L77:
        r211 = r511;
        goto L79
    L73:
        r210 = r510;
        goto L75
    L69:
        r118 = r419;
        goto L71
    L65:
        r117 = r418;
        goto L67
    L61:
        r116 = r417;
        goto L63
    L57:
        r115 = r416;
        goto L59
    L53:
        r107 = r415;
        goto L55
    L49:
        r114 = r414;
        goto L51
    L45:
        r113 = r413;
        goto L47
    L41:
        r112 = r412;
        goto L43
    L37:
        r111 = r411;
        goto L39
    L33:
        r110 = r410;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
