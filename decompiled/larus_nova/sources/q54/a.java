package q54;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f531731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f531732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f531733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f531734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f531735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f531736j;

    public a() {
        this(null, 0, false, false, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f531727a, r101.f531727a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531728b, r101.f531728b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f531729c, r101.f531729c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f531730d, r101.f531730d) == true) goto L21;
        return false;
    L21:
        if (this.f531731e == r101.f531731e) goto L24;
        return false;
    L24:
        if (this.f531732f == r101.f531732f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f531733g, r101.f531733g) == true) goto L30;
        return false;
    L30:
        if (this.f531734h == r101.f531734h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f531735i, r101.f531735i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f531736j, r101.f531736j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f531727a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f531728b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f531729c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f531730d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f531731e) * 31;
        boolean r113 = this.f531732f;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        String r117 = this.f531733g;
        if (r117 != null) goto L24;
        int r118 = 0;
    L25:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f531734h;
        if (r120 == true) goto L29;
        r114 = r120;
    L29:
        int r121 = (r119 + r114) * 31;
        String r122 = this.f531735i;
        if (r122 != null) goto L32;
        int r123 = 0;
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f531736j;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L32:
        r123 = r122.hashCode();
        goto L33
    L24:
        r118 = r117.hashCode();
        goto L25
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AosExportPreloadModel(aid=" + this.f531727a + ", gid=" + this.f531728b + ", clientParams=" + this.f531729c + ", localParams=" + this.f531730d + ", priority=" + this.f531731e + ", needCachePicture=" + this.f531732f + ", contentScene=" + this.f531733g + ", preloadVideoData=" + this.f531734h + ", requestId=" + this.f531735i + ", hostEnterFrom=" + this.f531736j + ')';
    }

    public a(String r100, int r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 16) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 32) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 128) == 0) goto L14;
        r103 = false;
    L14:
        this.f531727a = r100;
        this.f531728b = null;
        this.f531729c = null;
        this.f531730d = null;
        this.f531731e = r101;
        this.f531732f = r102;
        this.f531733g = null;
        this.f531734h = r103;
        this.f531735i = null;
        this.f531736j = null;
    }
}
