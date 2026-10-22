package tla;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f546716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f546717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f546718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f546719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f546720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f546721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f546722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f546723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f546724i;

    @Override // tla.n
    public final float b() {
        return 0.0f;
    }

    @Override // tla.n
    public final boolean a() {
        double r100 = ((double) this.f546720e) - this.f546718c;
        double r101 = this.f546717b;
        double r102 = this.f546721f;
        if (Math.sqrt((((r102 * r102) * ((double) this.f546722g)) + ((r101 * r100) * r100)) / r101) > this.f546723h) goto L5;
        return true;
    L5:
        return false;
    }

    public l() {
        this.f546716a = 0.5d;
        this.f546724i = 0;
    }

    @Override // tla.n
    public final float getInterpolation(float r210) {
        l r100 = this;
        float r101 = r210;
        double r102 = r101 - r100.f546719d;
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        double r103 = r100.f546717b;
        double r104 = r100.f546716a;
        int r105 = (int) ((9.0d / ((Math.sqrt(r103 / ((double) r100.f546722g)) * r102) * 4.0d)) + 1.0d);
        double r106 = r102 / ((double) r105);
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L20;
        float r110 = r100.f546720e;
        double r111 = r110;
        double r112 = r100.f546718c;
        int r113 = r105;
        int r114 = r107;
        double r108 = (-r103) * (r111 - r112);
        float r115 = r100.f546721f;
        double r116 = r103;
        double r109 = r115;
        double r117 = r100.f546722g;
        double r118 = ((((r108 - (r109 * r104)) / r117) * r106) / 2.0d) + r109;
        double r119 = ((((-((r111 + ((r106 * r118) / 2.0d)) - r112)) * r116) - (r118 * r104)) / r117) * r106;
        float r120 = r115 + ((float) r119);
        r100 = this;
        r100.f546721f = r120;
        float r121 = r110 + ((float) ((r109 + (r119 / 2.0d)) * r106));
        r100.f546720e = r121;
        int r122 = r100.f546724i;
        if (r122 <= 0) goto L19;
        if (r121 < 0.0f) goto L12;
    L14:
        float r123 = r100.f546720e;
        if (r123 <= 1.0f) goto L19;
        if ((r122 & 2) != 2) goto L19;
        r100.f546720e = 2.0f - r123;
        r100.f546721f = -r100.f546721f;
        goto L19
    L12:
        if ((r122 & 1) != 1) goto L14;
        r100.f546720e = -r121;
        r100.f546721f = -r120;
    L19:
        r107 = r114 + 1;
        r105 = r113;
        r103 = r116;
        goto L6
    L20:
        r101 = r210;
    L21:
        r100.f546719d = r101;
        if (a() == false) goto L25;
        r100.f546720e = (float) r100.f546718c;
    L25:
        return r100.f546720e;
    }
}
