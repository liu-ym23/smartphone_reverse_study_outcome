package com.larus.bmhome.share.panel;

import android.graphics.Bitmap;
import androidx.compose.ui.spatial.RectListKt;
import com.larus.im.bean.message.CreationTaskType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public Function1<? super String, Unit> A;
    public Function2<? super String, ? super Boolean, Unit> B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f313859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f313860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f313863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f313864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f313865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f313866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f313867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f313868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f313869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f313870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f313871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m f313872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f313873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f313874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f313875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f313876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Job f313877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f313878u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f313879v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f313880w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f313881x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f313882y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f313883z;

    public b() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, RectListKt.Lower26Bits);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f313858a, r101.f313858a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313859b, r101.f313859b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313860c, r101.f313860c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313861d, r101.f313861d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313862e, r101.f313862e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313863f, r101.f313863f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313864g, r101.f313864g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f313865h, r101.f313865h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f313866i, r101.f313866i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f313867j, r101.f313867j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f313868k, r101.f313868k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f313869l, r101.f313869l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f313870m, r101.f313870m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f313871n, r101.f313871n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f313872o, r101.f313872o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f313873p, r101.f313873p) == true) goto L57;
        return false;
    L57:
        if (this.f313874q == r101.f313874q) goto L60;
        return false;
    L60:
        if (this.f313875r == r101.f313875r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f313876s, r101.f313876s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f313877t, r101.f313877t) == true) goto L69;
        return false;
    L69:
        if (this.f313878u == r101.f313878u) goto L72;
        return false;
    L72:
        if (this.f313879v == r101.f313879v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f313880w, r101.f313880w) == true) goto L78;
        return false;
    L78:
        if (this.f313881x == r101.f313881x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f313882y, r101.f313882y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f313883z, r101.f313883z) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f313858a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f313859b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f313860c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f313861d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f313862e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f313863f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f313864g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f313865h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f313866i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f313867j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f313868k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f313869l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f313870m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f313871n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        m r143 = this.f313872o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Map<String, String> r146 = this.f313873p;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        int r149 = 1231;
        if (this.f313874q == false) goto L69;
        int r150 = 1231;
    L70:
        int r151 = (r148 + r150) * 31;
        if (this.f313875r == false) goto L73;
        int r152 = 1231;
    L74:
        int r153 = (r151 + r152) * 31;
        String r154 = this.f313876s;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        Job r157 = this.f313877t;
        if (r157 != null) goto L81;
        int r158 = 0;
    L82:
        int r159 = (r156 + r158) * 31;
        if (this.f313878u == false) goto L85;
        int r160 = 1231;
    L86:
        int r161 = (r159 + r160) * 31;
        if (this.f313879v == false) goto L89;
        int r162 = 1231;
    L90:
        int r163 = (r161 + r162) * 31;
        Integer r164 = this.f313880w;
        if (r164 != null) goto L93;
        int r165 = 0;
    L94:
        int r166 = (r163 + r165) * 31;
        if (this.f313881x == true) goto L98;
        r149 = 1237;
    L98:
        int r167 = (r166 + r149) * 31;
        f r168 = this.f313882y;
        if (r168 != null) goto L101;
        int r169 = 0;
    L102:
        int r170 = (r167 + r169) * 31;
        c r171 = this.f313883z;
        if (r171 == null) goto L107;
        r101 = r171.hashCode();
    L107:
        return r170 + r101;
    L101:
        r169 = r168.hashCode();
        goto L102
    L93:
        r165 = r164.hashCode();
        goto L94
    L89:
        r162 = 1237;
        goto L90
    L85:
        r160 = 1237;
        goto L86
    L81:
        r158 = r157.hashCode();
        goto L82
    L77:
        r155 = r154.hashCode();
        goto L78
    L73:
        r152 = 1237;
        goto L74
    L69:
        r150 = 1237;
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
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
        return "FlowShareContent(imageUrl=" + this.f313858a + ", imageBitmap=" + this.f313859b + ", linkUrl=" + this.f313860c + ", linkImageUrl=" + this.f313861d + ", videoUrl=" + this.f313862e + ", videoDownloadFilehash=" + this.f313863f + ", vid=" + this.f313864g + ", title=" + this.f313865h + ", text=" + this.f313866i + ", miniAppTitle=" + this.f313867j + ", shareId=" + this.f313868k + ", fileUrl=" + this.f313869l + ", fileName=" + this.f313870m + ", textContent=" + this.f313871n + ", shareToast=" + this.f313872o + ", exifMap=" + this.f313873p + ", isAIGC=" + this.f313874q + ", isShareOriginImage=" + this.f313875r + ", imageKey=" + this.f313876s + ", waitingJob=" + this.f313877t + ", canScaleSize=" + this.f313878u + ", dismissAfterLocalPathDownload=" + this.f313879v + ", taskType=" + this.f313880w + ", preferImageUrlForImageShare=" + this.f313881x + ", manualImageMetadataInfo=" + this.f313882y + ", hostForwardFile=" + this.f313883z + ')';
    }

    public static b a(b r310, String r311, Bitmap r312, String r313, String r314, String r315, String r316, boolean r317, int r318) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r310.f313858a;
    L7:
        if ((r318 & 2) == 0) goto L9;
        Bitmap r101 = r310.f313859b;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r310.f313860c;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r310.f313861d;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = r310.f313862e;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = r310.f313863f;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r110 = r310.f313864g;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r111 = r310.f313865h;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r112 = r310.f313866i;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r113 = r310.f313867j;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r114 = r310.f313868k;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r115 = r310.f313869l;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r116 = r310.f313870m;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r117 = r310.f313871n;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        m r118 = r310.f313872o;
    L63:
        if ((32768 & r318) == 0) goto L65;
        Map<String, String> r119 = r310.f313873p;
    L67:
        if ((65536 & r318) == 0) goto L69;
        boolean r210 = r310.f313874q;
    L71:
        if ((131072 & r318) == 0) goto L73;
        boolean r106 = r310.f313875r;
    L75:
        if ((r318 & 262144) == 0) goto L77;
        String r211 = r310.f313876s;
    L79:
        if ((524288 & r318) == 0) goto L81;
        Job r212 = r310.f313877t;
    L83:
        if ((1048576 & r318) == 0) goto L85;
        boolean r213 = r310.f313878u;
    L87:
        if ((2097152 & r318) == 0) goto L89;
        boolean r214 = r310.f313879v;
    L91:
        if ((4194304 & r318) == 0) goto L93;
        Integer r215 = r310.f313880w;
    L95:
        if ((8388608 & r318) == 0) goto L97;
        boolean r216 = r310.f313881x;
    L99:
        if ((16777216 & r318) == 0) goto L101;
        f r217 = r310.f313882y;
    L103:
        if ((r318 & 33554432) == 0) goto L105;
        c r218 = r310.f313883z;
    L106:
        r310.getClass();
        return new b(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r106, r211, r212, r213, r214, r215, r216, r217, r218);
    L105:
        r218 = null;
        goto L106
    L101:
        r217 = null;
        goto L103
    L97:
        r216 = false;
        goto L99
    L93:
        r215 = null;
        goto L95
    L89:
        r214 = false;
        goto L91
    L85:
        r213 = false;
        goto L87
    L81:
        r212 = null;
        goto L83
    L77:
        r211 = null;
        goto L79
    L73:
        r106 = false;
        goto L75
    L69:
        r210 = r317;
        goto L71
    L65:
        r119 = null;
        goto L67
    L61:
        r118 = null;
        goto L63
    L57:
        r117 = null;
        goto L59
    L53:
        r116 = null;
        goto L55
    L49:
        r115 = null;
        goto L51
    L45:
        r114 = null;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = r316;
        goto L39
    L33:
        r111 = r315;
        goto L35
    L29:
        r110 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public b(String r100, Bitmap r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, m r117, Map<String, String> r118, boolean r119, boolean r210, String r211, Job r212, boolean r213, boolean r214, @CreationTaskType Integer r215, boolean r216, f r217, c r218) {
        this.f313858a = r100;
        this.f313859b = r101;
        this.f313860c = r102;
        this.f313861d = r103;
        this.f313862e = r104;
        this.f313863f = r105;
        this.f313864g = r106;
        this.f313865h = r110;
        this.f313866i = r111;
        this.f313867j = r112;
        this.f313868k = r113;
        this.f313869l = r114;
        this.f313870m = r115;
        this.f313871n = r116;
        this.f313872o = r117;
        this.f313873p = r118;
        this.f313874q = r119;
        this.f313875r = r210;
        this.f313876s = r211;
        this.f313877t = r212;
        this.f313878u = r213;
        this.f313879v = r214;
        this.f313880w = r215;
        this.f313881x = r216;
        this.f313882y = r217;
        this.f313883z = r218;
    }

    public /* synthetic */ b(String r210, Bitmap r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, m r413, Map r414, boolean r415, boolean r416, String r417, Job r418, boolean r419, boolean r510, Integer r511, boolean r512, f r513, c r514, int r515) {
        if ((r515 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r515 & 2) == 0) goto L9;
        Bitmap r101 = null;
    L11:
        if ((r515 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r515 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r515 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r515 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r515 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r515 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r515 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r515 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r515 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r515 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r515 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r515 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r515 & 16384) == 0) goto L61;
        m r108 = null;
    L63:
        if ((r515 & 32768) == 0) goto L65;
        Map r116 = null;
    L66:
        boolean r117 = false;
        if ((r515 & 65536) == 0) goto L69;
        boolean r118 = false;
    L71:
        if ((r515 & 131072) == 0) goto L73;
        boolean r211 = false;
    L75:
        if ((r515 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r515 & 524288) == 0) goto L81;
        Job r213 = null;
    L83:
        if ((r515 & 1048576) == 0) goto L85;
        boolean r214 = true;
    L87:
        if ((r515 & 2097152) == 0) goto L89;
        boolean r215 = false;
    L91:
        if ((r515 & 4194304) == 0) goto L93;
        Integer r216 = null;
    L95:
        if ((r515 & 8388608) != 0) goto L99;
        r117 = r512;
    L99:
        if ((r515 & 16777216) == 0) goto L101;
        f r217 = null;
    L103:
        if ((r515 & 33554432) == 0) goto L105;
        c r119 = null;
    L106:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r118, r211, r212, r213, r214, r215, r216, r117, r217, r119);
        return;
    L105:
        r119 = r514;
        goto L106
    L101:
        r217 = r513;
        goto L103
    L93:
        r216 = r511;
        goto L95
    L89:
        r215 = r510;
        goto L91
    L85:
        r214 = r419;
        goto L87
    L81:
        r213 = r418;
        goto L83
    L77:
        r212 = r417;
        goto L79
    L73:
        r211 = r416;
        goto L75
    L69:
        r118 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L66
    L61:
        r108 = r413;
        goto L63
    L57:
        r115 = r412;
        goto L59
    L53:
        r114 = r411;
        goto L55
    L49:
        r113 = r410;
        goto L51
    L45:
        r112 = r319;
        goto L47
    L41:
        r111 = r318;
        goto L43
    L37:
        r110 = r317;
        goto L39
    L33:
        r107 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
