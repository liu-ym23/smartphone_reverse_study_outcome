package i7a;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import androidx.core.graphics.PathParser;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Matrix f488486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double f488487j = 0.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f488488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f488489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f488490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f488491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C6236a[] f488492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double[] f488493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BorderRadius f488494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f488495h;

    /* JADX INFO: renamed from: i7a.a$a, reason: collision with other inner class name */
    public static class C6236a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f488496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f488497b;

        public C6236a(double r100, int r101) {
            this.f488496a = r100;
            this.f488497b = r101;
        }
    }

    static {
        f488487j = Math.sqrt(2.0d);
    }

    public a(int r100) {
        this.f488488a = null;
        this.f488492e = null;
        this.f488493f = null;
        this.f488494g = null;
        this.f488495h = 0;
        this.f488489b = r100;
    }

    public a(String r100, float r101) {
        this.f488488a = null;
        this.f488492e = null;
        this.f488493f = null;
        this.f488494g = null;
        this.f488495h = 0;
        this.f488489b = 3;
        this.f488488a = PathParser.createPathFromPathData(r100);     // Catch: RuntimeException -> L5
    L7:
        if (this.f488488a != null) goto L11;
        LLog.e("LynxBasicShape", "Invalid path data string: " + r100);
        return;
    L11:
        if (f488486i != null) goto L13;
        f488486i = new Matrix();
    L13:
        f488486i.setScale(r101, r101);
        this.f488488a.transform(f488486i);
        return;
    L5:
        LLog.e("LynxBasicShape", "Create path from data string failed. Check the path string. \n" + r100);
        goto L7
    }

    public static a a(ReadableArray r110, float r111) {
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r110.size() <= 1) goto L61;
        int r100 = r110.size();
        int r101 = 0;
        long r102 = r110.getLong(0);
        if (r102 != 3) goto L12;
        if (r100 == 2) goto L55;
        return null;
    L55:
        return new a(r110.getString(1), r111);
    L12:
        int r112 = 11;
        int r113 = 4;
        if (r102 != 4) goto L18;
        if (r100 == 11) goto L16;
        return null;
    L16:
        a r103 = new a(4);
        C6236a[] r104 = new C6236a[4];
        r103.f488492e = r104;
        r104[0] = new C6236a(r110.getDouble(1), r110.getInt(2));
        r103.f488492e[1] = new C6236a(r110.getDouble(3), r110.getInt(4));
        r103.f488492e[2] = new C6236a(r110.getDouble(7), r110.getInt(8));
        r103.f488492e[3] = new C6236a(r110.getDouble(9), r110.getInt(10));
        r103.f488493f = new double[]{r110.getDouble(5), 0.0d};
        r103.f488493f[1] = r110.getDouble(6);
        return r103;
    L18:
        if (r102 != 1) goto L23;
        if (r100 == 7) goto L21;
        return null;
    L21:
        a r105 = new a(1);
        C6236a[] r106 = new C6236a[3];
        r105.f488492e = r106;
        r106[0] = new C6236a(r110.getDouble(1), r110.getInt(2));
        r105.f488492e[1] = new C6236a(r110.getDouble(3), r110.getInt(4));
        r105.f488492e[2] = new C6236a(r110.getDouble(5), r110.getInt(6));
        return r105;
    L23:
        if (r102 != 2) goto L28;
        if (r100 == 9) goto L26;
        return null;
    L26:
        a r107 = new a(2);
        C6236a[] r108 = new C6236a[4];
        r107.f488492e = r108;
        r108[0] = new C6236a(r110.getDouble(1), r110.getInt(2));
        r107.f488492e[1] = new C6236a(r110.getDouble(3), r110.getInt(4));
        r107.f488492e[2] = new C6236a(r110.getDouble(5), r110.getInt(6));
        r107.f488492e[3] = new C6236a(r110.getDouble(7), r110.getInt(8));
        return r107;
    L28:
        if (r102 != 5) goto L59;
        a r109 = new a(5);
        r109.f488492e = new C6236a[4];
        if (r110.size() != 9) goto L33;
        r109.f488495h = 1;
    L38:
        int r114 = 0;
    L39:
        if (r114 >= r113) goto L41;
        int r115 = r114 * 2;
        r109.f488492e[r114] = new C6236a(r110.getDouble(r115 + 1), r110.getInt(r115 + 2));
        r114 = r114 + 1;
        r113 = 4;
        goto L39
    L41:
        int r116 = r109.f488495h;
        if (r116 == 2) goto L46;
        if (r116 != 3) goto L51;
        r109.f488493f = new double[]{r110.getDouble(9), 0.0d};
        r109.f488493f[1] = r110.getDouble(10);
    L47:
        r109.f488494g = new BorderRadius();
    L48:
        if (r101 >= 4) goto L51;
        r109.f488494g.c(r101, BorderRadius.a.a(r110, (r101 * 4) + r112));
        r101 = r101 + 1;
    L51:
        return r109;
    L46:
        r112 = 9;
        goto L47
    L33:
        if (r110.size() != 25) goto L36;
        r109.f488495h = 2;
        goto L38
    L36:
        if (r110.size() != 27) goto L60;
        r109.f488495h = 3;
        goto L38
    L60:
        return null;
    L59:
        return null;
    L61:
        return null;
    }

    public static double d(C6236a r100, double r101) {
        if (r100 != null) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r100.f488497b != 1) goto L9;
        return r100.f488496a * r101;
    L9:
        return r100.f488496a;
    }

    public final Path c(int r210, int r211) {
        int r100 = this.f488489b;
        if (r100 == 3) goto L5;
        if (r100 != 0) goto L10;
        return null;
    L10:
        if (r210 == this.f488490c) goto L12;
    L16:
        this.f488490c = r210;
        this.f488491d = r211;
        Path r101 = this.f488488a;
        if (r101 != null) goto L19;
        this.f488488a = new Path();
    L20:
        int r102 = this.f488489b;
        int r103 = 1;
        if (r102 != 1) goto L23;
        C6236a[] r104 = this.f488492e;
        if (r104 != null) goto L86;
    L90:
        return this.f488488a;
    L86:
        if (r104.length != 3) goto L90;
        float r105 = (float) d(r104[0], Math.sqrt((r210 * r210) + (r211 * r211)) / f488487j);
        this.f488488a.addCircle((float) d(this.f488492e[1], r210), (float) d(this.f488492e[2], r211), r105, Path.Direction.CW);
        goto L90
    L23:
        if (r102 == 2) goto L72;
        if (r102 != 4) goto L26;
        C6236a[] r106 = this.f488492e;
        if (r106 == null) goto L90;
        if (r106.length != 4) goto L90;
        double[] r107 = this.f488493f;
        if (r107 == null) goto L90;
        if (r107.length != 2) goto L90;
        double r110 = r210;
        float r108 = (float) d(r106[0], r110);
        float r109 = (float) d(this.f488492e[1], r110);
        float r111 = (float) d(this.f488492e[2], r110);
        float r112 = (float) d(this.f488492e[3], r211);
        double[] r113 = this.f488493f;
        float r114 = (float) r113[0];
        float r115 = (float) r113[1];
        if (r108 != 0.0f) goto L69;
        if (r109 == 0.0f) goto L90;
    L69:
        if (r103 > 4) goto L71;
        b(this.f488488a, r108, r109, r111, r112, r114, r115, r103);
        r103 = r103 + 1;
        goto L69
    L71:
        this.f488488a.close();
        goto L90
    L26:
        if (r102 != 5) goto L90;
        C6236a[] r116 = this.f488492e;
        if (r116 == null) goto L90;
        if (r116.length != 4) goto L90;
        double r117 = r211;
        double r118 = d(r116[0], r117);
        double r119 = r210;
        double r120 = d(this.f488492e[1], r119);
        double r121 = d(this.f488492e[2], r117);
        double r122 = d(this.f488492e[3], r119);
        double r212 = r118 + r121;
        double r213 = r122 + r120;
        if (r212 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L39;
        if (r212 <= r117) goto L39;
        double r214 = r117 / r212;
        r118 = r118 * r214;
        r121 = r121 * r214;
    L39:
        if (r213 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
    L43:
        RectF r123 = new RectF((float) r122, (float) r118, (float) (r119 - r120), (float) (r117 - r121));
        int r124 = this.f488495h;
        if (r124 == 1) goto L53;
        if (r124 == 2) goto L52;
        if (r124 != 3) goto L90;
        this.f488494g.d(r123.width(), r123.height());
        float[] r125 = this.f488494g.a();
        if (r125.length < 8) goto L90;
        float r126 = r125[4];
        float r127 = r125[5];
        float r128 = r123.right - r126;
        float r129 = r123.bottom - r127;
        double[] r130 = this.f488493f;
        float r131 = (float) r130[0];
        float r132 = (float) r130[1];
        b(this.f488488a, r126, r127, r128, r129, r131, r132, 1);
        float r133 = r125[6];
        float r134 = r125[7];
        b(this.f488488a, r133, r134, r123.left + r133, r123.bottom - r134, r131, r132, 2);
        float r135 = r125[0];
        float r136 = r125[1];
        b(this.f488488a, r135, r136, r123.left + r135, r123.top + r136, r131, r132, 3);
        float r137 = r125[2];
        float r138 = r125[3];
        b(this.f488488a, r137, r138, r123.right - r137, r123.top + r138, r131, r132, 4);
        this.f488488a.close();
        goto L90
    L52:
        this.f488494g.d(r123.width(), r123.height());
        this.f488488a.addRoundRect(r123, this.f488494g.a(), Path.Direction.CW);
        goto L90
    L53:
        this.f488488a.addRect(r123, Path.Direction.CW);
        goto L90
    L41:
        if (r213 <= r119) goto L43;
        double r215 = r119 / r213;
        r122 = r122 * r215;
        r120 = r120 * r215;
        goto L43
    L72:
        C6236a[] r139 = this.f488492e;
        if (r139 == null) goto L90;
        if (r139.length != 4) goto L90;
        double r140 = r210;
        float r141 = (float) d(r139[0], r140);
        float r142 = (float) d(this.f488492e[1], r140);
        float r143 = (float) d(this.f488492e[2], r140);
        float r144 = (float) d(this.f488492e[3], r211);
        if (r141 == 0.0f) goto L80;
    L82:
        this.f488488a.addOval(r143 - r141, r144 - r142, r143 + r141, r144 + r142, Path.Direction.CW);
        goto L90
    L80:
        if (r142 != 0.0f) goto L82;
    L19:
        r101.reset();
        goto L20
    L12:
        if (r211 != this.f488491d) goto L16;
        Path r145 = this.f488488a;
        if (r145 == null) goto L16;
        return r145;
    L5:
        return this.f488488a;
    }

    public static void b(Path r110, float r111, float r112, float r113, float r210, float r211, float r212, int r213) {
        int r100 = r213;
        float r101 = -1.0f;
        if (r100 != 1) goto L5;
    L8:
        float r102 = 1.0f;
    L9:
        if (r100 != 1) goto L11;
    L12:
        r101 = 1.0f;
    L13:
        double r103 = 1.5707963267948966d;
        float r104 = (float) (((double) (r100 - 1)) * 1.5707963267948966d);
    L14:
        double r105 = r104;
        if (r105 >= (((double) r100) * r103)) goto L21;
        double r114 = ((double) r102) * Math.cos(r105);
        double r115 = ((double) r101) * Math.sin(r105);
        double r116 = (((double) (r102 * r111)) * Math.pow(r114, 2.0f / r211)) + ((double) r113);
        float r106 = r101;
        double r117 = ((r101 * r112) * Math.pow(r115, 2.0f / r212)) + ((double) r210);
        if (r104 != 0.0f) goto L19;
        r110.moveTo((float) r116, (float) r117);
    L20:
        r104 = (float) (r105 + 0.01d);
        r100 = r213;
        r101 = r106;
        r103 = 1.5707963267948966d;
        goto L14
    L19:
        r110.lineTo((float) r116, (float) r117);
        goto L20
    L21:
        return;
    L11:
        if (r100 != 2) goto L13;
    L5:
        if (r100 == 4) goto L8;
        r102 = -1.0f;
        goto L9
    }
}
