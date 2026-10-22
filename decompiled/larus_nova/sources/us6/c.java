package us6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f551518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f551519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f551520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f551521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f551522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f551523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f551524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f551525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f551526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f551527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f551528l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f551529m;

    public c() {
        this(null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f551517a, r101.f551517a) == true) goto L12;
        return false;
    L12:
        if (this.f551518b == r101.f551518b) goto L15;
        return false;
    L15:
        if (this.f551519c == r101.f551519c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f551520d, r101.f551520d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f551521e, r101.f551521e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f551522f, r101.f551522f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f551523g, r101.f551523g) == true) goto L30;
        return false;
    L30:
        if (this.f551524h == r101.f551524h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f551525i, r101.f551525i) == true) goto L36;
        return false;
    L36:
        if (this.f551526j == r101.f551526j) goto L39;
        return false;
    L39:
        if (this.f551527k == r101.f551527k) goto L42;
        return false;
    L42:
        if (this.f551528l == r101.f551528l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f551529m, r101.f551529m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f551517a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f551518b) * 31;
        long r104 = this.f551519c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f551520d;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f551521e;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f551522f;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f551523g;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        int r118 = 1231;
        if (this.f551524h == false) goto L25;
        int r119 = 1231;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f551525i;
        if (r121 == null) goto L30;
        r101 = r121.hashCode();
    L30:
        int r122 = (r120 + r101) * 31;
        if (this.f551526j == true) goto L35;
        r118 = 1237;
    L35:
        return ((((((r122 + r118) * 31) + this.f551527k) * 31) + this.f551528l) * 31) + this.f551529m.hashCode();
    L25:
        r119 = 1237;
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SaasAwemeInfo(awemeid=" + this.f551517a + ", awemeType=" + this.f551518b + ", awemeLikeCount=" + this.f551519c + ", distanceInfo=" + this.f551520d + ", requestId=" + this.f551521e + ", authorId=" + this.f551522f + ", anchorRelLogExtraParams=" + this.f551523g + ", isLifeItem=" + this.f551524h + ", serviceType=" + this.f551525i + ", anchorHasMp=" + this.f551526j + ", picFromSource=" + this.f551527k + ", graphicSourceFrom=" + this.f551528l + ", lifeContentType=" + this.f551529m + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r110, int r111) {
        String r105 = null;
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 16) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 32) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 64) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 256) == 0) goto L21;
        r110 = null;
    L21:
        if ((r111 & 4096) == 0) goto L23;
        r105 = "";
    L23:
        Intrinsics.checkNotNullParameter(r105, "lifeContentType");
        this.f551517a = r100;
        this.f551518b = 0;
        this.f551519c = 0;
        this.f551520d = r101;
        this.f551521e = r102;
        this.f551522f = r103;
        this.f551523g = r104;
        this.f551524h = false;
        this.f551525i = r110;
        this.f551526j = false;
        this.f551527k = 0;
        this.f551528l = 0;
        this.f551529m = r105;
    }
}
