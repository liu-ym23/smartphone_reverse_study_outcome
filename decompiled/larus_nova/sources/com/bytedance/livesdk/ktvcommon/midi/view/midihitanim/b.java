package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f256102n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f256103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f256104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f256105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f256106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f256107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f256108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f256109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f256110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f256111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f256112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f256113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f256114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f256115m;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L32;
        b r101 = (b) r100;
        if (Float.compare(this.f256103a, r101.f256103a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f256104b, r101.f256104b) == 0) goto L10;
        return false;
    L10:
        if (this.f256105c == r101.f256105c) goto L12;
        return false;
    L12:
        if (this.f256106d == r101.f256106d) goto L14;
        return false;
    L14:
        if (this.f256107e == r101.f256107e) goto L16;
        return false;
    L16:
        if (this.f256108f == r101.f256108f) goto L18;
        return false;
    L18:
        if (this.f256109g == r101.f256109g) goto L20;
        return false;
    L20:
        if (this.f256110h == r101.f256110h) goto L22;
        return false;
    L22:
        if (this.f256111i == r101.f256111i) goto L24;
        return false;
    L24:
        if (this.f256112j == r101.f256112j) goto L26;
        return false;
    L26:
        if (this.f256113k == r101.f256113k) goto L28;
        return false;
    L28:
        if (this.f256114l == r101.f256114l) goto L30;
        return false;
    L30:
        if (this.f256115m == r101.f256115m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((Float.floatToIntBits(this.f256103a) * 31) + Float.floatToIntBits(this.f256104b)) * 31) + this.f256105c) * 31) + this.f256106d) * 31) + this.f256107e) * 31) + this.f256108f) * 31) + this.f256109g) * 31) + this.f256110h) * 31;
        long r101 = this.f256111i;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f256112j;
        return ((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f256113k) * 31) + this.f256114l) * 31) + this.f256115m;
    }

    public final String toString() {
        return "KtvHitParticleConfig(startX=" + this.f256103a + ", startY=" + this.f256104b + ", offset=" + this.f256105c + ", normalRangeX=" + this.f256106d + ", normalRangeY=" + this.f256107e + ", advancedRangeX=" + this.f256108f + ", advancedRangeY=" + this.f256109g + ", particleSize=" + this.f256110h + ", normalAnimDuration=" + this.f256111i + ", advancedAnimDuration=" + this.f256112j + ", normalMaxCache=" + this.f256113k + ", advancedMaxCache=" + this.f256114l + ", animGap=" + this.f256115m + ")";
    }

    public b(float r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f256103a = r100;
        this.f256104b = 0.0f;
        this.f256105c = r101;
        this.f256106d = r102;
        this.f256107e = r103;
        this.f256108f = r104;
        this.f256109g = r105;
        this.f256110h = r106;
        this.f256111i = 2000;
        this.f256112j = 2500;
        this.f256113k = 4;
        this.f256114l = r107;
        this.f256115m = r108;
    }
}
