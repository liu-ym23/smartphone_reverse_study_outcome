package sf0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import kotlin.jvm.internal.Intrinsics;
import w20.xc;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f541681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f541683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f541684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkMatchType f541685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f541686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f541687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f541688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f541689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f541690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f541691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f541692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f541693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f541694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public tf0.b f541695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public xc.a f541696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f541697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f541698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f541699s;

    public a() {
        this(0, 0, 0, 0, null, null, null, 0, 0, 0, false, false, 0, null, null, 0, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L44;
        a r101 = (a) r100;
        if (this.f541681a == r101.f541681a) goto L8;
        return false;
    L8:
        if (this.f541682b == r101.f541682b) goto L10;
        return false;
    L10:
        if (this.f541683c == r101.f541683c) goto L12;
        return false;
    L12:
        if (this.f541684d == r101.f541684d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f541685e, r101.f541685e) == true) goto L16;
        return false;
    L16:
        if (this.f541686f == r101.f541686f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f541687g, r101.f541687g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f541688h, r101.f541688h) == true) goto L22;
        return false;
    L22:
        if (this.f541689i == r101.f541689i) goto L24;
        return false;
    L24:
        if (this.f541690j == r101.f541690j) goto L26;
        return false;
    L26:
        if (this.f541691k == r101.f541691k) goto L28;
        return false;
    L28:
        if (this.f541692l == r101.f541692l) goto L30;
        return false;
    L30:
        if (this.f541693m == r101.f541693m) goto L32;
        return false;
    L32:
        if (this.f541694n == r101.f541694n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f541695o, r101.f541695o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f541696p, r101.f541696p) == true) goto L38;
        return false;
    L38:
        if (this.f541697q == r101.f541697q) goto L40;
        return false;
    L40:
        if (this.f541698r == r101.f541698r) goto L42;
        return false;
    L42:
        if (this.f541699s == r101.f541699s) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = ((((((this.f541681a * 31) + this.f541682b) * 31) + this.f541683c) * 31) + this.f541684d) * 31;
        LinkMatchType r101 = this.f541685e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f541686f;
        ?? r106 = 1;
        ?? r107 = r105;
        if (r105 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f541687g;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f541688h;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (((((((r111 + r113) * 31) + this.f541689i) * 31) + this.f541690j) * 31) + this.f541691k) * 31;
        boolean r115 = this.f541692l;
        ?? r116 = r115;
        if (r115 == false) goto L20;
        r116 = 1;
    L20:
        int r117 = (r114 + r116) * 31;
        boolean r118 = this.f541693m;
        ?? r119 = r118;
        if (r118 == false) goto L23;
        r119 = 1;
    L23:
        int r120 = (((r117 + r119) * 31) + this.f541694n) * 31;
        tf0.b r121 = this.f541695o;
        if (r121 == null) goto L26;
        int r122 = r121.hashCode();
    L27:
        int r123 = (r120 + r122) * 31;
        xc.a r124 = this.f541696p;
        if (r124 == null) goto L30;
        r102 = r124.hashCode();
    L30:
        int r125 = (r123 + r102) * 31;
        boolean r126 = this.f541697q;
        ?? r127 = r126;
        if (r126 == false) goto L33;
        r127 = 1;
    L33:
        int r128 = (((r125 + r127) * 31) + this.f541698r) * 31;
        boolean r129 = this.f541699s;
        if (r129 == true) goto L38;
        r106 = r129;
    L38:
        return r128 + r106;
    L26:
        r122 = 0;
        goto L27
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ApplyParams(position=" + this.f541681a + ", applySource=" + this.f541682b + ", applyType=" + this.f541683c + ", layout=" + this.f541684d + ", matchType=" + this.f541685e + ", isFollowApply=" + this.f541686f + ", taskName=" + this.f541687g + ", fromSource=" + this.f541688h + ", teamId=" + this.f541689i + ", paidCount=" + this.f541690j + ", limitTime=" + this.f541691k + ", isAnonymous=" + this.f541692l + ", useMemberBenefits=" + this.f541693m + ", memberDiscountAmount=" + this.f541694n + ", applyCallback=" + this.f541695o + ", linkmicDiscountInfo=" + this.f541696p + ", jumpFollow=" + this.f541697q + ", linkType=" + this.f541698r + ", isApplyAfterIntercept=" + this.f541699s + ")";
    }

    public a(int r210, int r211, int r212, int r213, LinkMatchType r214, String r215, String r216, int r217, int r218, int r219, boolean r310, boolean r311, int r312, tf0.b r313, xc.a r314, int r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r316 & 2) == 0) goto L9;
        int r101 = 100;
    L11:
        if ((r316 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r316 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r316 & 16) == 0) goto L21;
        LinkMatchType r104 = LinkMatchType.NONE;
    L22:
        String r105 = "";
        if ((r316 & 64) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r316 & 128) != 0) goto L31;
        r105 = r216;
    L31:
        if ((r316 & 256) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r316 & 512) == 0) goto L37;
        int r111 = 0;
    L39:
        if ((r316 & 1024) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r316 & 2048) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r316 & 4096) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r316 & 8192) == 0) goto L53;
        int r115 = 0;
    L55:
        if ((r316 & 16384) == 0) goto L57;
        tf0.b r107 = null;
    L59:
        if ((r316 & 32768) == 0) goto L61;
        xc.a r116 = null;
    L63:
        if ((r316 & 131072) == 0) goto L65;
        int r108 = 0;
    L66:
        Intrinsics.checkNotNullParameter(r104, "matchType");
        Intrinsics.checkNotNullParameter(r106, "taskName");
        Intrinsics.checkNotNullParameter(r105, "fromSource");
        this.f541681a = r100;
        this.f541682b = r101;
        this.f541683c = r102;
        this.f541684d = r103;
        this.f541685e = r104;
        this.f541686f = false;
        this.f541687g = r106;
        this.f541688h = r105;
        this.f541689i = r110;
        this.f541690j = r111;
        this.f541691k = r112;
        this.f541692l = r113;
        this.f541693m = r114;
        this.f541694n = r115;
        this.f541695o = r107;
        this.f541696p = r116;
        this.f541697q = false;
        this.f541698r = r108;
        this.f541699s = false;
        return;
    L65:
        r108 = r315;
        goto L66
    L61:
        r116 = r314;
        goto L63
    L57:
        r107 = r313;
        goto L59
    L53:
        r115 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L25:
        r106 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L22
    L17:
        r103 = r213;
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
