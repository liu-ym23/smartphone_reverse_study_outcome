package tla;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b {

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f546667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double[] f546668b;

        @Override // tla.b
        public final double e(double r100) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // tla.b
        public final double[] g() {
            return new double[]{this.f546667a};
        }

        @Override // tla.b
        public final double b(double r100) {
            return this.f546668b[0];
        }

        public a(double r100, double[] r101) {
            this.f546667a = r100;
            this.f546668b = r101;
        }

        @Override // tla.b
        public final void c(double r100, double[] r101) {
            double[] r102 = this.f546668b;
            System.arraycopy(r102, 0, r101, 0, r102.length);
        }

        @Override // tla.b
        public final void d(double r100, float[] r101) {
            int r102 = 0;
        L3:
            double[] r103 = this.f546668b;
            if (r102 >= r103.length) goto L6;
            r101[r102] = (float) r103[r102];
            r102 = r102 + 1;
            goto L3
        }

        @Override // tla.b
        public final void f(double r100, double[] r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.f546668b.length) goto L6;
            r101[r102] = 0.0d;
            r102 = r102 + 1;
            goto L4
        }
    }

    public b() {
    }

    public abstract double b(double r100);

    public abstract void c(double r100, double[] r101);

    public abstract void d(double r100, float[] r101);

    public abstract double e(double r100);

    public abstract void f(double r100, double[] r101);

    public abstract double[] g();

    public static b a(int r100, double[] r101, double[][] r102) {
        if (r101.length != 1) goto L5;
        r100 = 2;
    L5:
        if (r100 == 0) goto L12;
        if (r100 == 2) goto L10;
        return new g(r101, r102);
    L10:
        return new a(r101[0], r102[0]);
    L12:
        return new h(r101, r102);
    }
}
