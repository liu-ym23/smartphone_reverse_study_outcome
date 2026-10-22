package hx8;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public final String A;
    public final List<String> B;
    public final CameraResultRoute C;
    public final CameraOutputContext D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f487524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f487525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f487526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f487527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f487528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f487529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f487530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f487531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f487532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f487533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f487534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f487535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f487536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f487537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f487538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f487539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f487540s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f487541t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f487542u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f487543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f487544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f487545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f487546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f487547z;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487522a, r101.f487522a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487523b, r101.f487523b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487524c, r101.f487524c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487525d, r101.f487525d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487526e, r101.f487526e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f487527f, r101.f487527f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f487528g, r101.f487528g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f487529h, r101.f487529h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f487530i, r101.f487530i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f487531j, r101.f487531j) == true) goto L39;
        return false;
    L39:
        if (this.f487532k == r101.f487532k) goto L42;
        return false;
    L42:
        if (this.f487533l == r101.f487533l) goto L45;
        return false;
    L45:
        if (this.f487534m == r101.f487534m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f487535n, r101.f487535n) == true) goto L51;
        return false;
    L51:
        if (this.f487536o == r101.f487536o) goto L54;
        return false;
    L54:
        if (this.f487537p == r101.f487537p) goto L57;
        return false;
    L57:
        if (this.f487538q == r101.f487538q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f487539r, r101.f487539r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f487540s, r101.f487540s) == true) goto L66;
        return false;
    L66:
        if (this.f487541t == r101.f487541t) goto L69;
        return false;
    L69:
        if (this.f487542u == r101.f487542u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f487543v, r101.f487543v) == true) goto L75;
        return false;
    L75:
        if (this.f487544w == r101.f487544w) goto L78;
        return false;
    L78:
        if (this.f487545x == r101.f487545x) goto L81;
        return false;
    L81:
        if (this.f487546y == r101.f487546y) goto L84;
        return false;
    L84:
        if (this.f487547z == r101.f487547z) goto L87;
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
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f487522a.hashCode() * 31) + this.f487523b.hashCode()) * 31;
        List<Pair<String, String>> r101 = this.f487524c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        HashMap<String, Object> r105 = this.f487525d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f487526e.hashCode()) * 31;
        List<String> r108 = this.f487527f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f487528g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f487529h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f487530i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        List<String> r120 = this.f487531j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        int r123 = 1231;
        if (this.f487532k == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.f487533l == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (r125 + r126) * 31;
        if (this.f487534m == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r127 + r128) * 31;
        String r130 = this.f487535n;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        if (this.f487536o == false) goto L49;
        int r133 = 1231;
    L50:
        int r134 = (((r132 + r133) * 31) + this.f487537p) * 31;
        if (this.f487538q == false) goto L53;
        int r135 = 1231;
    L54:
        int r136 = (r134 + r135) * 31;
        Integer r137 = this.f487539r;
        if (r137 != null) goto L57;
        int r138 = 0;
    L58:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.f487540s;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        if (this.f487541t == false) goto L65;
        int r143 = 1231;
    L66:
        int r144 = (((r142 + r143) * 31) + this.f487542u) * 31;
        String r145 = this.f487543v;
        if (r145 != null) goto L69;
        int r146 = 0;
    L70:
        int r147 = (r144 + r146) * 31;
        if (this.f487544w == false) goto L73;
        int r148 = 1231;
    L74:
        int r149 = (r147 + r148) * 31;
        if (this.f487545x == false) goto L77;
        int r150 = 1231;
    L78:
        int r151 = (r149 + r150) * 31;
        if (this.f487546y == false) goto L81;
        int r152 = 1231;
    L82:
        int r153 = (r151 + r152) * 31;
        if (this.f487547z == true) goto L86;
        r123 = 1237;
    L86:
        int r154 = (((((r153 + r123) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31;
        CameraResultRoute r155 = this.C;
        if (r155 != null) goto L89;
        int r156 = 0;
    L90:
        int r157 = (r154 + r156) * 31;
        CameraOutputContext r158 = this.D;
        if (r158 == null) goto L95;
        r102 = r158.hashCode();
    L95:
        return r157 + r102;
    L89:
        r156 = r155.hashCode();
        goto L90
    L81:
        r152 = 1237;
        goto L82
    L77:
        r150 = 1237;
        goto L78
    L73:
        r148 = 1237;
        goto L74
    L69:
        r146 = r145.hashCode();
        goto L70
    L65:
        r143 = 1237;
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L57:
        r138 = r137.hashCode();
        goto L58
    L53:
        r135 = 1237;
        goto L54
    L49:
        r133 = 1237;
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = 1237;
        goto L42
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = 1237;
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "CameraConfig(scene=" + this.f487522a + ", mode=" + this.f487523b + ", modeList=" + this.f487524c + ", eventExt=" + this.f487525d + ", extra=" + this.f487526e + ", enableCaptureDetectModeList=" + this.f487527f + ", cameraNameUrl=" + this.f487528g + ", cameraName=" + this.f487529h + ", tipsShowOrder=" + this.f487530i + ", tips=" + this.f487531j + ", supportMark=" + this.f487532k + ", supportCrop=" + this.f487533l + ", supportMultiImages=" + this.f487534m + ", botId=" + this.f487535n + ", enableFocusFrame=" + this.f487536o + ", inputStyle=" + this.f487537p + ", supportRecord=" + this.f487538q + ", albumLandingTabIndex=" + this.f487539r + ", addedAttachmentCount=" + this.f487540s + ", supportAlbumMultiTake=" + this.f487541t + ", albumMultiTakeMaxCount=" + this.f487542u + ", suggestionPrefix=" + this.f487543v + ", showBottomAlbum=" + this.f487544w + ", albumSupportOriginalImage=" + this.f487545x + ", enableOriginalImageDeferredEdit=" + this.f487546y + ", enableCaptureAlbum=" + this.f487547z + ", albumInputText=" + this.A + ", albumAttachmentUris=" + this.B + ", resultRoute=" + this.C + ", initialOutputContext=" + this.D + ')';
    }

    public a(String r310, String r311, List r312, HashMap r313, Map r314, List r315, String r410, String r411, Integer r412, List r413, boolean r414, boolean r415, boolean r416, String r417, boolean r418, int r419, boolean r510, Integer r511, Integer r512, boolean r513, int r514, String r515, boolean r516, boolean r517, boolean r518, String r519, List r610, CameraResultRoute r611, CameraOutputContext r612, int r613) {
        if ((r613 & 4) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r613 & 8) == 0) goto L9;
        HashMap r101 = null;
    L11:
        if ((r613 & 16) == 0) goto L13;
        Map r102 = MapsKt.emptyMap();
    L15:
        if ((r613 & 32) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r613 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r613 & 128) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r613 & 256) == 0) goto L29;
        Integer r111 = null;
    L31:
        if ((r613 & 512) == 0) goto L33;
        List r112 = null;
    L35:
        if ((r613 & 1024) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r613 & 2048) == 0) goto L41;
        boolean r114 = false;
    L43:
        if ((r613 & 4096) == 0) goto L45;
        boolean r105 = false;
    L47:
        if ((r613 & 8192) == 0) goto L49;
        String r115 = null;
    L50:
        String r316 = r115;
        if ((r613 & 16384) == 0) goto L53;
        boolean r116 = false;
    L55:
        if ((r613 & 32768) == 0) goto L57;
        int r117 = 0;
    L59:
        if ((r613 & 65536) == 0) goto L61;
        boolean r118 = false;
    L63:
        if ((r613 & 131072) == 0) goto L65;
        int r119 = 0;
        Integer r210 = 0;
    L67:
        if ((r613 & 262144) == 0) goto L69;
        Integer r211 = Integer.valueOf(r119);
    L71:
        if ((r613 & 524288) == 0) goto L73;
        boolean r212 = false;
    L75:
        if ((r613 & 1048576) == 0) goto L77;
        int r213 = 0;
    L79:
        if ((r613 & 2097152) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r613 & 4194304) == 0) goto L85;
        boolean r215 = false;
    L87:
        if ((r613 & 8388608) == 0) goto L89;
        boolean r216 = false;
    L91:
        if ((r613 & 16777216) == 0) goto L93;
        boolean r217 = false;
    L95:
        if ((r613 & 33554432) == 0) goto L97;
        boolean r218 = true;
    L99:
        if ((r613 & 67108864) == 0) goto L101;
        String r120 = "";
    L103:
        if ((r613 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L105;
        List r106 = CollectionsKt.emptyList();
    L107:
        if ((r613 & 268435456) == 0) goto L109;
        CameraResultRoute r317 = null;
    L111:
        if ((r613 & 536870912) == 0) goto L113;
        CameraOutputContext r121 = null;
    L114:
        Intrinsics.checkNotNullParameter(r310, "scene");
        Intrinsics.checkNotNullParameter(r311, "mode");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r120, "albumInputText");
        Intrinsics.checkNotNullParameter(r106, "albumAttachmentUris");
        this.f487522a = r310;
        this.f487523b = r311;
        this.f487524c = r100;
        this.f487525d = r101;
        this.f487526e = r102;
        this.f487527f = r103;
        this.f487528g = r104;
        this.f487529h = r110;
        this.f487530i = r111;
        this.f487531j = r112;
        this.f487532k = r113;
        this.f487533l = r114;
        this.f487534m = r105;
        this.f487535n = r316;
        this.f487536o = r116;
        this.f487537p = r117;
        this.f487538q = r118;
        this.f487539r = r210;
        this.f487540s = r211;
        this.f487541t = r212;
        this.f487542u = r213;
        this.f487543v = r214;
        this.f487544w = r215;
        this.f487545x = r216;
        this.f487546y = r217;
        this.f487547z = r218;
        this.A = r120;
        this.B = r106;
        this.C = r317;
        this.D = r121;
        return;
    L113:
        r121 = r612;
        goto L114
    L109:
        r317 = r611;
        goto L111
    L105:
        r106 = r610;
        goto L107
    L101:
        r120 = r519;
        goto L103
    L97:
        r218 = false;
        goto L99
    L93:
        r217 = r518;
        goto L95
    L89:
        r216 = r517;
        goto L91
    L85:
        r215 = r516;
        goto L87
    L81:
        r214 = r515;
        goto L83
    L77:
        r213 = r514;
        goto L79
    L73:
        r212 = r513;
        goto L75
    L69:
        r211 = r512;
        goto L71
    L65:
        r119 = 0;
        r210 = r511;
        goto L67
    L61:
        r118 = r510;
        goto L63
    L57:
        r117 = r419;
        goto L59
    L53:
        r116 = r418;
        goto L55
    L49:
        r115 = r417;
        goto L50
    L45:
        r105 = r416;
        goto L47
    L41:
        r114 = r415;
        goto L43
    L37:
        r113 = r414;
        goto L39
    L33:
        r112 = r413;
        goto L35
    L29:
        r111 = r412;
        goto L31
    L25:
        r110 = r411;
        goto L27
    L21:
        r104 = r410;
        goto L23
    L17:
        r103 = r315;
        goto L19
    L13:
        r102 = r314;
        goto L15
    L9:
        r101 = r313;
        goto L11
    L5:
        r100 = r312;
        goto L7
    }
}
