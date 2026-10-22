package iy9;

import com.larus.bmhome.bigimg.e;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.bigimg.n1;
import com.larus.search.api.event.HybridEventParams;
import ic8.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uo8.k;
import zo8.a;

/* JADX INFO: loaded from: classes31.dex */
public final class a<DATA extends zo8.a> {
    public final Function0<Unit> A;
    public int B;
    public String C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends DATA> f496589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f496590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f496591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f496592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f496593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<n1> f496594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f496595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f496596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f496597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f496598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f496599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f496600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f496601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f496602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final JSONObject f496603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HybridEventParams f496604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f496605q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f496606r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d f496607s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f496608t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f496609u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f496610v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l f496611w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f496612x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f496613y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f496614z;

    public a() {
        this(null, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, false, 0, false, null, 134217727);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f496589a, r101.f496589a) == true) goto L12;
        return false;
    L12:
        if (this.f496590b == r101.f496590b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496591c, r101.f496591c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496592d, r101.f496592d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f496593e, r101.f496593e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f496594f, r101.f496594f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f496595g, r101.f496595g) == true) goto L30;
        return false;
    L30:
        if (this.f496596h == r101.f496596h) goto L33;
        return false;
    L33:
        if (this.f496597i == r101.f496597i) goto L36;
        return false;
    L36:
        if (this.f496598j == r101.f496598j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f496599k, r101.f496599k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f496600l, r101.f496600l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f496601m, r101.f496601m) == true) goto L48;
        return false;
    L48:
        if (this.f496602n == r101.f496602n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f496603o, r101.f496603o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f496604p, r101.f496604p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f496605q, r101.f496605q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f496606r, r101.f496606r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f496607s, r101.f496607s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f496608t, r101.f496608t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f496609u, r101.f496609u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f496610v, r101.f496610v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f496611w, r101.f496611w) == true) goto L78;
        return false;
    L78:
        if (this.f496612x == r101.f496612x) goto L81;
        return false;
    L81:
        if (this.f496613y == r101.f496613y) goto L84;
        return false;
    L84:
        if (this.f496614z == r101.f496614z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f496589a.hashCode() * 31) + this.f496590b) * 31;
        k r101 = this.f496591c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        e r105 = this.f496592d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f496593e.hashCode()) * 31) + this.f496594f.hashCode()) * 31;
        List<String> r108 = this.f496595g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f496596h == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (((((r110 + r112) * 31) + this.f496597i) * 31) + this.f496598j) * 31;
        String r114 = this.f496599k;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Function0<Unit> r117 = this.f496600l;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Function0<Unit> r120 = this.f496601m;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.f496602n) * 31;
        JSONObject r123 = this.f496603o;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        HybridEventParams r126 = this.f496604p;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f496605q;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (((((((((((r128 + r130) * 31) + this.f496606r.hashCode()) * 31) + this.f496607s.hashCode()) * 31) + this.f496608t.hashCode()) * 31) + this.f496609u.hashCode()) * 31) + this.f496610v.hashCode()) * 31;
        l r132 = this.f496611w;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        if (this.f496612x == false) goto L49;
        int r135 = 1231;
    L50:
        long r136 = this.f496613y;
        int r137 = (((r134 + r135) * 31) + ((int) (r136 ^ (r136 >>> 32)))) * 31;
        if (this.f496614z == true) goto L54;
        r111 = 1237;
    L54:
        int r138 = (r137 + r111) * 31;
        Function0<Unit> r139 = this.A;
        if (r139 == null) goto L59;
        r102 = r139.hashCode();
    L59:
        return r138 + r102;
    L49:
        r135 = 1237;
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
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
        r112 = 1237;
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
        return "ImageDetailFragmentProp(initList=" + this.f496589a + ", initPosition=" + this.f496590b + ", initReportParams=" + this.f496591c + ", scrollListener=" + this.f496592d + ", initMessageId=" + this.f496593e + ", imageUrls=" + this.f496594f + ", thumbImageUrls=" + this.f496595g + ", showIndicator=" + this.f496596h + ", currentPagerPos=" + this.f496597i + ", totalIndicator=" + this.f496598j + ", messageId=" + this.f496599k + ", callback=" + this.f496600l + ", callbackByClick=" + this.f496601m + ", direction=" + this.f496602n + ", reportParam=" + this.f496603o + ", hybridEventParams=" + this.f496604p + ", currentCreationTypeFromIM=" + this.f496605q + ", aiImageParams=" + this.f496606r + ", aiVideoParams=" + this.f496607s + ", aiImageExpandParams=" + this.f496608t + ", aiImageErasePrams=" + this.f496609u + ", aiImageSharepnessParams=" + this.f496610v + ", imageInfo=" + this.f496611w + ", disableCollection=" + this.f496612x + ", entryClickTimeStamp=" + this.f496613y + ", isCaseMode=" + this.f496614z + ", onPagerDestroy=" + this.A + ')';
    }

    public a(List r310, int r311, k r312, e r313, String r314, List r315, List r410, int r411, String r412, pz9.d r413, pz9.e r414, int r415, JSONObject r416, Integer r417, d r418, d r419, d r510, d r511, d r512, boolean r513, long r514, boolean r515, Function0 r516, int r517) {
        if ((r517 & 1) == 0) goto L5;
        List r100 = new ArrayList();
    L7:
        if ((r517 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r517 & 4) == 0) goto L13;
        k r102 = null;
    L15:
        if ((r517 & 8) == 0) goto L17;
        e r103 = null;
    L19:
        if ((r517 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r517 & 32) == 0) goto L25;
        List r110 = CollectionsKt.emptyList();
    L27:
        if ((r517 & 64) == 0) goto L29;
        List r111 = null;
    L31:
        if ((r517 & 256) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r517 & 1024) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r517 & 2048) == 0) goto L41;
        pz9.d r114 = null;
    L43:
        if ((r517 & 4096) == 0) goto L45;
        pz9.e r115 = null;
    L47:
        if ((r517 & 8192) == 0) goto L49;
        int r105 = 0;
    L51:
        if ((r517 & 16384) == 0) goto L53;
        JSONObject r106 = null;
    L55:
        if ((r517 & 65536) == 0) goto L57;
        Integer r107 = null;
    L59:
        if ((r517 & 131072) == 0) goto L61;
        d r108 = new d(false, null, null, false, null, null, 63);
    L63:
        if ((r517 & 262144) == 0) goto L65;
        d r109 = new d(false, null, null, false, null, null, 63);
    L67:
        if ((r517 & 524288) == 0) goto L69;
        d r116 = new d(false, null, null, false, null, null, 63);
    L71:
        if ((r517 & 1048576) == 0) goto L73;
        d r117 = new d(false, null, null, false, null, null, 63);
    L75:
        if ((r517 & 2097152) == 0) goto L77;
        d r118 = new d(false, null, null, false, null, null, 63);
    L79:
        if ((r517 & 8388608) == 0) goto L81;
        boolean r210 = false;
    L83:
        if ((r517 & 16777216) == 0) goto L85;
        long r211 = 0;
    L87:
        if ((r517 & 33554432) == 0) goto L89;
        boolean r316 = false;
    L91:
        if ((r517 & 67108864) == 0) goto L93;
        Function0 r212 = null;
    L94:
        Intrinsics.checkNotNullParameter(r100, "initList");
        Intrinsics.checkNotNullParameter(r104, "initMessageId");
        Intrinsics.checkNotNullParameter(r110, "imageUrls");
        Intrinsics.checkNotNullParameter(r108, "aiImageParams");
        Intrinsics.checkNotNullParameter(r109, "aiVideoParams");
        Intrinsics.checkNotNullParameter(r116, "aiImageExpandParams");
        Intrinsics.checkNotNullParameter(r117, "aiImageErasePrams");
        Intrinsics.checkNotNullParameter(r118, "aiImageSharepnessParams");
        this.f496589a = r100;
        this.f496590b = r101;
        this.f496591c = r102;
        this.f496592d = r103;
        this.f496593e = r104;
        this.f496594f = r110;
        this.f496595g = r111;
        this.f496596h = false;
        this.f496597i = r112;
        this.f496598j = 0;
        this.f496599k = r113;
        this.f496600l = r114;
        this.f496601m = r115;
        this.f496602n = r105;
        this.f496603o = r106;
        this.f496604p = null;
        this.f496605q = r107;
        this.f496606r = r108;
        this.f496607s = r109;
        this.f496608t = r116;
        this.f496609u = r117;
        this.f496610v = r118;
        this.f496611w = null;
        this.f496612x = r210;
        this.f496613y = r211;
        this.f496614z = r316;
        this.A = r212;
        this.C = "";
        return;
    L93:
        r212 = r516;
        goto L94
    L89:
        r316 = r515;
        goto L91
    L85:
        r211 = r514;
        goto L87
    L81:
        r210 = r513;
        goto L83
    L77:
        r118 = r512;
        goto L79
    L73:
        r117 = r511;
        goto L75
    L69:
        r116 = r510;
        goto L71
    L65:
        r109 = r419;
        goto L67
    L61:
        r108 = r418;
        goto L63
    L57:
        r107 = r417;
        goto L59
    L53:
        r106 = r416;
        goto L55
    L49:
        r105 = r415;
        goto L51
    L45:
        r115 = r414;
        goto L47
    L41:
        r114 = r413;
        goto L43
    L37:
        r113 = r412;
        goto L39
    L33:
        r112 = r411;
        goto L35
    L29:
        r111 = r410;
        goto L31
    L25:
        r110 = r315;
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
