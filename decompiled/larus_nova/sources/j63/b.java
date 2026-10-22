package j63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f497496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f497498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f497499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f497500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f497501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f497502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f497503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f497504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f497505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f497506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f497507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f497508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f497509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f497510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f497511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f497512s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L44;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f497494a, r101.f497494a) == true) goto L8;
        return false;
    L8:
        if (this.f497495b == r101.f497495b) goto L10;
        return false;
    L10:
        if (this.f497496c == r101.f497496c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f497497d, r101.f497497d) == true) goto L14;
        return false;
    L14:
        if (this.f497498e == r101.f497498e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f497499f, r101.f497499f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f497500g, r101.f497500g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f497501h, r101.f497501h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f497502i, r101.f497502i) == true) goto L24;
        return false;
    L24:
        if (this.f497503j == r101.f497503j) goto L26;
        return false;
    L26:
        if (this.f497504k == r101.f497504k) goto L28;
        return false;
    L28:
        if (this.f497505l == r101.f497505l) goto L30;
        return false;
    L30:
        if (this.f497506m == r101.f497506m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f497507n, r101.f497507n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f497508o, r101.f497508o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f497509p, r101.f497509p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f497510q, r101.f497510q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f497511r, r101.f497511r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f497512s, r101.f497512s) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v50 */
    public final int hashCode() {
        String r100 = this.f497494a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f497495b) * 31) + this.f497496c) * 31;
        String r104 = this.f497497d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f497498e) * 31;
        String r107 = this.f497499f;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f497500g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f497501h;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f497502i;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + this.f497503j) * 31;
        boolean r119 = this.f497504k;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (((((r118 + r120) * 31) + this.f497505l) * 31) + this.f497506m) * 31;
        String r122 = this.f497507n;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f497508o;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f497509p;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f497510q;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f497511r;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f497512s;
        if (r137 == null) goto L53;
        r101 = r137.hashCode();
    L53:
        return r136 + r101;
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
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GuessULikeRequestParam(productId=" + this.f497494a + ", count=" + this.f497495b + ", pageNum=" + this.f497496c + ", pageName=" + this.f497497d + ", cursor=" + this.f497498e + ", feedbacks=" + this.f497499f + ", filters=" + this.f497500g + ", enterFrom=" + this.f497501h + ", metaParam=" + this.f497502i + ", internalFeedAB=" + this.f497503j + ", productIsInvalid=" + this.f497504k + ", width=" + this.f497505l + ", height=" + this.f497506m + ", authorId=" + this.f497507n + ", shopId=" + this.f497508o + ", videoId=" + this.f497509p + ", ecomSceneId=" + this.f497510q + ", forceInsertTypeList=" + this.f497511r + ", sessionId=" + this.f497512s + ")";
    }

    public b(String r100, int r110, int r111, String r112, String r113, String r114, boolean r115, int r116, int r117, String r118, String r119, String r210, String r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "pageName");
        Intrinsics.checkNotNullParameter(r112, "feedbacks");
        Intrinsics.checkNotNullParameter(r113, "filters");
        Intrinsics.checkNotNullParameter("", "enterFrom");
        Intrinsics.checkNotNullParameter(r114, "metaParam");
        this.f497494a = r100;
        this.f497495b = 20;
        this.f497496c = r110;
        this.f497497d = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
        this.f497498e = r111;
        this.f497499f = r112;
        this.f497500g = r113;
        this.f497501h = "";
        this.f497502i = r114;
        this.f497503j = 0;
        this.f497504k = r115;
        this.f497505l = r116;
        this.f497506m = r117;
        this.f497507n = r118;
        this.f497508o = r119;
        this.f497509p = r210;
        this.f497510q = r211;
        this.f497511r = r212;
        this.f497512s = r213;
    }
}
