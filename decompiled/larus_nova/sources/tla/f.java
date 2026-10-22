package tla;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f546677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f546678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f546679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f546680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f546681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<b> f546682f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f546683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f546684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double[] f546685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f546686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f546687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f546688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public tla.b f546689g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double[] f546690h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double[] f546691i;

        public a(int r210, String r211, int r212) {
            i r100 = new i();
            this.f546683a = r100;
            r100.f546708e = r210;
            if (r211 == null) goto L17;
            double[] r101 = new double[r211.length() / 2];
            int r102 = r211.indexOf(40) + 1;
            int r103 = r211.indexOf(44, r102);
            char r110 = 0;
            int r111 = 0;
        L6:
            if (r103 == (-1)) goto L8;
            r101[r111] = CastDoubleProtector.parseDouble(r211.substring(r102, r103).trim());
            r102 = r103 + 1;
            r103 = r211.indexOf(44, r102);
            r111 = r111 + 1;
            goto L6
        L8:
            r101[r111] = CastDoubleProtector.parseDouble(r211.substring(r102, r211.indexOf(41, r102)).trim());
            double[] r104 = Arrays.copyOf(r101, r111 + 1);
            int r105 = (r104.length * 3) - 2;
            int r106 = r104.length - 1;
            double r107 = 1.0d / ((double) r106);
            double[][] r108 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r105, 1});
            double[] r109 = new double[r105];
            int r112 = 0;
        L10:
            if (r112 >= r104.length) goto L16;
            double r113 = r104[r112];
            int r114 = r112 + r106;
            r108[r114][r110] = r113;
            double r115 = ((double) r112) * r107;
            r109[r114] = r115;
            if (r112 <= 0) goto L14;
            int r116 = (r106 * 2) + r112;
            long r117 = 4607182418800017408L;
            r108[r116][0] = r113 + 1.0d;
            r109[r116] = r115 + 1.0d;
            int r118 = r112 - 1;
            r108[r118][0] = (r113 - 1.0d) - r107;
            r109[r118] = (r115 - 1.0d) - r107;
        L15:
            r112 = r112 + 1;
            r110 = 0;
            goto L10
        L14:
            r117 = 4607182418800017408L;
            goto L15
        L16:
            r100.f546707d = new h(r109, r108);
        L17:
            this.f546684b = new float[r212];
            this.f546685c = new double[r212];
            this.f546686d = new float[r212];
            this.f546687e = new float[r212];
            this.f546688f = new float[r212];
            float[] r119 = new float[r212];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f546693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f546694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f546695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f546696e;

        public b(int r100, float r101, float r102, float r103, float r104) {
            this.f546692a = r100;
            this.f546693b = r104;
            this.f546694c = r102;
            this.f546695d = r101;
            this.f546696e = r103;
        }
    }

    public void c(ConstraintAttribute r100) {
    }

    public final void d() {
        int r100 = this.f546682f.size();
        if (r100 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.f546682f, new e());
        double[] r101 = new double[r100];
        char r102 = 2;
        char r103 = 0;
        double[][] r104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, 3});
        this.f546677a = new a(this.f546679c, this.f546680d, r100);
        Iterator<b> r105 = this.f546682f.iterator();
        int r106 = 0;
    L7:
        if (r105.hasNext() == false) goto L9;
        b r107 = r105.next();
        float r110 = r107.f546695d;
        r101[r106] = ((double) r110) * 0.01d;
        double[] r111 = r104[r106];
        float r112 = r107.f546693b;
        r111[r103] = r112;
        float r113 = r107.f546694c;
        r111[1] = r113;
        float r114 = r107.f546696e;
        r111[r102] = r114;
        a r108 = this.f546677a;
        r108.f546685c[r106] = ((double) r107.f546692a) / 100.0d;
        r108.f546686d[r106] = r110;
        r108.f546687e[r106] = r113;
        r108.f546688f[r106] = r114;
        r108.f546684b[r106] = r112;
        r106 = r106 + 1;
        r104 = r104;
        r102 = 2;
        r103 = 0;
        goto L7
    L9:
        double[][] r115 = r104;
        a r109 = this.f546677a;
        double[][] r116 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r109.f546685c.length, 3});
        float[] r117 = r109.f546684b;
        r109.f546690h = new double[r117.length + 2];
        r109.f546691i = new double[r117.length + 2];
        if (r109.f546685c[0] <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        r109.f546683a.a(AudioStats.AUDIO_AMPLITUDE_NONE, r109.f546686d[0]);
    L12:
        double[] r118 = r109.f546685c;
        int r119 = r118.length - 1;
        if (r118[r119] >= 1.0d) goto L15;
        r109.f546683a.a(1.0d, r109.f546686d[r119]);
    L15:
        int r120 = 0;
    L17:
        if (r120 >= r116.length) goto L19;
        double[] r121 = r116[r120];
        r121[0] = r109.f546687e[r120];
        r121[1] = r109.f546688f[r120];
        r121[2] = r109.f546684b[r120];
        r109.f546683a.a(r109.f546685c[r120], r109.f546686d[r120]);
        r120 = r120 + 1;
        goto L17
    L19:
        i r122 = r109.f546683a;
        double r123 = 0.0d;
        int r124 = 0;
    L20:
        float[] r125 = r122.f546704a;
        if (r124 >= r125.length) goto L23;
        r123 = r123 + ((double) r125[r124]);
        r124 = r124 + 1;
        goto L20
    L23:
        double r126 = 0.0d;
        int r127 = 1;
    L24:
        float[] r128 = r122.f546704a;
        if (r127 >= r128.length) goto L27;
        int r129 = r127 - 1;
        float r130 = (r128[r129] + r128[r127]) / 2.0f;
        double[] r131 = r122.f546705b;
        r126 = r126 + ((r131[r127] - r131[r129]) * ((double) r130));
        r127 = r127 + 1;
        goto L24
    L27:
        int r132 = 0;
    L28:
        float[] r133 = r122.f546704a;
        if (r132 >= r133.length) goto L31;
        r133[r132] = r133[r132] * ((float) (r123 / r126));
        r132 = r132 + 1;
        goto L28
    L31:
        r122.f546706c[0] = 0.0d;
        int r134 = 1;
    L32:
        float[] r135 = r122.f546704a;
        if (r134 >= r135.length) goto L35;
        int r136 = r134 - 1;
        float r137 = (r135[r136] + r135[r134]) / 2.0f;
        double[] r138 = r122.f546705b;
        double r139 = r138[r134] - r138[r136];
        double[] r140 = r122.f546706c;
        r140[r134] = r140[r136] + (r139 * ((double) r137));
        r134 = r134 + 1;
        goto L32
    L35:
        double[] r141 = r109.f546685c;
        if (r141.length <= 1) goto L38;
        int r142 = 0;
        r109.f546689g = tla.b.a(0, r141, r116);
    L39:
        tla.b.a(r142, r101, r115);
        return;
    L38:
        r142 = 0;
        r109.f546689g = null;
        goto L39
    }

    public final String toString() {
        String r100 = this.f546678b;
        DecimalFormat r101 = new DecimalFormat("##.##");
        Iterator<b> r102 = this.f546682f.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        b r103 = r102.next();
        r100 = r100 + "[" + r103.f546692a + " , " + r101.format(r103.f546693b) + "] ";
        goto L4
    L6:
        return r100;
    }

    public f() {
        this.f546679c = 0;
        this.f546680d = null;
        this.f546681e = 0;
        this.f546682f = new ArrayList();
    }

    public final float a(float r110) {
        a r100 = this.f546677a;
        tla.b r101 = r100.f546689g;
        if (r101 == null) goto L5;
        r101.c(r110, r100.f546690h);
    L6:
        double[] r102 = r100.f546690h;
        return (float) (r102[0] + (r100.f546683a.c(r110, r102[1]) * r100.f546690h[2]));
    L5:
        double[] r103 = r100.f546690h;
        r103[0] = r100.f546687e[0];
        r103[1] = r100.f546688f[0];
        r103[2] = r100.f546684b[0];
        goto L6
    }

    public final float b(float r210) {
        a r100 = this.f546677a;
        tla.b r101 = r100.f546689g;
        if (r101 == null) goto L5;
        double r102 = r210;
        r101.f(r102, r100.f546691i);
        r100.f546689g.c(r102, r100.f546690h);
    L6:
        double r103 = r210;
        double r110 = r100.f546683a.c(r103, r100.f546690h[1]);
        i r104 = r100.f546683a;
        double r111 = r100.f546690h[1];
        double r112 = r100.f546691i[1];
        double r113 = r111 + r104.b(r103);
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        double r105 = 0.0d;
    L16:
        double r106 = r105 + r112;
        switch(r104.f546708e) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            default: goto L18;
        };
    L18:
        double r107 = r106 * 6.283185307179586d;
        double r108 = Math.cos(r113 * 6.283185307179586d);
    L26:
        double r109 = r108 * r107;
    L27:
        double[] r114 = r100.f546691i;
        return (float) ((r114[0] + (r110 * r114[2])) + (r109 * r100.f546690h[2]));
    L19:
        r109 = r104.f546707d.e(r113 % 1.0d);
        goto L27
    L20:
        r109 = (r106 * 4.0d) * ((((r113 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
        goto L27
    L21:
        r107 = r106 * (-6.283185307179586d);
        r108 = Math.sin(r113 * 6.283185307179586d);
        goto L26
    L22:
        r109 = (-r106) * 2.0d;
        goto L27
    L23:
        r109 = r106 * 2.0d;
        goto L27
    L24:
        r107 = r106 * 4.0d;
        r108 = Math.signum((((r113 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L26
    L25:
        r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L27
    L10:
        if (r103 < 1.0d) goto L12;
        r105 = 1.0d;
        goto L16
    L12:
        int r115 = Arrays.binarySearch(r104.f546705b, r103);
        if (r115 >= 0) goto L15;
        r115 = (-r115) - 1;
    L15:
        float[] r116 = r104.f546704a;
        float r117 = r116[r115];
        int r211 = r115 - 1;
        float r118 = r116[r211];
        double[] r119 = r104.f546705b;
        double r212 = r119[r115];
        double r213 = r119[r211];
        double r120 = ((double) (r117 - r118)) / (r212 - r213);
        r105 = (r103 * r120) + (((double) r118) - (r120 * r213));
        goto L16
    L5:
        double[] r121 = r100.f546691i;
        r121[0] = 0.0d;
        r121[1] = 0.0d;
        r121[2] = 0.0d;
        goto L6
    }
}
