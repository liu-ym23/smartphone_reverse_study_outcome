package tla;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f546700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double[][] f546701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double[][] f546702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f546703d;

    public static double h(double r110, double r111, double r112, double r113, double r114, double r210) {
        double r100 = r111 * r111;
        double r101 = r111 * 6.0d;
        double r102 = (((((-6.0d) * r100) * r113) + (r101 * r113)) + ((6.0d * r100) * r112)) - (r101 * r112);
        double r103 = 3.0d * r110;
        return ((((r102 + ((r103 * r210) * r100)) + ((r103 * r114) * r100)) - (((2.0d * r110) * r210) * r111)) - (((4.0d * r110) * r114) * r111)) + (r110 * r114);
    }

    public static double i(double r110, double r111, double r112, double r113, double r210, double r211) {
        double r100 = r111 * r111;
        double r101 = r100 * r111;
        double r102 = 3.0d * r100;
        double r103 = ((((((-2.0d) * r101) * r113) + (r102 * r113)) + ((r101 * 2.0d) * r112)) - (r102 * r112)) + r112;
        double r104 = r110 * r211;
        double r105 = r103 + (r104 * r101);
        double r114 = r110 * r210;
        return (((r105 + (r101 * r114)) - (r104 * r100)) - (((r110 * 2.0d) * r210) * r100)) + (r114 * r111);
    }

    @Override // tla.b
    public final double[] g() {
        return this.f546700a;
    }

    @Override // tla.b
    public final double b(double r210) {
        double[] r100 = this.f546700a;
        int r101 = r100.length;
        double r102 = r100[0];
        if (r210 <= r102) goto L5;
        int r103 = r101 - 1;
        double r104 = r100[r103];
        if (r210 >= r104) goto L9;
        int r105 = 0;
    L11:
        if (r105 >= r103) goto L21;
        double[] r106 = this.f546700a;
        double r107 = r106[r105];
        if (r210 == r107) goto L15;
        int r108 = r105 + 1;
        double r109 = r106[r108];
        if (r210 < r109) goto L18;
        r105 = r108;
        goto L11
    L18:
        double r110 = r109 - r107;
        double r111 = (r210 - r107) / r110;
        double[][] r112 = this.f546701b;
        double r113 = r112[r105][0];
        double r114 = r112[r108][0];
        double[][] r115 = this.f546702c;
        return i(r110, r111, r113, r114, r115[r105][0], r115[r108][0]);
    L15:
        return this.f546701b[r105][0];
    L21:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        return this.f546701b[r103][0] + ((r210 - r104) * e(r104));
    L5:
        return this.f546701b[0][0] + ((r210 - r102) * e(r102));
    }

    @Override // tla.b
    public final double e(double r210) {
        double[] r100 = this.f546700a;
        int r101 = r100.length;
        double r102 = r100[0];
        if (r210 >= r102) goto L5;
    L4:
        int r103 = 0;
    L10:
        if (r103 >= (r101 - 1)) goto L16;
        double[] r104 = this.f546700a;
        int r105 = r103 + 1;
        double r106 = r104[r105];
        if (r102 <= r106) goto L13;
        r103 = r105;
        goto L10
    L13:
        double r110 = r104[r103];
        double r107 = r106 - r110;
        double r111 = (r102 - r110) / r107;
        double[][] r108 = this.f546701b;
        double r112 = r108[r103][0];
        double r113 = r108[r105][0];
        double[][] r109 = this.f546702c;
        return h(r107, r111, r112, r113, r109[r103][0], r109[r105][0]) / r107;
    L16:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        r102 = r100[r101 - 1];
        if (r210 >= r102) goto L4;
        r102 = r210;
        goto L4
    }

    public h(double[] r210, double[][] r211) {
        int r100 = r210.length;
        int r101 = r211[0].length;
        this.f546703d = new double[r101];
        int r102 = r100 - 1;
        double[][] r103 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r102, r101});
        double[][] r104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r101});
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L12;
        int r110 = 0;
    L5:
        if (r110 >= r102) goto L11;
        int r111 = r110 + 1;
        double r112 = r210[r111] - r210[r110];
        double[] r113 = r103[r110];
        double r114 = (r211[r111][r105] - r211[r110][r105]) / r112;
        r113[r105] = r114;
        if (r110 != 0) goto L9;
        r104[r110][r105] = r114;
    L10:
        r110 = r111;
        goto L5
    L9:
        r104[r110][r105] = (r103[r110 - 1][r105] + r114) * 0.5d;
        goto L10
    L11:
        r104[r102][r105] = r103[r100 - 2][r105];
        r105 = r105 + 1;
        goto L3
    L12:
        int r106 = 0;
    L13:
        if (r106 >= r102) goto L24;
        int r107 = 0;
    L15:
        if (r107 >= r101) goto L23;
        double r115 = r103[r106][r107];
        if (r115 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        r104[r106][r107] = 0.0d;
        r104[r106 + 1][r107] = 0.0d;
    L22:
        r107 = r107 + 1;
        goto L15
    L19:
        double r116 = r104[r106][r107] / r115;
        int r117 = r106 + 1;
        double r118 = r104[r117][r107] / r115;
        double r119 = Math.hypot(r116, r118);
        if (r119 <= 9.0d) goto L22;
        double r120 = 3.0d / r119;
        double[] r121 = r104[r106];
        double[] r122 = r103[r106];
        r121[r107] = (r116 * r120) * r122[r107];
        r104[r117][r107] = (r120 * r118) * r122[r107];
        goto L22
    L23:
        r106 = r106 + 1;
        goto L13
    L24:
        this.f546700a = r210;
        this.f546701b = r211;
        this.f546702c = r104;
    }

    @Override // tla.b
    public final void c(double r210, double[] r211) {
        double[] r100 = this.f546700a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546701b[0].length;
        double r104 = r100[0];
        if (r210 > r104) goto L8;
        f(r104, this.f546703d);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r211[r105] = this.f546701b[0][r105] + ((r210 - this.f546700a[0]) * this.f546703d[r105]);
        r105 = r105 + 1;
        goto L5
    L7:
        return;
    L8:
        int r106 = r101 - 1;
        double r107 = r100[r106];
        if (r210 < r107) goto L14;
        f(r107, this.f546703d);
    L11:
        if (r102 >= r103) goto L13;
        r211[r102] = this.f546701b[r106][r102] + ((r210 - this.f546700a[r106]) * this.f546703d[r102]);
        r102 = r102 + 1;
        goto L11
    L13:
        return;
    L14:
        int r108 = 0;
    L16:
        if (r108 >= (r101 - 1)) goto L29;
        if (r210 != this.f546700a[r108]) goto L22;
        int r109 = 0;
    L20:
        if (r109 >= r103) goto L22;
        r211[r109] = this.f546701b[r108][r109];
        r109 = r109 + 1;
    L22:
        double[] r110 = this.f546700a;
        int r111 = r108 + 1;
        double r112 = r110[r111];
        if (r210 < r112) goto L24;
        r108 = r111;
        goto L16
    L24:
        double r113 = r110[r108];
        double r114 = r112 - r113;
        double r115 = (r210 - r113) / r114;
    L25:
        if (r102 >= r103) goto L27;
        double[][] r116 = this.f546701b;
        double r117 = r116[r108][r102];
        double r118 = r116[r111][r102];
        double[][] r119 = this.f546702c;
        r211[r102] = i(r114, r115, r117, r118, r119[r108][r102], r119[r111][r102]);
        r102 = r102 + 1;
        goto L25
    L27:
        return;
    }

    @Override // tla.b
    public final void d(double r210, float[] r211) {
        double[] r100 = this.f546700a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546701b[0].length;
        double r104 = r100[0];
        if (r210 > r104) goto L8;
        f(r104, this.f546703d);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r211[r105] = (float) (this.f546701b[0][r105] + ((r210 - this.f546700a[0]) * this.f546703d[r105]));
        r105 = r105 + 1;
        goto L5
    L7:
        return;
    L8:
        int r106 = r101 - 1;
        double r107 = r100[r106];
        if (r210 < r107) goto L14;
        f(r107, this.f546703d);
    L11:
        if (r102 >= r103) goto L13;
        r211[r102] = (float) (this.f546701b[r106][r102] + ((r210 - this.f546700a[r106]) * this.f546703d[r102]));
        r102 = r102 + 1;
        goto L11
    L13:
        return;
    L14:
        int r108 = 0;
    L15:
        if (r108 >= r106) goto L28;
        if (r210 != this.f546700a[r108]) goto L21;
        int r109 = 0;
    L19:
        if (r109 >= r103) goto L21;
        r211[r109] = (float) this.f546701b[r108][r109];
        r109 = r109 + 1;
    L21:
        double[] r110 = this.f546700a;
        int r111 = r108 + 1;
        double r112 = r110[r111];
        if (r210 < r112) goto L23;
        r108 = r111;
        goto L15
    L23:
        double r113 = r110[r108];
        double r114 = r112 - r113;
        double r115 = (r210 - r113) / r114;
    L24:
        if (r102 >= r103) goto L26;
        double[][] r116 = this.f546701b;
        double r117 = r116[r108][r102];
        double r118 = r116[r111][r102];
        double[][] r119 = this.f546702c;
        r211[r102] = (float) i(r114, r115, r117, r118, r119[r108][r102], r119[r111][r102]);
        r102 = r102 + 1;
        goto L24
    L26:
        return;
    }

    @Override // tla.b
    public final void f(double r210, double[] r211) {
        double[] r100 = this.f546700a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.f546701b[0].length;
        double r104 = r100[0];
        if (r210 <= r104) goto L9;
        r104 = r100[r101 - 1];
        if (r210 >= r104) goto L9;
        r104 = r210;
    L9:
        int r105 = 0;
    L11:
        if (r105 >= (r101 - 1)) goto L18;
        double[] r106 = this.f546700a;
        int r107 = r105 + 1;
        double r108 = r106[r107];
        if (r104 <= r108) goto L14;
        r105 = r107;
        goto L11
    L14:
        double r110 = r106[r105];
        double r109 = r108 - r110;
        double r111 = (r104 - r110) / r109;
    L15:
        if (r102 >= r103) goto L22;
        double[][] r112 = this.f546701b;
        double r113 = r112[r105][r102];
        double r114 = r112[r107][r102];
        double[][] r115 = this.f546702c;
        r211[r102] = h(r109, r111, r113, r114, r115[r105][r102], r115[r107][r102]) / r109;
        r102 = r102 + 1;
        goto L15
    L22:
        return;
    }
}
