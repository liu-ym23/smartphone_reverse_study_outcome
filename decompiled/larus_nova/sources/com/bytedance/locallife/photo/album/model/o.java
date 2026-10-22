package com.bytedance.locallife.photo.album.model;

import com.bytedance.locallife.biz.mob.EventType;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.poi.resp.PoiCoinLabel;
import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiBundle f261998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f261999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f262000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f262001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f262002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f262003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AlbumPageInfo f262004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f262005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AlbumPageModel f262006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, String> f262007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f262008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f262009m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f262010n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PoiCoinLabel f262011o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PoiExtension f262012p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.locallife.biz.btm.b.a f262013q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final EventType f262014r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f262015s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f262016t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f262017u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<AlbumTabListModel> f262018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f262019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f262020x;

    public o() {
        this(null, null, null, 0, 0, false, 0, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, false, 16777215);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f261997a, r101.f261997a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f261998b, r101.f261998b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f261999c, r101.f261999c) == true) goto L18;
        return false;
    L18:
        if (this.f262000d == r101.f262000d) goto L21;
        return false;
    L21:
        if (this.f262001e == r101.f262001e) goto L24;
        return false;
    L24:
        if (this.f262002f == r101.f262002f) goto L27;
        return false;
    L27:
        if (this.f262003g == r101.f262003g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f262004h, r101.f262004h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f262005i, r101.f262005i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f262006j, r101.f262006j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f262007k, r101.f262007k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f262008l, r101.f262008l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f262009m, r101.f262009m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f262010n, r101.f262010n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f262011o, r101.f262011o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f262012p, r101.f262012p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f262013q, r101.f262013q) == true) goto L60;
        return false;
    L60:
        if (this.f262014r == r101.f262014r) goto L63;
        return false;
    L63:
        if (this.f262015s == r101.f262015s) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f262016t, r101.f262016t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f262017u, r101.f262017u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f262018v, r101.f262018v) == true) goto L75;
        return false;
    L75:
        if (this.f262019w == r101.f262019w) goto L78;
        return false;
    L78:
        if (this.f262020x == r101.f262020x) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f261997a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiBundle r104 = this.f261998b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.f261999c.hashCode()) * 31) + this.f262000d) * 31) + this.f262001e) * 31;
        int r107 = 1231;
        if (this.f262002f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f262003g) * 31;
        AlbumPageInfo r110 = this.f262004h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f262005i;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        AlbumPageModel r116 = this.f262006j;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.f262007k.hashCode()) * 31;
        String r119 = this.f262008l;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f262009m;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f262010n;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        PoiCoinLabel r128 = this.f262011o;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        PoiExtension r131 = this.f262012p;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        com.bytedance.locallife.biz.btm.b.a r134 = this.f262013q;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        EventType r137 = this.f262014r;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        if (this.f262015s == false) goto L57;
        int r140 = 1231;
    L58:
        int r141 = (r139 + r140) * 31;
        String r142 = this.f262016t;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (((r141 + r143) * 31) + this.f262017u.hashCode()) * 31;
        List<AlbumTabListModel> r145 = this.f262018v;
        if (r145 == null) goto L66;
        r101 = r145.hashCode();
    L66:
        int r146 = (r144 + r101) * 31;
        if (this.f262019w == false) goto L69;
        int r147 = 1231;
    L70:
        int r148 = (r146 + r147) * 31;
        if (this.f262020x == true) goto L75;
        r107 = 1237;
    L75:
        return r148 + r107;
    L69:
        r147 = 1237;
        goto L70
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = 1237;
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
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiCoverData(traceSessionId=" + this.f261997a + ", poiBundle=" + this.f261998b + ", extraDataMap=" + this.f261999c + ", position=" + this.f262000d + ", jumpMode=" + this.f262001e + ", showUploadButton=" + this.f262002f + ", picSum=" + this.f262003g + ", albumPageInfo=" + this.f262004h + ", tabId=" + this.f262005i + ", albumModel=" + this.f262006j + ", trackParams=" + this.f262007k + ", photosReportUrl=" + this.f262008l + ", galleryHeaderLynx=" + this.f262009m + ", galleryBottomLynx=" + this.f262010n + ", poiCoinLabel=" + this.f262011o + ", poiExtension=" + this.f262012p + ", builder=" + this.f262013q + ", eventType=" + this.f262014r + ", needAnchor=" + this.f262015s + ", anchorTabId=" + this.f262016t + ", anchorPagerType=" + this.f262017u + ", photoPageTabList=" + this.f262018v + ", showSingleLineFilterOnly=" + this.f262019w + ", isAlbumNewStyle=" + this.f262020x + ')';
    }

    public o(String r210, PoiBundle r211, HashMap r212, int r310, int r311, boolean r312, int r313, AlbumPageInfo r314, String r315, HashMap r316, String r317, String r318, String r319, PoiCoinLabel r410, PoiExtension r411, com.bytedance.locallife.biz.btm.b.a r412, EventType r413, boolean r414, String r415, String r416, List r417, boolean r418, boolean r419, int r510) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r510 & 2) == 0) goto L9;
        PoiBundle r101 = null;
    L11:
        if ((r510 & 4) == 0) goto L13;
        HashMap r102 = new HashMap();
    L15:
        if ((r510 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r510 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r510 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r510 & 64) == 0) goto L29;
        int r110 = 0;
    L31:
        if ((r510 & 128) == 0) goto L33;
        AlbumPageInfo r111 = null;
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r510 & 1024) == 0) goto L41;
        HashMap r113 = new HashMap();
    L43:
        if ((r510 & 2048) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r510 & 4096) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r510 & 8192) == 0) goto L53;
        String r106 = null;
    L55:
        if ((r510 & 16384) == 0) goto L57;
        PoiCoinLabel r107 = null;
    L59:
        if ((r510 & 32768) == 0) goto L61;
        PoiExtension r116 = null;
    L63:
        if ((r510 & 65536) == 0) goto L65;
        com.bytedance.locallife.biz.btm.b.a r117 = null;
    L67:
        if ((r510 & 131072) == 0) goto L69;
        EventType r118 = null;
    L71:
        if ((r510 & 262144) == 0) goto L73;
        boolean r213 = false;
    L75:
        if ((r510 & 524288) == 0) goto L77;
        String r214 = null;
    L79:
        if ((r510 & 1048576) == 0) goto L81;
        String r108 = "photo";
    L83:
        if ((r510 & 2097152) == 0) goto L85;
        List r215 = null;
    L87:
        if ((r510 & 4194304) == 0) goto L89;
        boolean r216 = false;
    L91:
        if ((r510 & 8388608) == 0) goto L93;
        boolean r217 = false;
    L94:
        Intrinsics.checkNotNullParameter(r102, "extraDataMap");
        Intrinsics.checkNotNullParameter(r113, "trackParams");
        Intrinsics.checkNotNullParameter(r108, "anchorPagerType");
        this.f261997a = r100;
        this.f261998b = r101;
        this.f261999c = r102;
        this.f262000d = r103;
        this.f262001e = r104;
        this.f262002f = r105;
        this.f262003g = r110;
        this.f262004h = r111;
        this.f262005i = r112;
        this.f262006j = null;
        this.f262007k = r113;
        this.f262008l = r114;
        this.f262009m = r115;
        this.f262010n = r106;
        this.f262011o = r107;
        this.f262012p = r116;
        this.f262013q = r117;
        this.f262014r = r118;
        this.f262015s = r213;
        this.f262016t = r214;
        this.f262017u = r108;
        this.f262018v = r215;
        this.f262019w = r216;
        this.f262020x = r217;
        return;
    L93:
        r217 = r419;
        goto L94
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r108 = r416;
        goto L83
    L77:
        r214 = r415;
        goto L79
    L73:
        r213 = r414;
        goto L75
    L69:
        r118 = r413;
        goto L71
    L65:
        r117 = r412;
        goto L67
    L61:
        r116 = r411;
        goto L63
    L57:
        r107 = r410;
        goto L59
    L53:
        r106 = r319;
        goto L55
    L49:
        r115 = r318;
        goto L51
    L45:
        r114 = r317;
        goto L47
    L41:
        r113 = r316;
        goto L43
    L37:
        r112 = r315;
        goto L39
    L33:
        r111 = r314;
        goto L35
    L29:
        r110 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
