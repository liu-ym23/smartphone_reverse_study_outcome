package xy8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nr9.f f565464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f565465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f565467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f565468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f565469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f565470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f565471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f565472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Bitmap f565473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f565474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f565475p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f565460a, r101.f565460a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565461b, r101.f565461b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565462c, r101.f565462c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565463d, r101.f565463d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565464e, r101.f565464e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565465f, r101.f565465f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565466g, r101.f565466g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f565467h, r101.f565467h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f565468i, r101.f565468i) == true) goto L36;
        return false;
    L36:
        if (this.f565469j == r101.f565469j) goto L39;
        return false;
    L39:
        if (this.f565470k == r101.f565470k) goto L42;
        return false;
    L42:
        if (Double.compare(this.f565471l, r101.f565471l) == 0) goto L45;
        return false;
    L45:
        if (this.f565472m == r101.f565472m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f565473n, r101.f565473n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f565474o, r101.f565474o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f565475p, r101.f565475p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f565460a.hashCode() * 31;
        String r101 = this.f565461b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f565462c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f565463d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        nr9.f r111 = this.f565464e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f565465f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f565466g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f565467h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f565468i;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (((((r122 + r124) * 31) + this.f565469j) * 31) + this.f565470k) * 31;
        long r126 = Double.doubleToLongBits(this.f565471l);
        int r127 = (((r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31) + this.f565472m) * 31;
        Bitmap r128 = this.f565473n;
        if (r128 != null) goto L37;
        int r129 = 0;
    L38:
        int r130 = (((r127 + r129) * 31) + this.f565474o.hashCode()) * 31;
        String r131 = this.f565475p;
        if (r131 == null) goto L43;
        r102 = r131.hashCode();
    L43:
        return r130 + r102;
    L37:
        r129 = r128.hashCode();
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
        return "VideoContent(engineKey=" + this.f565460a + ", playUrl=" + this.f565461b + ", downloadFilehash=" + this.f565462c + ", coverUrl=" + this.f565463d + ", cover=" + this.f565464e + ", localPath=" + this.f565465f + ", videoModel=" + this.f565466g + ", format=" + this.f565467h + ", resourceId=" + this.f565468i + ", width=" + this.f565469j + ", height=" + this.f565470k + ", duration=" + this.f565471l + ", startTime=" + this.f565472m + ", coverBitmap=" + this.f565473n + ", tag=" + this.f565474o + ", localUri=" + this.f565475p + ')';
    }

    public static g a(g r110, int r210, Bitmap r211) {
        String r100 = r110.f565460a;
        String r101 = r110.f565461b;
        String r102 = r110.f565462c;
        String r103 = r110.f565463d;
        nr9.f r104 = r110.f565464e;
        String r105 = r110.f565465f;
        String r106 = r110.f565466g;
        String r107 = r110.f565467h;
        String r108 = r110.f565468i;
        int r111 = r110.f565469j;
        int r112 = r110.f565470k;
        double r113 = r110.f565471l;
        String r114 = r110.f565474o;
        String r115 = r110.f565475p;
        Intrinsics.checkNotNullParameter(r100, "engineKey");
        Intrinsics.checkNotNullParameter(r114, "tag");
        return new g(r100, r101, r102, r103, r104, r105, r106, r107, r108, r111, r112, r113, r210, r211, r114, r115);
    }

    public /* synthetic */ g(String r210, String r211, String r212, String r213, nr9.f r214, String r215, String r216, String r217, String r310, int r311, int r312, double r313, Bitmap r314, String r315, String r316, int r317) {
        if ((r317 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r317 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r317 & 16) == 0) goto L17;
        nr9.f r103 = null;
    L19:
        if ((r317 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r317 & 64) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r317 & 128) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r317 & 256) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r317 & 512) == 0) goto L37;
        int r113 = 0;
    L39:
        if ((r317 & 1024) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r317 & 2048) == 0) goto L45;
        double r115 = 0.0d;
    L47:
        if ((r317 & 8192) == 0) goto L49;
        Bitmap r116 = null;
    L51:
        if ((r317 & 16384) == 0) goto L53;
        String r117 = "";
    L55:
        if ((r317 & 32768) == 0) goto L57;
        String r218 = null;
    L58:
        this(r210, r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, 0, r116, r117, r218);
        return;
    L57:
        r218 = r316;
        goto L58
    L53:
        r117 = r315;
        goto L55
    L49:
        r116 = r314;
        goto L51
    L45:
        r115 = r313;
        goto L47
    L41:
        r114 = r312;
        goto L43
    L37:
        r113 = r311;
        goto L39
    L33:
        r112 = r310;
        goto L35
    L29:
        r111 = r217;
        goto L31
    L25:
        r110 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public g(String r100, String r101, String r102, String r103, nr9.f r110, String r111, String r112, String r113, String r114, int r115, int r116, double r117, int r118, Bitmap r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r100, "engineKey");
        Intrinsics.checkNotNullParameter(r211, "tag");
        this.f565460a = r100;
        this.f565461b = r101;
        this.f565462c = r102;
        this.f565463d = r103;
        this.f565464e = r110;
        this.f565465f = r111;
        this.f565466g = r112;
        this.f565467h = r113;
        this.f565468i = r114;
        this.f565469j = r115;
        this.f565470k = r116;
        this.f565471l = r117;
        this.f565472m = r118;
        this.f565473n = r210;
        this.f565474o = r211;
        this.f565475p = r212;
    }
}
