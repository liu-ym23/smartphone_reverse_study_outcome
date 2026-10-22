package vz1;

import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f557650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f557651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pair<Integer, i> f557652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f557653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f557654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f557655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f557656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f557657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f557658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f557659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f557660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f557661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f557662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f557663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f557664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f557665p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final GiftPanelIconSource f557666q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Long f557667r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f557668s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f557669t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f557670u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CardType f557671v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f557672w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.model.k f557673x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f557674y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.model.a f557675z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L58;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f557650a, r101.f557650a) == true) goto L8;
        return false;
    L8:
        if (this.f557651b == r101.f557651b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f557652c, r101.f557652c) == true) goto L12;
        return false;
    L12:
        if (this.f557653d == r101.f557653d) goto L14;
        return false;
    L14:
        if (this.f557654e == r101.f557654e) goto L16;
        return false;
    L16:
        if (this.f557655f == r101.f557655f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f557656g, r101.f557656g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f557657h, r101.f557657h) == true) goto L22;
        return false;
    L22:
        if (this.f557658i == r101.f557658i) goto L24;
        return false;
    L24:
        if (this.f557659j == r101.f557659j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f557660k, r101.f557660k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f557661l, r101.f557661l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f557662m, r101.f557662m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f557663n, r101.f557663n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f557664o, r101.f557664o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f557665p, r101.f557665p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f557666q, r101.f557666q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f557667r, r101.f557667r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f557668s, r101.f557668s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f557669t, r101.f557669t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f557670u, r101.f557670u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f557671v, r101.f557671v) == true) goto L50;
        return false;
    L50:
        if (this.f557672w == r101.f557672w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f557673x, r101.f557673x) == true) goto L54;
        return false;
    L54:
        if (this.f557674y == r101.f557674y) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f557675z, r101.f557675z) == true) goto L88;
        return false;
    L88:
        return true;
    L58:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56, types: [int] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        h1 r100 = this.f557650a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f557651b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Pair<Integer, i> r105 = this.f557652c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        long r108 = this.f557653d;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        boolean r110 = this.f557654e;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L13;
        r112 = 1;
    L13:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f557655f;
        ?? r115 = r114;
        if (r114 == false) goto L16;
        r115 = 1;
    L16:
        int r116 = (r113 + r115) * 31;
        h r117 = this.f557656g;
        if (r117 == null) goto L19;
        int r118 = r117.hashCode();
    L20:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.f557657h;
        if (r120 == null) goto L23;
        int r121 = r120.hashCode();
    L24:
        int r122 = (((((r119 + r121) * 31) + this.f557658i) * 31) + this.f557659j) * 31;
        String r123 = this.f557660k;
        if (r123 == null) goto L27;
        int r124 = r123.hashCode();
    L28:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f557661l;
        if (r126 == null) goto L31;
        int r127 = r126.hashCode();
    L32:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f557662m;
        if (r129 == null) goto L35;
        int r130 = r129.hashCode();
    L36:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.f557663n;
        if (r132 == null) goto L39;
        int r133 = r132.hashCode();
    L40:
        int r134 = (r131 + r133) * 31;
        k r135 = this.f557664o;
        if (r135 == null) goto L43;
        int r136 = r135.hashCode();
    L44:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f557665p;
        if (r138 == null) goto L47;
        int r139 = r138.hashCode();
    L48:
        int r140 = (r137 + r139) * 31;
        GiftPanelIconSource r141 = this.f557666q;
        if (r141 == null) goto L51;
        int r142 = r141.hashCode();
    L52:
        int r143 = (r140 + r142) * 31;
        Long r144 = this.f557667r;
        if (r144 == null) goto L55;
        int r145 = r144.hashCode();
    L56:
        int r146 = (r143 + r145) * 31;
        f r147 = this.f557668s;
        if (r147 == null) goto L59;
        int r148 = r147.hashCode();
    L60:
        int r149 = (r146 + r148) * 31;
        d r150 = this.f557669t;
        if (r150 == null) goto L63;
        int r151 = r150.hashCode();
    L64:
        int r152 = (r149 + r151) * 31;
        a r153 = this.f557670u;
        if (r153 == null) goto L67;
        int r154 = r153.hashCode();
    L68:
        int r155 = (r152 + r154) * 31;
        CardType r156 = this.f557671v;
        if (r156 == null) goto L71;
        int r157 = r156.hashCode();
    L72:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.f557672w;
        ?? r160 = r159;
        if (r159 == false) goto L75;
        r160 = 1;
    L75:
        int r161 = (r158 + r160) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.k r162 = this.f557673x;
        if (r162 == null) goto L78;
        int r163 = r162.hashCode();
    L79:
        int r164 = (r161 + r163) * 31;
        boolean r165 = this.f557674y;
        if (r165 == true) goto L83;
        r111 = r165;
    L83:
        int r166 = (r164 + r111) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.a r167 = this.f557675z;
        if (r167 == null) goto L87;
        r101 = r167.hashCode();
    L87:
        return r166 + r101;
    L78:
        r163 = 0;
        goto L79
    L71:
        r157 = 0;
        goto L72
    L67:
        r154 = 0;
        goto L68
    L63:
        r151 = 0;
        goto L64
    L59:
        r148 = 0;
        goto L60
    L55:
        r145 = 0;
        goto L56
    L51:
        r142 = 0;
        goto L52
    L47:
        r139 = 0;
        goto L48
    L43:
        r136 = 0;
        goto L44
    L39:
        r133 = 0;
        goto L40
    L35:
        r130 = 0;
        goto L36
    L31:
        r127 = 0;
        goto L32
    L27:
        r124 = 0;
        goto L28
    L23:
        r121 = 0;
        goto L24
    L19:
        r118 = 0;
        goto L20
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DialogIconModel(gift=" + this.f557650a + ", id=" + this.f557651b + ", image=" + this.f557652c + ", expireTimeIntervalSeconds=" + this.f557653d + ", isProp=" + this.f557654e + ", isPropDummy=" + this.f557655f + ", propInfo=" + this.f557656g + ", diamondCount=" + this.f557657h + ", groupCount=" + this.f557658i + ", groupIndex=" + this.f557659j + ", bottomInfo=" + this.f557660k + ", unselectedMainText=" + this.f557661l + ", unselectedSubText=" + this.f557662m + ", unselectedLocked=" + this.f557663n + ", giftIconImage=" + this.f557664o + ", giftPanelName=" + this.f557665p + ", giftPanelIconSource=" + this.f557666q + ", giftRealDiamond=" + this.f557667r + ", giftBottomLabelInfo=" + this.f557668s + ", diyShowIconInfo=" + this.f557669t + ", cardInfo=" + this.f557670u + ", giftIconBuffType=" + this.f557671v + ", shouldTouch=" + this.f557672w + ", panelLocationInfo=" + this.f557673x + ", forceInsertFromAi=" + this.f557674y + ", aiRecommendInfoModel=" + this.f557675z + ")";
    }

    public final boolean b() {
        return this.f557674y;
    }

    public final h1 c() {
        return this.f557650a;
    }

    public final long d() {
        return this.f557651b;
    }

    public final h e() {
        return this.f557656g;
    }

    public final boolean f() {
        return this.f557654e;
    }

    public final void g(com.bytedance.android.livesdk.gift.platform.core.model.k r100) {
        this.f557673x = r100;
    }

    public static e a(e r310, Pair r311, long r312, int r313, int r314, a r315, int r410) {
        if ((r410 & 1) == 0) goto L5;
        h1 r100 = r310.f557650a;
    L7:
        if ((r410 & 2) == 0) goto L9;
        long r101 = r310.f557651b;
    L11:
        if ((r410 & 4) == 0) goto L13;
        Pair r102 = r310.f557652c;
    L15:
        if ((r410 & 8) == 0) goto L17;
        long r103 = r310.f557653d;
    L19:
        if ((r410 & 16) == 0) goto L21;
        boolean r110 = r310.f557654e;
    L23:
        if ((r410 & 32) == 0) goto L25;
        boolean r111 = r310.f557655f;
    L27:
        if ((r410 & 64) == 0) goto L29;
        h r112 = r310.f557656g;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Long r113 = r310.f557657h;
    L35:
        if ((r410 & 256) == 0) goto L37;
        int r114 = r310.f557658i;
    L39:
        if ((r410 & 512) == 0) goto L41;
        int r115 = r310.f557659j;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r116 = r310.f557660k;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r117 = r310.f557661l;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r118 = r310.f557662m;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        Boolean r210 = r310.f557663n;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        k r211 = r310.f557664o;
    L63:
        if ((32768 & r410) == 0) goto L65;
        String r104 = r310.f557665p;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        GiftPanelIconSource r105 = r310.f557666q;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        Long r212 = r310.f557667r;
    L75:
        if ((262144 & r410) == 0) goto L77;
        f r213 = r310.f557668s;
    L79:
        if ((524288 & r410) == 0) goto L81;
        d r106 = r310.f557669t;
    L82:
        int r316 = r114;
        if ((r410 & 1048576) == 0) goto L85;
        a r119 = r310.f557670u;
    L86:
        Long r317 = r113;
        if ((r410 & 2097152) == 0) goto L89;
        CardType r120 = r310.f557671v;
    L91:
        if ((r410 & 4194304) == 0) goto L93;
        boolean r214 = r310.f557672w;
    L95:
        if ((8388608 & r410) == 0) goto L97;
        com.bytedance.android.livesdk.gift.platform.core.model.k r318 = r310.f557673x;
    L99:
        if ((16777216 & r410) == 0) goto L101;
        boolean r319 = r310.f557674y;
    L103:
        if ((r410 & 33554432) == 0) goto L105;
        com.bytedance.android.livesdk.gift.platform.core.model.a r320 = r310.f557675z;
    L106:
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter(r102, "image");
        Intrinsics.checkNotNullParameter(r112, "propInfo");
        Intrinsics.checkNotNullParameter(r104, "giftPanelName");
        Intrinsics.checkNotNullParameter(r105, "giftPanelIconSource");
        Intrinsics.checkNotNullParameter(r106, "diyShowIconInfo");
        Intrinsics.checkNotNullParameter(r119, "cardInfo");
        Intrinsics.checkNotNullParameter(r120, "giftIconBuffType");
        boolean r121 = r111;
        a r215 = r119;
        String r216 = r104;
        GiftPanelIconSource r217 = r105;
        return new e(r100, r101, r102, r103, r110, r121, r112, r317, r316, r115, r116, r117, r118, r210, r211, r216, r217, r212, r213, r106, r215, r120, r214, r318, r319, r320);
    L105:
        r320 = null;
        goto L106
    L101:
        r319 = false;
        goto L103
    L97:
        r318 = null;
        goto L99
    L93:
        r214 = false;
        goto L95
    L89:
        r120 = null;
        goto L91
    L85:
        r119 = r315;
        goto L86
    L81:
        r106 = null;
        goto L82
    L77:
        r213 = null;
        goto L79
    L73:
        r212 = null;
        goto L75
    L69:
        r105 = null;
        goto L71
    L65:
        r104 = null;
        goto L67
    L61:
        r211 = null;
        goto L63
    L57:
        r210 = null;
        goto L59
    L53:
        r118 = null;
        goto L55
    L49:
        r117 = null;
        goto L51
    L45:
        r116 = null;
        goto L47
    L41:
        r115 = r314;
        goto L43
    L37:
        r114 = r313;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = false;
        goto L27
    L21:
        r110 = false;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public e(h1 r310, long r311, Pair r312, long r313, boolean r410, boolean r411, h r412, Long r413, String r414, String r415, Boolean r416, k r417, String r418, GiftPanelIconSource r510, f r511, d r512, a r513, CardType r514, boolean r515, com.bytedance.android.livesdk.gift.platform.core.model.k r516, com.bytedance.android.livesdk.gift.platform.core.model.a r517, int r518) {
        if ((r518 & 2) == 0) goto L5;
        long r100 = r310.getId();
    L7:
        if ((r518 & 4) == 0) goto L9;
        Pair r101 = TuplesKt.to(-1, new i(null, r310.getImage(), null, null, 13));
    L11:
        if ((r518 & 8) == 0) goto L13;
        long r102 = r310.getGiftEndingTime() - ((System.currentTimeMillis() / 1000) - r310.getNowTimeDiffSeconds());
    L15:
        if ((r518 & 16) == 0) goto L17;
        boolean r110 = false;
    L19:
        if ((r518 & 32) == 0) goto L21;
        boolean r111 = false;
    L23:
        if ((r518 & 64) == 0) goto L25;
        h r112 = new h(0);
    L27:
        if ((r518 & 128) != 0) goto L29;
        Long r113 = r413;
    L38:
        if ((r518 & 256) == 0) goto L40;
        int r103 = 1;
    L42:
        if ((r518 & 512) == 0) goto L44;
        int r114 = -1;
    L46:
        if ((r518 & 1024) == 0) goto L50;
        r0 r104 = r310.getGiftUnselectedBottomInfo();
        if (r104 == null) goto L50;
        String r115 = r104.a();
    L52:
        if ((r518 & 2048) == 0) goto L54;
        String r116 = null;
    L56:
        if ((r518 & 4096) == 0) goto L58;
        String r117 = null;
    L60:
        if ((r518 & 8192) == 0) goto L62;
        Boolean r118 = Boolean.FALSE;
    L64:
        if ((r518 & 16384) == 0) goto L66;
        k r210 = r310.getImage();
    L68:
        if ((32768 & r518) == 0) goto L78;
        String r105 = r310.getName();
        if ((!TextUtils.isEmpty(r105)) == true) goto L73;
        r105 = null;
    L73:
        if (r105 != null) goto L75;
        r105 = r310.getDescribe();
    L75:
        if (r105 != null) goto L77;
        r105 = "";
    L77:
        String r211 = r105;
    L80:
        if ((65536 & r518) == 0) goto L82;
        GiftPanelIconSource r212 = GiftPanelIconSource.GIFT_LIST;
    L84:
        if ((131072 & r518) == 0) goto L86;
        Long r213 = r113;
    L88:
        if ((262144 & r518) == 0) goto L90;
        f r214 = null;
    L92:
        if ((524288 & r518) == 0) goto L94;
        d r215 = new d(null, null);
    L96:
        if ((1048576 & r518) == 0) goto L98;
        a r216 = new a(0, null, 0, null, false, null, null, 0, 255);
    L100:
        if ((2097152 & r518) == 0) goto L102;
        CardType r217 = CardType.None;
    L104:
        if ((4194304 & r518) == 0) goto L106;
        boolean r218 = false;
    L108:
        if ((8388608 & r518) == 0) goto L110;
        com.bytedance.android.livesdk.gift.platform.core.model.k r219 = null;
    L112:
        if ((r518 & 33554432) == 0) goto L114;
        com.bytedance.android.livesdk.gift.platform.core.model.a r314 = null;
    L115:
        this(r310, r100, r101, r102, r110, r111, r112, r113, r103, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, false, r314);
        return;
    L114:
        r314 = r517;
        goto L115
    L110:
        r219 = r516;
        goto L112
    L106:
        r218 = r515;
        goto L108
    L102:
        r217 = r514;
        goto L104
    L98:
        r216 = r513;
        goto L100
    L94:
        r215 = r512;
        goto L96
    L90:
        r214 = r511;
        goto L92
    L86:
        r213 = null;
        goto L88
    L82:
        r212 = r510;
        goto L84
    L78:
        r211 = r418;
        goto L80
    L66:
        r210 = r417;
        goto L68
    L62:
        r118 = r416;
        goto L64
    L58:
        r117 = r415;
        goto L60
    L54:
        r116 = r414;
    L50:
        r115 = null;
        goto L52
    L44:
        r114 = 0;
        goto L46
    L40:
        r103 = 0;
        goto L42
    L29:
        if (r310.getType() != 3) goto L31;
        r113 = null;
        goto L38
    L31:
        if (r110 == false) goto L34;
        if (r112 == null) goto L34;
        long r119 = r112.f557684g;
    L35:
        r113 = Long.valueOf(r119);
    L34:
        r119 = r310.getDiamondCount();
        goto L35
    L25:
        r112 = r412;
        goto L27
    L21:
        r111 = r411;
        goto L23
    L17:
        r110 = r410;
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

    public e(h1 r110, long r111, Pair<Integer, i> r112, long r113, boolean r114, boolean r115, h r210, Long r211, int r212, int r213, String r214, String r215, String r216, Boolean r217, k r218, String r219, GiftPanelIconSource r310, Long r311, f r312, d r313, a r314, CardType r315, boolean r316, com.bytedance.android.livesdk.gift.platform.core.model.k r317, boolean r318, com.bytedance.android.livesdk.gift.platform.core.model.a r319) {
        Intrinsics.checkNotNullParameter(r110, PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter(r112, "image");
        Intrinsics.checkNotNullParameter(r210, "propInfo");
        Intrinsics.checkNotNullParameter(r219, "giftPanelName");
        Intrinsics.checkNotNullParameter(r310, "giftPanelIconSource");
        Intrinsics.checkNotNullParameter(r313, "diyShowIconInfo");
        Intrinsics.checkNotNullParameter(r314, "cardInfo");
        Intrinsics.checkNotNullParameter(r315, "giftIconBuffType");
        this.f557650a = r110;
        this.f557651b = r111;
        this.f557652c = r112;
        this.f557653d = r113;
        this.f557654e = r114;
        this.f557655f = r115;
        this.f557656g = r210;
        this.f557657h = r211;
        this.f557658i = r212;
        this.f557659j = r213;
        this.f557660k = r214;
        this.f557661l = r215;
        this.f557662m = r216;
        this.f557663n = r217;
        this.f557664o = r218;
        this.f557665p = r219;
        this.f557666q = r310;
        this.f557667r = r311;
        this.f557668s = r312;
        this.f557669t = r313;
        this.f557670u = r314;
        this.f557671v = r315;
        this.f557672w = r316;
        this.f557673x = r317;
        this.f557674y = r318;
        this.f557675z = r319;
    }
}
