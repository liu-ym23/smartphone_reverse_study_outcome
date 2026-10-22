package tla;

import androidx.camera.video.AudioStats;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f546646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C7741a[] f546647b;

    /* JADX INFO: renamed from: tla.a$a, reason: collision with other inner class name */
    public static class C7741a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final double[] f546648s = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double[] f546649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f546650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f546651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f546652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f546653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f546654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final double f546655g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final double f546656h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final double f546657i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final double f546658j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final double f546659k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final double f546660l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final double f546661m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final double f546662n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f546663o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f546664p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f546665q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f546666r;

        static {
            f546648s = new double[91];
        }

        public final double a() {
            double r100 = this.f546658j * this.f546664p;
            double r101 = (-this.f546659k) * this.f546663o;
            double r102 = this.f546662n / Math.hypot(r100, r101);
            if (this.f546665q == false) goto L6;
            r100 = -r100;
        L6:
            return r100 * r102;
        }

        public final double b() {
            double r100 = this.f546658j * this.f546664p;
            double r101 = (-this.f546659k) * this.f546663o;
            double r102 = this.f546662n / Math.hypot(r100, r101);
            if (this.f546665q == false) goto L6;
            return (-r101) * r102;
        L6:
            return r101 * r102;
        }

        public final double e() {
            return this.f546660l + (this.f546658j * this.f546663o);
        }

        public final double f() {
            return this.f546661m + (this.f546659k * this.f546664p);
        }

        public final double c(double r100) {
            double r101 = (r100 - this.f546651c) * this.f546657i;
            double r102 = this.f546653e;
            return r102 + (r101 * (this.f546654f - r102));
        }

        public final double d(double r100) {
            double r101 = (r100 - this.f546651c) * this.f546657i;
            double r102 = this.f546655g;
            return r102 + (r101 * (this.f546656h - r102));
        }

        public final void g(double r100) {
            if (this.f546665q == false) goto L5;
            double r101 = this.f546652d - r100;
        L6:
            double r102 = r101 * this.f546657i;
            double r103 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            r103 = 1.0d;
            if (r102 >= 1.0d) goto L13;
            double[] r104 = this.f546649a;
            double r105 = r102 * ((double) (r104.length - 1));
            int r106 = (int) r105;
            double r107 = r104[r106];
            r103 = r107 + ((r105 - ((double) r106)) * (r104[r106 + 1] - r107));
        L13:
            double r108 = r103 * 1.5707963267948966d;
            this.f546663o = Math.sin(r108);
            this.f546664p = Math.cos(r108);
            return;
        L5:
            r101 = r100 - this.f546651c;
            goto L6
        }

        public C7741a(int r210, double r211, double r212, double r213, double r310, double r311, double r312) {
            this.f546666r = false;
            double r110 = r311 - r213;
            double r111 = r312 - r310;
            if (r210 != 1) goto L5;
            this.f546665q = true;
        L19:
            this.f546651c = r211;
            this.f546652d = r212;
            double r100 = 1.0d / (r212 - r211);
            this.f546657i = r100;
            if (3 != r210) goto L23;
            this.f546666r = true;
        L23:
            if (this.f546666r == false) goto L25;
        L67:
            this.f546666r = true;
            this.f546653e = r213;
            this.f546654f = r311;
            this.f546655g = r310;
            this.f546656h = r312;
            double r101 = Math.hypot(r111, r110);
            this.f546650b = r101;
            this.f546662n = r101 * r100;
            this.f546660l = r110 / (r212 - r211);
            this.f546661m = r111 / (r212 - r211);
            return;
        L25:
            if (Math.abs(r110) < 0.001d) goto L67;
            if (Math.abs(r111) < 0.001d) goto L67;
            this.f546649a = new double[101];
            boolean r102 = this.f546665q;
            if (r102 == false) goto L32;
            int r103 = -1;
        L33:
            this.f546658j = ((double) r103) * r110;
            if (r102 == false) goto L36;
            int r104 = 1;
        L37:
            this.f546659k = r111 * ((double) r104);
            if (r102 == false) goto L40;
            double r105 = r311;
        L41:
            this.f546660l = r105;
            if (r102 == false) goto L44;
            double r106 = r310;
        L45:
            this.f546661m = r106;
            double r107 = r310 - r312;
            double r108 = 0.0d;
            double r109 = 0.0d;
            double r112 = 0.0d;
            int r113 = 0;
        L46:
            double[] r114 = f546648s;
            if (r113 >= 91) goto L52;
            double r214 = r107;
            double r115 = Math.toRadians((((double) r113) * 90.0d) / ((double) 90));
            double r116 = Math.sin(r115) * r110;
            double r117 = Math.cos(r115) * r214;
            if (r113 <= 0) goto L51;
            r108 = r108 + Math.hypot(r116 - r109, r117 - r112);
            r114[r113] = r108;
        L51:
            r113 = r113 + 1;
            r112 = r117;
            r109 = r116;
            r107 = r214;
            goto L46
        L52:
            this.f546650b = r108;
            int r118 = 0;
        L53:
            if (r118 >= 91) goto L55;
            r114[r118] = r114[r118] / r108;
            r118 = r118 + 1;
            goto L53
        L55:
            int r119 = 0;
        L56:
            double[] r120 = this.f546649a;
            if (r119 >= r120.length) goto L65;
            double r121 = ((double) r119) / ((double) (r120.length - 1));
            int r122 = Arrays.binarySearch(r114, r121);
            if (r122 < 0) goto L61;
            this.f546649a[r119] = ((double) r122) / ((double) 90);
        L64:
            r119 = r119 + 1;
            goto L56
        L61:
            if (r122 != (-1)) goto L63;
            this.f546649a[r119] = 0.0d;
            goto L64
        L63:
            int r123 = -r122;
            int r124 = r123 - 2;
            double r125 = r114[r124];
            this.f546649a[r119] = (((double) r124) + ((r121 - r125) / (r114[r123 - 1] - r125))) / ((double) 90);
            goto L64
        L65:
            this.f546662n = this.f546650b * this.f546657i;
            return;
        L44:
            r106 = r312;
            goto L45
        L40:
            r105 = r213;
            goto L41
        L36:
            r104 = -1;
            goto L37
        L32:
            r103 = 1;
            goto L33
        L5:
            if (r210 == 4) goto L14;
            if (r210 == 5) goto L9;
            this.f546665q = false;
            goto L19
        L9:
            boolean r126 = false;
            if (r111 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
            r126 = true;
        L12:
            this.f546665q = r126;
            goto L19
        L14:
            if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
            boolean r127 = true;
        L17:
            this.f546665q = r127;
            goto L19
        L16:
            r127 = false;
            goto L17
        }
    }

    @Override // tla.b
    public final double[] g() {
        return this.f546646a;
    }

    @Override // tla.b
    public final double b(double r100) {
        C7741a[] r101 = this.f546647b;
        int r102 = 0;
        C7741a r103 = r101[0];
        double r104 = r103.f546651c;
        if (r100 >= r104) goto L11;
        double r105 = r100 - r104;
        if (r103.f546666r == false) goto L7;
        double r106 = r103.c(r104);
        double r107 = this.f546647b[0].f546660l;
    L9:
        return r106 + (r105 * r107);
    L7:
        r103.g(r104);
        r106 = this.f546647b[0].e();
        r107 = this.f546647b[0].a();
        goto L9
    L11:
        if (r100 <= r101[r101.length - 1].f546652d) goto L14;
        double r108 = r101[r101.length - 1].f546652d;
        int r109 = r101.length - 1;
        return r101[r109].c(r108) + ((r100 - r108) * this.f546647b[r109].f546660l);
    L14:
        C7741a[] r110 = this.f546647b;
        if (r102 >= r110.length) goto L25;
        C7741a r111 = r110[r102];
        if (r100 <= r111.f546652d) goto L19;
        r102 = r102 + 1;
        goto L14
    L19:
        if (r111.f546666r == true) goto L21;
        r111.g(r100);
        return this.f546647b[r102].e();
    L21:
        return r111.c(r100);
    L25:
        return Double.NaN;
    }

    @Override // tla.b
    public final double e(double r100) {
        C7741a[] r101 = this.f546647b;
        int r102 = 0;
        double r103 = r101[0].f546651c;
        if (r100 >= r103) goto L6;
        r100 = r103;
    L6:
        if (r100 <= r101[r101.length - 1].f546652d) goto L8;
        r100 = r101[r101.length - 1].f546652d;
    L8:
        C7741a[] r104 = this.f546647b;
        if (r102 >= r104.length) goto L19;
        C7741a r105 = r104[r102];
        if (r100 <= r105.f546652d) goto L13;
        r102 = r102 + 1;
        goto L8
    L13:
        if (r105.f546666r == true) goto L15;
        r105.g(r100);
        return this.f546647b[r102].a();
    L15:
        return r105.f546660l;
    L19:
        return Double.NaN;
    }

    @Override // tla.b
    public final void c(double r110, double[] r111) {
        C7741a[] r100 = this.f546647b;
        C7741a r101 = r100[0];
        double r102 = r101.f546651c;
        if (r110 >= r102) goto L10;
        double r112 = r110 - r102;
        if (r101.f546666r == false) goto L7;
        double r103 = r101.c(r102);
        C7741a r104 = this.f546647b[0];
        r111[0] = r103 + (r104.f546660l * r112);
        r111[1] = r104.d(r102) + (r112 * this.f546647b[0].f546661m);
        return;
    L7:
        r101.g(r102);
        r111[0] = this.f546647b[0].e() + (this.f546647b[0].a() * r112);
        r111[1] = this.f546647b[0].f() + (r112 * this.f546647b[0].b());
        return;
    L10:
        if (r110 <= r100[r100.length - 1].f546652d) goto L16;
        double r105 = r100[r100.length - 1].f546652d;
        double r106 = r110 - r105;
        int r107 = r100.length - 1;
        C7741a r108 = r100[r107];
        if (r108.f546666r == false) goto L14;
        double r113 = r108.c(r105);
        C7741a r109 = this.f546647b[r107];
        r111[0] = r113 + (r109.f546660l * r106);
        r111[1] = r109.d(r105) + (r106 * this.f546647b[r107].f546661m);
        return;
    L14:
        r108.g(r110);
        r111[0] = this.f546647b[r107].e() + (this.f546647b[r107].a() * r106);
        r111[1] = this.f546647b[r107].f() + (r106 * this.f546647b[r107].b());
        return;
    L16:
        int r114 = 0;
    L17:
        C7741a[] r115 = this.f546647b;
        if (r114 >= r115.length) goto L28;
        C7741a r116 = r115[r114];
        if (r110 <= r116.f546652d) goto L22;
        r114 = r114 + 1;
        goto L17
    L22:
        if (r116.f546666r == false) goto L25;
        r111[0] = r116.c(r110);
        r111[1] = this.f546647b[r114].d(r110);
        return;
    L25:
        r116.g(r110);
        r111[0] = this.f546647b[r114].e();
        r111[1] = this.f546647b[r114].f();
        return;
    }

    @Override // tla.b
    public final void d(double r110, float[] r111) {
        C7741a[] r100 = this.f546647b;
        C7741a r101 = r100[0];
        double r102 = r101.f546651c;
        if (r110 >= r102) goto L10;
        double r112 = r110 - r102;
        if (r101.f546666r == false) goto L7;
        double r103 = r101.c(r102);
        C7741a r104 = this.f546647b[0];
        r111[0] = (float) (r103 + (r104.f546660l * r112));
        r111[1] = (float) (r104.d(r102) + (r112 * this.f546647b[0].f546661m));
        return;
    L7:
        r101.g(r102);
        r111[0] = (float) (this.f546647b[0].e() + (this.f546647b[0].a() * r112));
        r111[1] = (float) (this.f546647b[0].f() + (r112 * this.f546647b[0].b()));
        return;
    L10:
        if (r110 <= r100[r100.length - 1].f546652d) goto L16;
        double r105 = r100[r100.length - 1].f546652d;
        double r106 = r110 - r105;
        int r107 = r100.length - 1;
        C7741a r108 = r100[r107];
        if (r108.f546666r == false) goto L14;
        double r113 = r108.c(r105);
        C7741a r109 = this.f546647b[r107];
        r111[0] = (float) (r113 + (r109.f546660l * r106));
        r111[1] = (float) (r109.d(r105) + (r106 * this.f546647b[r107].f546661m));
        return;
    L14:
        r108.g(r110);
        r111[0] = (float) this.f546647b[r107].e();
        r111[1] = (float) this.f546647b[r107].f();
        return;
    L16:
        int r114 = 0;
    L17:
        C7741a[] r115 = this.f546647b;
        if (r114 >= r115.length) goto L28;
        C7741a r116 = r115[r114];
        if (r110 <= r116.f546652d) goto L22;
        r114 = r114 + 1;
        goto L17
    L22:
        if (r116.f546666r == false) goto L25;
        r111[0] = (float) r116.c(r110);
        r111[1] = (float) this.f546647b[r114].d(r110);
        return;
    L25:
        r116.g(r110);
        r111[0] = (float) this.f546647b[r114].e();
        r111[1] = (float) this.f546647b[r114].f();
        return;
    }

    @Override // tla.b
    public final void f(double r100, double[] r110) {
        C7741a[] r101 = this.f546647b;
        double r102 = r101[0].f546651c;
        if (r100 >= r102) goto L6;
        r100 = r102;
    L8:
        int r103 = 0;
    L9:
        C7741a[] r104 = this.f546647b;
        if (r103 >= r104.length) goto L20;
        C7741a r105 = r104[r103];
        if (r100 <= r105.f546652d) goto L14;
        r103 = r103 + 1;
        goto L9
    L14:
        if (r105.f546666r == false) goto L17;
        r110[0] = r105.f546660l;
        r110[1] = r105.f546661m;
        return;
    L17:
        r105.g(r100);
        r110[0] = this.f546647b[r103].a();
        r110[1] = this.f546647b[r103].b();
        return;
    L20:
        return;
    L6:
        if (r100 <= r101[r101.length - 1].f546652d) goto L8;
        r100 = r101[r101.length - 1].f546652d;
        goto L8
    }

    public a(int[] r210, double[] r211, double[][] r212) {
        this.f546646a = r211;
        this.f546647b = new C7741a[r211.length - 1];
        int r100 = 0;
        int r101 = 1;
        int r102 = 1;
    L3:
        C7741a[] r103 = this.f546647b;
        if (r100 >= r103.length) goto L26;
        int r104 = r210[r100];
        if (r104 == 0) goto L24;
        if (r104 != 1) goto L9;
        r101 = 1;
        r102 = 1;
    L25:
        double r110 = r211[r100];
        int r213 = r100 + 1;
        double r111 = r211[r213];
        double[] r105 = r212[r100];
        double r112 = r105[0];
        double r113 = r105[1];
        double[] r106 = r212[r213];
        int r107 = r102;
        r103[r100] = new C7741a(r107, r110, r111, r112, r113, r106[0], r106[1]);
        r100 = r213;
        goto L3
    L9:
        if (r104 == 2) goto L22;
        if (r104 != 3) goto L12;
        if (r101 != 1) goto L20;
        r101 = 2;
    L21:
        r102 = r101;
        goto L25
    L20:
        r101 = 1;
        goto L21
    L12:
        if (r104 != 4) goto L14;
        r102 = 4;
        goto L25
    L14:
        if (r104 != 5) goto L25;
        r102 = 5;
        goto L25
    L22:
        r101 = 2;
        r102 = 2;
        goto L25
    L24:
        r102 = 3;
        goto L25
    }
}
