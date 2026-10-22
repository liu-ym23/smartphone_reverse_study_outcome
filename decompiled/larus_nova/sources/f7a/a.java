package f7a;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f475778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C5866a f475779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C5866a f475780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f475781d;

    /* JADX INFO: renamed from: f7a.a$a, reason: collision with other inner class name */
    public static class C5866a {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final float f475782q = 0.0f;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final float[] f475783r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final float[] f475784s = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f475785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f475786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f475787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f475788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f475789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f475790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f475791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f475792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f475793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f475794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f475795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f475796l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f475797m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f475798n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f475799o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f475800p;

        public final boolean b() {
            int r100 = this.f475799o;
            if (r100 == 0) goto L10;
            if (r100 != 1) goto L6;
            return false;
        L6:
            if (r100 != 2) goto L17;
            this.f475792h += (long) this.f475793i;
            e(this.f475788d, this.f475785a);
        L17:
            update();
            return true;
        L10:
            int r101 = this.f475793i;
            if (r101 >= this.f475794j) goto L19;
            this.f475787c = this.f475786b;
            int r102 = this.f475788d;
            this.f475785a = r102;
            this.f475786b = r102;
            int r103 = (int) this.f475790f;
            this.f475789e = r103;
            if (r103 <= 0) goto L15;
            float r104 = -2000.0f;
        L16:
            this.f475791g = r104;
            this.f475792h += (long) r101;
            d();
            goto L17
        L15:
            r104 = 2000.0f;
            goto L16
        L19:
            return false;
        }

        public final void d() {
            int r100 = this.f475789e;
            float r101 = r100 * r100;
            float r102 = r101 / (Math.abs(this.f475791g) * 2.0f);
            float r103 = Math.signum(this.f475789e);
            int r104 = this.f475797m;
            if (r102 <= r104) goto L5;
            this.f475791g = ((-r103) * r101) / (r104 * 2.0f);
            r102 = r104;
        L5:
            this.f475797m = (int) r102;
            this.f475799o = 2;
            int r105 = this.f475785a;
            int r106 = this.f475789e;
            if (r106 > 0) goto L9;
            r102 = -r102;
        L9:
            this.f475788d = r105 + ((int) r102);
            this.f475793i = -((int) ((r106 * 1000.0f) / this.f475791g));
        }

        public boolean update() {
            long r100 = AnimationUtils.currentAnimationTimeMillis() - this.f475792h;
            if (r100 == 0) goto L5;
            int r101 = this.f475793i;
            if (r100 <= r101) goto L11;
            return false;
        L11:
            int r102 = this.f475799o;
            if (r102 != 0) goto L14;
            int r103 = this.f475794j;
            float r104 = r100 / r103;
            int r105 = (int) (r104 * 100.0f);
            if (r105 >= 0) goto L25;
        L23:
            double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L29:
            this.f475787c = this.f475786b;
            this.f475786b = this.f475785a + ((int) Math.round(r106));
            return true;
        L25:
            if (r105 >= 100) goto L27;
            float r107 = r105 / 100.0f;
            int r108 = r105 + 1;
            float[] r109 = f475783r;
            float r110 = r109[r105];
            float r111 = (r109[r108] - r110) / ((r108 / 100.0f) - r107);
            float r112 = r110 + ((r104 - r107) * r111);
        L28:
            int r113 = this.f475795k;
            double r114 = r112 * r113;
            this.f475790f = ((r111 * r113) / r103) * 1000.0f;
        L20:
            r106 = r114;
            goto L29
        L27:
            r112 = 1.0f;
            r111 = 0.0f;
            goto L28
        L14:
            if (r102 != 1) goto L16;
            float r115 = r100 / r101;
            float r116 = r115 * r115;
            float r117 = Math.signum(this.f475789e);
            int r118 = this.f475797m;
            r114 = (r118 * r117) * ((3.0f * r116) - ((2.0f * r115) * r116));
            this.f475790f = ((r117 * r118) * 6.0f) * ((-r115) + r116);
            goto L20
        L16:
            if (r102 != 2) goto L23;
            float r119 = r100 / 1000.0f;
            int r120 = this.f475789e;
            float r121 = this.f475791g;
            this.f475790f = r120 + (r121 * r119);
            r106 = (r120 * r119) + (((r121 * r119) * r119) / 2.0f);
            goto L29
        L5:
            if (this.f475793i <= 0) goto L31;
            return true;
        L31:
            return false;
        }

        static {
            f475782q = (float) (Math.log(0.78d) / Math.log(0.9d));
            f475783r = new float[101];
            f475784s = new float[101];
            float r100 = 0.0f;
            float r101 = 0.0f;
            int r102 = 0;
        L4:
            if (r102 >= 100) goto L21;
            float r103 = r102 / 100.0f;
            float r104 = 1.0f;
        L6:
            float r105 = 2.0f;
            float r106 = ((r104 - r100) / 2.0f) + r100;
            float r107 = 3.0f;
            float r110 = 1.0f - r106;
            float r108 = (r106 * 3.0f) * r110;
            float r111 = (r106 * r106) * r106;
            float r112 = (((r110 * 0.175f) + (r106 * 0.35000002f)) * r108) + r111;
            if (Math.abs(r112 - r103) < 1.0E-5d) goto L8;
            if (r112 > r103) goto L19;
            r100 = r106;
            goto L6
        L19:
            r104 = r106;
            goto L6
        L8:
            f475783r[r102] = (r108 * ((r110 * 0.5f) + r106)) + r111;
            float r109 = 1.0f;
        L9:
            float r113 = ((r109 - r101) / r105) + r101;
            float r114 = 1.0f - r113;
            float r115 = (r113 * r107) * r114;
            float r116 = (r113 * r113) * r113;
            float r117 = (((r114 * 0.5f) + r113) * r115) + r116;
            if (Math.abs(r117 - r103) < 1.0E-5d) goto L11;
            if (r117 <= r103) goto L15;
            r109 = r113;
        L16:
            r105 = 2.0f;
            r107 = 3.0f;
            goto L9
        L15:
            r101 = r113;
            goto L16
        L11:
            f475784s[r102] = (r115 * ((r114 * 0.175f) + (r113 * 0.35000002f))) + r116;
            r102 = r102 + 1;
            goto L4
        L21:
            float[] r118 = f475783r;
            f475784s[100] = 1.0f;
            r118[100] = 1.0f;
        }

        public C5866a(Context r100) {
            this.f475798n = ViewConfiguration.getScrollFriction();
            this.f475799o = 0;
            this.f475796l = true;
            Resources r101 = r100.getResources();
            this.f475800p = ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 160.0f) * 386.0878f) * 0.84f;
        }

        public final void e(int r100, int r101) {
            this.f475796l = false;
            this.f475799o = 1;
            this.f475787c = this.f475786b;
            this.f475785a = r100;
            this.f475786b = r100;
            this.f475788d = r101;
            int r102 = r100 - r101;
            if (r102 <= 0) goto L5;
            float r103 = -2000.0f;
        L6:
            this.f475791g = r103;
            this.f475789e = -r102;
            this.f475797m = Math.abs(r102);
            this.f475793i = (int) (Math.sqrt((((double) r102) * (-2.0d)) / ((double) this.f475791g)) * 1000.0d);
            return;
        L5:
            r103 = 2000.0f;
            goto L6
        }

        public final void a(int r100, int r101, int r102) {
            float r103 = Math.abs((r102 - r100) / (r101 - r100));
            int r104 = (int) (r103 * 100.0f);
            if (r104 >= 100) goto L6;
            float r105 = r104 / 100.0f;
            int r106 = r104 + 1;
            float[] r107 = f475784s;
            float r108 = r107[r104];
            this.f475793i = (int) (this.f475793i * (r108 + (((r103 - r105) / ((r106 / 100.0f) - r105)) * (r107[r106] - r108))));
            return;
        }

        public final void c(int r110, int r210, int r211, int r212, int r213, int r214) {
            this.f475797m = r213;
            boolean r100 = false;
            this.f475796l = false;
            this.f475789e = r210;
            float r101 = r210;
            this.f475790f = r101;
            this.f475794j = 0;
            this.f475793i = 0;
            this.f475792h = AnimationUtils.currentAnimationTimeMillis();
            this.f475785a = r110;
            this.f475787c = r110;
            this.f475786b = r110;
            if (r110 > r212) goto L23;
            if (r110 < r211) goto L23;
            this.f475799o = 0;
            if (r210 == 0) goto L9;
            double r102 = Math.log((Math.abs(r210) * 0.35f) / (this.f475798n * this.f475800p));
            float r103 = f475782q;
            int r104 = (int) (Math.exp(r102 / (((double) r103) - 1.0d)) * 1000.0d);
            this.f475794j = r104;
            this.f475793i = r104;
            double r111 = r103;
            double r112 = ((double) (this.f475798n * this.f475800p)) * Math.exp((r111 / (r111 - 1.0d)) * Math.log((Math.abs(r210) * 0.35f) / (this.f475798n * this.f475800p)));
        L10:
            if (r210 != 0) goto L12;
        L14:
            this.f475795k = (int) (r112 * ((double) Math.signum(r101)));
        L15:
            int r105 = r110 + this.f475795k;
            this.f475788d = r105;
            if (r105 >= r211) goto L18;
            a(this.f475785a, r105, r211);
            this.f475788d = r211;
        L18:
            int r106 = this.f475788d;
            if (r106 <= r212) goto L54;
            a(this.f475785a, r106, r212);
            this.f475788d = r212;
            return;
        L54:
            return;
        L12:
            if (r214 >= r112) goto L14;
            float r107 = r214;
            double r108 = f475782q;
            double r113 = r108 - 1.0d;
            int r109 = (int) (((double) (((float) (Math.exp((Math.log(r107 / (this.f475798n * this.f475800p)) / (r108 / r113)) / r113) * 1000.0d)) + ((float) (((((double) this.f475793i) * 1.0d) * ((double) r107)) / ((double) ((float) r112)))))) / 2.0d);
            this.f475794j = r109;
            this.f475793i = r109;
            this.f475795k = (int) (r107 * Math.signum(r101));
            goto L15
        L9:
            r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L23:
            if (r110 <= r211) goto L26;
            if (r110 >= r212) goto L26;
            this.f475796l = true;
            return;
        L26:
            if (r110 <= r212) goto L28;
            boolean r114 = true;
        L29:
            if (r114 == false) goto L31;
            int r115 = r212;
        L32:
            int r116 = r110 - r115;
            if ((r116 * r210) < 0) goto L35;
            r100 = true;
        L35:
            if (r100 == false) goto L43;
            if (r210 == 0) goto L39;
            r116 = r210;
        L39:
            if (r116 <= 0) goto L41;
            float r117 = -2000.0f;
        L42:
            this.f475791g = r117;
            float r118 = (-r210) / r117;
            float r119 = (float) Math.sqrt((((double) ((((r101 * r101) / 2.0f) / Math.abs(r117)) + Math.abs(r115 - r110))) * 2.0d) / ((double) Math.abs(this.f475791g)));
            this.f475792h -= (long) ((int) ((r119 - r118) * 1000.0f));
            this.f475787c = this.f475786b;
            this.f475785a = r115;
            this.f475786b = r115;
            this.f475789e = (int) ((-this.f475791g) * r119);
            d();
            return;
        L41:
            r117 = 2000.0f;
            goto L42
        L43:
            double r120 = Math.log((Math.abs(r210) * 0.35f) / (this.f475798n * this.f475800p));
            double r121 = f475782q;
            if ((((double) (this.f475798n * this.f475800p)) * Math.exp((r121 / (r121 - 1.0d)) * r120)) <= Math.abs(r116)) goto L52;
            if (r114 == false) goto L47;
            int r122 = r211;
        L48:
            if (r114 == false) goto L50;
            int r123 = r110;
        L51:
            c(r110, r210, r122, r123, this.f475797m, Integer.MAX_VALUE);
            return;
        L50:
            r123 = r212;
            goto L51
        L47:
            r122 = r110;
            goto L48
        L52:
            e(r110, r115);
            return;
        L31:
            r115 = r211;
            goto L32
        L28:
            r114 = false;
            goto L29
        }
    }

    public final void a() {
        C5866a r100 = this.f475779b;
        r100.f475786b = r100.f475788d;
        r100.f475796l = true;
        C5866a r101 = this.f475780c;
        r101.f475786b = r101.f475788d;
        r101.f475796l = true;
    }

    public final boolean d() {
        if (this.f475779b.f475796l == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f475780c.f475796l == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (d() == false) goto L6;
        return false;
    L6:
        int r100 = this.f475778a;
        if (r100 == 0) goto L24;
        if (r100 != 1) goto L28;
        C5866a r101 = this.f475779b;
        if (r101.f475796l == false) goto L13;
    L17:
        C5866a r102 = this.f475780c;
        if (r102.f475796l == true) goto L28;
        if (r102.update() == true) goto L28;
        if (this.f475780c.b() == true) goto L28;
        C5866a r103 = this.f475780c;
        r103.f475786b = r103.f475788d;
        r103.f475796l = true;
        goto L28
    L13:
        if (r101.update() == true) goto L17;
        if (this.f475779b.b() == true) goto L17;
        C5866a r104 = this.f475779b;
        r104.f475786b = r104.f475788d;
        r104.f475796l = true;
    L28:
        return true;
    L24:
        long r105 = AnimationUtils.currentAnimationTimeMillis();
        C5866a r106 = this.f475779b;
        long r107 = r105 - r106.f475792h;
        int r108 = r106.f475793i;
        if (r107 >= r108) goto L27;
        float r109 = this.f475781d.getInterpolation(r107 / r108);
        C5866a r110 = this.f475779b;
        r110.f475787c = r110.f475786b;
        int r111 = r110.f475785a;
        r110.f475786b = r111 + Math.round((r110.f475788d - r111) * r109);
        C5866a r112 = this.f475780c;
        r112.f475787c = r112.f475786b;
        int r113 = r112.f475785a;
        r112.f475786b = r113 + Math.round(r109 * (r112.f475788d - r113));
        goto L28
    L27:
        a();
        goto L28
    }

    public a(Context r100, Interpolator r101) {
        this.f475781d = r101;
        this.f475779b = new C5866a(r100);
        this.f475780c = new C5866a(r100);
    }

    public final void c(int r110, int r111, int r112, int r113, int r114, int r210, int r211, int r212, int r213, int r214) {
        if (d() == true) goto L9;
        float r100 = this.f475779b.f475790f;
        float r101 = this.f475780c.f475790f;
        int r102 = r112;
        float r103 = r102;
        if (Math.signum(r103) != Math.signum(r100)) goto L10;
        int r104 = r113;
        float r105 = r104;
        if (Math.signum(r105) != Math.signum(r101)) goto L11;
        r102 = (int) (r103 + r100);
        int r106 = (int) (r105 + r101);
    L12:
        this.f475778a = 1;
        C5866a r107 = this.f475779b;
        if (r102 < 0.0f) goto L15;
        int r108 = r213;
    L16:
        r107.c(r110, r102, r114, r210, 0, r108);
        C5866a r109 = this.f475780c;
        if (r106 < 0.0f) goto L19;
        int r115 = r213;
    L20:
        r109.c(r111, r106, r211, r212, 0, r115);
        return;
    L19:
        r115 = r214;
        goto L20
    L15:
        r108 = r214;
    L11:
        r106 = r104;
    L10:
        r104 = r113;
        goto L11
    L9:
        r102 = r112;
        goto L10
    }
}
