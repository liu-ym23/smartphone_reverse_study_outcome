package tla;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f546697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double[][] f546698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double[] f546699c;

    @Override // tla.b
    public final double[] g() {
        return this.f546697a;
    }

    @Override // tla.b
    public final double b(double r110) {
        double[] r100 = this.f546697a;
        int r101 = r100.length;
        double r102 = r100[0];
        if (r110 > r102) goto L5;
        double r103 = this.f546698b[0][0];
        double r111 = r110 - r102;
        double r104 = e(r102);
    L9:
        return r103 + (r111 * r104);
    L5:
        int r105 = r101 - 1;
        double r106 = r100[r105];
        if (r110 < r106) goto L10;
        r103 = this.f546698b[r105][0];
        r111 = r110 - r106;
        r104 = e(r106);
        goto L9
    L10:
        int r107 = 0;
    L11:
        if (r107 >= r105) goto L21;
        double[] r108 = this.f546697a;
        double r109 = r108[r107];
        if (r110 == r109) goto L15;
        int r112 = r107 + 1;
        double r113 = r108[r112];
        if (r110 < r113) goto L18;
        r107 = r112;
        goto L11
    L18:
        double r114 = (r110 - r109) / (r113 - r109);
        double[][] r115 = this.f546698b;
        return (r115[r107][0] * (1.0d - r114)) + (r115[r112][0] * r114);
    L15:
        return this.f546698b[r107][0];
    L21:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // tla.b
    public final double e(double r100) {
        double[] r101 = this.f546697a;
        int r102 = r101.length;
        double r103 = r101[0];
        if (r100 >= r103) goto L5;
    L4:
        r100 = r103;
    L8:
        int r104 = 0;
    L10:
        if (r104 >= (r102 - 1)) goto L16;
        double[] r105 = this.f546697a;
        int r106 = r104 + 1;
        double r107 = r105[r106];
        if (r100 <= r107) goto L13;
        r104 = r106;
        goto L10
    L13:
        double r108 = r107 - r105[r104];
        double[][] r109 = this.f546698b;
        return (r109[r106][0] - r109[r104][0]) / r108;
    L16:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        r103 = r101[r102 - 1];
        if (r100 < r103) goto L8;
        goto L8
    }

    public g(double[] r100, double[][] r101) {
        int r102 = r101[0].length;
        this.f546699c = new double[r102];
        this.f546697a = r100;
        this.f546698b = r101;
        if (r102 <= 2) goto L11;
        double r103 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r104 = 0;
    L6:
        if (r104 >= r100.length) goto L15;
        double r105 = r101[r104][0];
        if (r104 <= 0) goto L10;
        double r106 = r105 - r103;
        Math.hypot(r106, r106);
    L10:
        r104 = r104 + 1;
        r103 = r105;
        goto L6
    L15:
        return;
    }

    @Override // tla.b
    public final void c(double r110, double[] r111) {
        double[] r100 = this.f546697a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546698b[0].length;
        double r104 = r100[0];
        if (r110 > r104) goto L8;
        f(r104, this.f546699c);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r111[r105] = this.f546698b[0][r105] + ((r110 - this.f546697a[0]) * this.f546699c[r105]);
        r105 = r105 + 1;
        goto L5
    L7:
        return;
    L8:
        int r106 = r101 - 1;
        double r107 = r100[r106];
        if (r110 < r107) goto L14;
        f(r107, this.f546699c);
    L11:
        if (r102 >= r103) goto L13;
        r111[r102] = this.f546698b[r106][r102] + ((r110 - this.f546697a[r106]) * this.f546699c[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return;
    L14:
        int r108 = 0;
    L16:
        if (r108 >= (r101 - 1)) goto L29;
        if (r110 != this.f546697a[r108]) goto L22;
        int r109 = 0;
    L20:
        if (r109 >= r103) goto L22;
        r111[r109] = this.f546698b[r108][r109];
        r109 = r109 + 1;
    L22:
        double[] r112 = this.f546697a;
        int r113 = r108 + 1;
        double r114 = r112[r113];
        if (r110 < r114) goto L24;
        r108 = r113;
        goto L16
    L24:
        double r115 = r112[r108];
        double r116 = (r110 - r115) / (r114 - r115);
    L25:
        if (r102 >= r103) goto L27;
        double[][] r117 = this.f546698b;
        r111[r102] = (r117[r108][r102] * (1.0d - r116)) + (r117[r113][r102] * r116);
        r102 = r102 + 1;
        goto L25
    L27:
        return;
    }

    @Override // tla.b
    public final void d(double r110, float[] r111) {
        double[] r100 = this.f546697a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546698b[0].length;
        double r104 = r100[0];
        if (r110 > r104) goto L8;
        f(r104, this.f546699c);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r111[r105] = (float) (this.f546698b[0][r105] + ((r110 - this.f546697a[0]) * this.f546699c[r105]));
        r105 = r105 + 1;
        goto L5
    L7:
        return;
    L8:
        int r106 = r101 - 1;
        double r107 = r100[r106];
        if (r110 < r107) goto L14;
        f(r107, this.f546699c);
    L11:
        if (r102 >= r103) goto L13;
        r111[r102] = (float) (this.f546698b[r106][r102] + ((r110 - this.f546697a[r106]) * this.f546699c[r102]));
        r102 = r102 + 1;
        goto L11
    L13:
        return;
    L14:
        int r108 = 0;
    L15:
        if (r108 >= r106) goto L28;
        if (r110 != this.f546697a[r108]) goto L21;
        int r109 = 0;
    L19:
        if (r109 >= r103) goto L21;
        r111[r109] = (float) this.f546698b[r108][r109];
        r109 = r109 + 1;
    L21:
        double[] r112 = this.f546697a;
        int r113 = r108 + 1;
        double r114 = r112[r113];
        if (r110 < r114) goto L23;
        r108 = r113;
        goto L15
    L23:
        double r115 = r112[r108];
        double r116 = (r110 - r115) / (r114 - r115);
    L24:
        if (r102 >= r103) goto L26;
        double[][] r117 = this.f546698b;
        r111[r102] = (float) ((r117[r108][r102] * (1.0d - r116)) + (r117[r113][r102] * r116));
        r102 = r102 + 1;
        goto L24
    L26:
        return;
    }

    @Override // tla.b
    public final void f(double r110, double[] r111) {
        double[] r100 = this.f546697a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546698b[0].length;
        double r104 = r100[0];
        if (r110 > r104) goto L5;
    L4:
        r110 = r104;
    L8:
        int r105 = 0;
    L10:
        if (r105 >= (r101 - 1)) goto L17;
        double[] r106 = this.f546697a;
        int r107 = r105 + 1;
        double r108 = r106[r107];
        if (r110 <= r108) goto L13;
        r105 = r107;
        goto L10
    L13:
        double r109 = r108 - r106[r105];
    L14:
        if (r102 >= r103) goto L21;
        double[][] r112 = this.f546698b;
        r111[r102] = (r112[r107][r102] - r112[r105][r102]) / r109;
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r104 = r100[r101 - 1];
        if (r110 < r104) goto L8;
        goto L8
    }
}
