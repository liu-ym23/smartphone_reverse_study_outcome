package dw;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f470285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f470286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f470287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f470288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f470289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f470290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f470291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f470292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f470293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f470294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f470295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f470296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f470297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f470298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final JSONObject f470299o;

    public a() {
        this(0, 0, 0, 0, 0, null, 0, false, null, null, 0, null, 0, 0, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L36;
        a r101 = (a) r100;
        if (this.f470285a == r101.f470285a) goto L8;
        return false;
    L8:
        if (this.f470286b == r101.f470286b) goto L10;
        return false;
    L10:
        if (this.f470287c == r101.f470287c) goto L12;
        return false;
    L12:
        if (this.f470288d == r101.f470288d) goto L14;
        return false;
    L14:
        if (this.f470289e == r101.f470289e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f470290f, r101.f470290f) == true) goto L18;
        return false;
    L18:
        if (this.f470291g == r101.f470291g) goto L20;
        return false;
    L20:
        if (this.f470292h == r101.f470292h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f470293i, r101.f470293i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f470294j, r101.f470294j) == true) goto L26;
        return false;
    L26:
        if (this.f470295k == r101.f470295k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f470296l, r101.f470296l) == true) goto L30;
        return false;
    L30:
        if (this.f470297m == r101.f470297m) goto L32;
        return false;
    L32:
        if (this.f470298n == r101.f470298n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f470299o, r101.f470299o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    public final int hashCode() {
        int r100 = this.f470285a * 31;
        long r101 = this.f470286b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f470287c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f470288d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f470289e;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f470290f;
        int r110 = 0;
        if (r109 == null) goto L5;
        int r111 = r109.hashCode();
    L6:
        int r112 = (((r108 + r111) * 31) + this.f470291g) * 31;
        boolean r113 = this.f470292h;
        ?? r114 = r113;
        if (r113 == false) goto L9;
        r114 = 1;
    L9:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.f470293i;
        if (r116 == null) goto L12;
        int r117 = r116.hashCode();
    L13:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.f470294j;
        if (r119 == null) goto L16;
        int r120 = r119.hashCode();
    L17:
        long r121 = this.f470295k;
        int r122 = (((r118 + r120) * 31) + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        String r123 = this.f470296l;
        if (r123 == null) goto L20;
        int r124 = r123.hashCode();
    L21:
        int r125 = (((((r122 + r124) * 31) + this.f470297m) * 31) + this.f470298n) * 31;
        JSONObject r126 = this.f470299o;
        if (r126 == null) goto L25;
        r110 = r126.hashCode();
    L25:
        return r125 + r110;
    L20:
        r124 = 0;
        goto L21
    L16:
        r120 = 0;
        goto L17
    L12:
        r117 = 0;
        goto L13
    L5:
        r111 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDownloadInfo(status=" + this.f470285a + ", totalBytes=" + this.f470286b + ", currentBytes=" + this.f470287c + ", realCurrentBytes=" + this.f470288d + ", downloadTime=" + this.f470289e + ", fileName=" + this.f470290f + ", failStatus=" + this.f470291g + ", onlyWifi=" + this.f470292h + ", reserveInfo=" + this.f470293i + ", enableFeature=" + this.f470294j + ", downloadId=" + this.f470295k + ", downloadUrl=" + this.f470296l + ", callScene=" + this.f470297m + ", realPercent=" + this.f470298n + ", extra=" + this.f470299o + ")";
    }

    public a(int r210, long r211, long r212, long r213, long r214, String r310, int r311, boolean r312, JSONObject r313, JSONObject r314, long r315, String r316, int r317, int r410, JSONObject r411, int r412) {
        if ((r412 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r412 & 2) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r412 & 4) == 0) goto L13;
        long r102 = -1;
    L15:
        if ((r412 & 8) == 0) goto L17;
        long r110 = -1;
    L19:
        if ((r412 & 16) == 0) goto L21;
        long r111 = -1;
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r103 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        int r104 = 0;
    L31:
        if ((r412 & 128) == 0) goto L33;
        boolean r105 = false;
    L35:
        if ((r412 & 256) == 0) goto L37;
        JSONObject r106 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        JSONObject r112 = null;
    L42:
        JSONObject r215 = r112;
        if ((r412 & 1024) == 0) goto L45;
        long r113 = -1;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r114 = "";
    L50:
        JSONObject r115 = r106;
        if ((r412 & 4096) == 0) goto L53;
        int r107 = 0;
    L54:
        int r116 = r107;
        if ((r412 & 8192) == 0) goto L57;
        int r108 = 0;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        JSONObject r117 = null;
    L62:
        Intrinsics.checkNotNullParameter(r114, "downloadUrl");
        this.f470285a = r100;
        this.f470286b = r101;
        this.f470287c = r102;
        this.f470288d = r110;
        this.f470289e = r111;
        this.f470290f = r103;
        this.f470291g = r104;
        this.f470292h = r105;
        this.f470293i = r115;
        this.f470294j = r215;
        this.f470295k = r113;
        this.f470296l = r114;
        this.f470297m = r116;
        this.f470298n = r108;
        this.f470299o = r117;
        return;
    L61:
        r117 = r411;
        goto L62
    L57:
        r108 = r410;
        goto L59
    L53:
        r107 = r317;
        goto L54
    L49:
        r114 = r316;
        goto L50
    L45:
        r113 = r315;
        goto L47
    L41:
        r112 = r314;
        goto L42
    L37:
        r106 = r313;
        goto L39
    L33:
        r105 = r312;
        goto L35
    L29:
        r104 = r311;
        goto L31
    L25:
        r103 = r310;
        goto L27
    L21:
        r111 = r214;
        goto L23
    L17:
        r110 = r213;
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
