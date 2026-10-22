package p83;

import kotlin.jvm.internal.Intrinsics;
import n83.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f528166w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f528167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f528168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f528169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f528173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f528174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f528175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f528176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f528177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f528178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f528179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f528180n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f528181o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f528182p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f528183q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final JSONObject f528184r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Boolean f528185s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f528186t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Long f528187u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Long f528188v;

    public static final class a {
        public static h a(String r110, JSONObject r111, JSONObject r210, String r211, Integer r212) {
            Intrinsics.checkNotNullParameter(r110, "followStatus");
            Intrinsics.checkNotNullParameter(r111, "entranceInfo");
            Intrinsics.checkNotNullParameter(r210, "v3EventAdditions");
            return new h(false, null, null, false, r211, r110, r111, r210, r212, null, null, null, null, null, null, 16776718);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L54;
        h r101 = (h) r100;
        if (this.f528167a == r101.f528167a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f528168b, r101.f528168b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f528169c, r101.f528169c) == true) goto L12;
        return false;
    L12:
        if (this.f528170d == r101.f528170d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f528171e, r101.f528171e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f528172f, r101.f528172f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528173g, r101.f528173g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f528174h, r101.f528174h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f528175i, r101.f528175i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528176j, r101.f528176j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f528177k, r101.f528177k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f528178l, r101.f528178l) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f528179m, r101.f528179m) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f528180n, r101.f528180n) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f528181o, r101.f528181o) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f528182p, r101.f528182p) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f528183q, r101.f528183q) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f528184r, r101.f528184r) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f528185s, r101.f528185s) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f528186t, r101.f528186t) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f528187u, r101.f528187u) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f528188v, r101.f528188v) == true) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v71 */
    public final int hashCode() {
        boolean r100 = this.f528167a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        m r104 = this.f528168b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f528169c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f528170d;
        if (r111 == true) goto L17;
        r101 = r111;
    L17:
        int r112 = (r110 + r101) * 31;
        String r113 = this.f528171e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f528172f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.f528173g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        JSONObject r122 = this.f528174h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f528175i;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f528176j;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f528177k;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (((r130 + r132) * 31) + 0) * 31;
        String r134 = this.f528178l;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f528179m;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f528180n;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f528181o;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.f528182p;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        String r149 = this.f528183q;
        if (r149 == null) goto L68;
        int r150 = r149.hashCode();
    L69:
        int r151 = (((r148 + r150) * 31) + 0) * 31;
        JSONObject r152 = this.f528184r;
        if (r152 == null) goto L72;
        int r153 = r152.hashCode();
    L73:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.f528185s;
        if (r155 == null) goto L76;
        int r156 = r155.hashCode();
    L77:
        int r157 = (r154 + r156) * 31;
        String r158 = this.f528186t;
        if (r158 == null) goto L80;
        int r159 = r158.hashCode();
    L81:
        int r160 = (r157 + r159) * 31;
        Long r161 = this.f528187u;
        if (r161 == null) goto L84;
        int r162 = r161.hashCode();
    L85:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.f528188v;
        if (r164 == null) goto L89;
        r105 = r164.hashCode();
    L89:
        return r163 + r105;
    L84:
        r162 = 0;
        goto L85
    L80:
        r159 = 0;
        goto L81
    L76:
        r156 = 0;
        goto L77
    L72:
        r153 = 0;
        goto L73
    L68:
        r150 = 0;
        goto L69
    L64:
        r147 = 0;
        goto L65
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "PdpCustomizableParams(activityWillFinish=" + this.f528167a + ", videoZoomController=" + this.f528168b + ", fullMode=" + this.f528169c + ", isPreload=" + this.f528170d + ", liveWindowRoomId=" + this.f528171e + ", followStatus=" + this.f528172f + ", entranceInfo=" + this.f528173g + ", v3EventAdditions=" + this.f528174h + ", heightPercent=" + this.f528175i + ", pdpHalf2026HeightType=" + this.f528176j + ", enterFrom=" + this.f528177k + ", pdpTransitionDepend=null, coverImgUrl=" + this.f528178l + ", covImageUri=" + this.f528179m + ", fractionListenerId=" + this.f528180n + ", sceneTransitionData=" + this.f528181o + ", clientCacheDisable=" + this.f528182p + ", sourceBtmToken=" + this.f528183q + ", interceptor=null, adParams=" + this.f528184r + ", fromSchemaConvert=" + this.f528185s + ", codeSource=" + this.f528186t + ", startTs=" + this.f528187u + ", schemaConvertDuration=" + this.f528188v + ")";
    }

    public /* synthetic */ h(boolean r210, m r211, Integer r212, boolean r310, String r311, String r312, JSONObject r313, JSONObject r314, Integer r315, String r316, JSONObject r317, Boolean r318, String r319, Long r410, Long r411, int r412) {
        if ((r412 & 2) == 0) goto L5;
        m r100 = null;
    L7:
        if ((r412 & 4) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r412 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r412 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r412 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r412 & 64) == 0) goto L25;
        JSONObject r110 = null;
    L27:
        if ((r412 & 128) == 0) goto L29;
        JSONObject r111 = null;
    L31:
        if ((r412 & 256) == 0) goto L33;
        Integer r112 = null;
    L35:
        if ((131072 & r412) == 0) goto L37;
        String r213 = null;
    L39:
        if ((524288 & r412) == 0) goto L41;
        JSONObject r214 = null;
    L43:
        if ((1048576 & r412) == 0) goto L45;
        Boolean r215 = Boolean.FALSE;
    L47:
        if ((2097152 & r412) == 0) goto L49;
        String r216 = null;
    L51:
        if ((4194304 & r412) == 0) goto L53;
        Long r217 = null;
    L55:
        if ((r412 & 8388608) == 0) goto L57;
        Long r218 = null;
    L58:
        this(r210, r100, r101, r102, r103, r104, r110, r111, r112, null, null, null, null, null, null, null, r213, r214, r215, r216, r217, r218);
        return;
    L57:
        r218 = r411;
        goto L58
    L53:
        r217 = r410;
        goto L55
    L49:
        r216 = r319;
        goto L51
    L45:
        r215 = r318;
        goto L47
    L41:
        r214 = r317;
        goto L43
    L37:
        r213 = r316;
        goto L39
    L33:
        r112 = r315;
        goto L35
    L29:
        r111 = r314;
        goto L31
    L25:
        r110 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public h(boolean r100, m r101, Integer r102, boolean r103, String r104, String r105, JSONObject r106, JSONObject r110, Integer r111, Integer r112, String r113, String r114, String r115, String r116, String r117, Boolean r118, String r119, JSONObject r210, Boolean r211, String r212, Long r213, Long r214) {
        this.f528167a = r100;
        this.f528168b = r101;
        this.f528169c = r102;
        this.f528170d = r103;
        this.f528171e = r104;
        this.f528172f = r105;
        this.f528173g = r106;
        this.f528174h = r110;
        this.f528175i = r111;
        this.f528176j = r112;
        this.f528177k = r113;
        this.f528178l = r114;
        this.f528179m = r115;
        this.f528180n = r116;
        this.f528181o = r117;
        this.f528182p = r118;
        this.f528183q = r119;
        this.f528184r = r210;
        this.f528185s = r211;
        this.f528186t = r212;
        this.f528187u = r213;
        this.f528188v = r214;
    }
}
