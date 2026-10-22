package tla;

import androidx.camera.video.AudioStats;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f546704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f546705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[] f546706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f546707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f546708e;

    public final String toString() {
        return "pos =" + Arrays.toString(this.f546705b) + " period=" + Arrays.toString(this.f546704a);
    }

    public i() {
        this.f546704a = new float[0];
        this.f546705b = new double[0];
    }

    public final double b(double r110) {
        if (r110 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r110 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r100 = Arrays.binarySearch(this.f546705b, r110);
        if (r100 >= 0) goto L11;
        r100 = (-r100) - 1;
    L11:
        float[] r101 = this.f546704a;
        float r102 = r101[r100];
        int r103 = r100 - 1;
        float r104 = r101[r103];
        double r105 = r102 - r104;
        double[] r106 = this.f546705b;
        double r107 = r106[r100];
        double r108 = r106[r103];
        double r109 = r105 / (r107 - r108);
        return (this.f546706c[r103] + ((((double) r104) - (r109 * r108)) * (r110 - r108))) + ((r109 * ((r110 * r110) - (r108 * r108))) / 2.0d);
    }

    public final void a(double r100, float r101) {
        int r102 = this.f546704a.length + 1;
        int r103 = Arrays.binarySearch(this.f546705b, r100);
        if (r103 >= 0) goto L5;
        r103 = (-r103) - 1;
    L5:
        this.f546705b = Arrays.copyOf(this.f546705b, r102);
        this.f546704a = Arrays.copyOf(this.f546704a, r102);
        this.f546706c = new double[r102];
        double[] r104 = this.f546705b;
        System.arraycopy(r104, r103, r104, r103 + 1, (r102 - r103) - 1);
        this.f546705b[r103] = r100;
        this.f546704a[r103] = r101;
    }

    public final double c(double r110, double r111) {
        double r112 = b(r110) + r111;
        switch(this.f546708e) {
            case 1: goto L18;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r113 = 1.0d - Math.abs(((r112 * 4.0d) % 4.0d) - 2.0d);
        double r114 = r113 * r113;
    L16:
        return 1.0d - r114;
    L11:
        r114 = ((r112 * 2.0d) + 1.0d) % 2.0d;
        goto L16
    L14:
        r114 = Math.abs((((r112 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
        goto L16
    L5:
        return Math.sin(r112 * 6.283185307179586d);
    L7:
        return this.f546707d.b(r112 % 1.0d);
    L10:
        return Math.cos((r111 + r112) * 6.283185307179586d);
    L13:
        return (((r112 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L18:
        return Math.signum(0.5d - (r112 % 1.0d));
    }
}
