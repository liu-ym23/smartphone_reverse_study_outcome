package com.larus.platform.model.chat;

/* JADX INFO: loaded from: classes31.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f365594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f365595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f365596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f365597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f365598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f365599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f365600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f365601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f365602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f365603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f365604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f365605n;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f365592a == r101.f365592a) goto L12;
        return false;
    L12:
        if (this.f365593b == r101.f365593b) goto L15;
        return false;
    L15:
        if (this.f365594c == r101.f365594c) goto L18;
        return false;
    L18:
        if (this.f365595d == r101.f365595d) goto L21;
        return false;
    L21:
        if (this.f365596e == r101.f365596e) goto L24;
        return false;
    L24:
        if (this.f365597f == r101.f365597f) goto L27;
        return false;
    L27:
        if (this.f365598g == r101.f365598g) goto L30;
        return false;
    L30:
        if (this.f365599h == r101.f365599h) goto L33;
        return false;
    L33:
        if (this.f365600i == r101.f365600i) goto L36;
        return false;
    L36:
        if (this.f365601j == r101.f365601j) goto L39;
        return false;
    L39:
        if (this.f365602k == r101.f365602k) goto L42;
        return false;
    L42:
        if (this.f365603l == r101.f365603l) goto L45;
        return false;
    L45:
        if (this.f365604m == r101.f365604m) goto L48;
        return false;
    L48:
        if (Float.compare(this.f365605n, r101.f365605n) == 0) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365592a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f365593b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f365594c) * 31;
        if (this.f365595d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f365596e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f365597f == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f365598g == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f365599h == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f365600i == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.f365601j == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.f365602k == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.f365603l == true) goto L47;
        r100 = 1237;
    L47:
        return ((((r120 + r100) * 31) + this.f365604m) * 31) + Float.floatToIntBits(this.f365605n);
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationPreviewPerformanceOptConfig(ugcPreviewArgb=" + this.f365592a + ", bigImageFullSizeResize=" + this.f365593b + ", bigImageFullSizeResizeSize=" + this.f365594c + ", previewGalleryUseHeic=" + this.f365595d + ", msgCardResize=" + this.f365596e + ", feedRefResize=" + this.f365597f + ", feedAvatarResize=" + this.f365598g + ", feedArgb=" + this.f365599h + ", feedCoverSr=" + this.f365600i + ", videoCoverResize=" + this.f365601j + ", videoCoverArgb=" + this.f365602k + ", canvasResize=" + this.f365603l + ", largeMemGb=" + this.f365604m + ", srMinRatio=" + this.f365605n + ')';
    }

    public /* synthetic */ n(int r110) {
        this(false, false, 5000, false, false, false, false, false, false, false, false, false, 6, 1.1f);
    }

    public n(boolean r100, boolean r101, int r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, boolean r112, int r113, float r114) {
        this.f365592a = r100;
        this.f365593b = r101;
        this.f365594c = r102;
        this.f365595d = r103;
        this.f365596e = r104;
        this.f365597f = r105;
        this.f365598g = r106;
        this.f365599h = r107;
        this.f365600i = r108;
        this.f365601j = r110;
        this.f365602k = r111;
        this.f365603l = r112;
        this.f365604m = r113;
        this.f365605n = r114;
    }
}
