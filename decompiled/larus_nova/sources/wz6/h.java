package wz6;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.Closeable;
import java.util.Set;
import nz6.r;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PathMeasure f561956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Path f561957b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f561958c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f561959d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f561960e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static float f561961f;

    static {
        f561956a = new PathMeasure();
        f561957b = new Path();
        f561958c = new Path();
        f561959d = new float[4];
        f561960e = (float) Math.sqrt(2.0d);
        f561961f = -1.0f;
    }

    public static float d() {
        if (f561961f != (-1.0f)) goto L6;
        Resources r100 = Resources.getSystem();
        f561961f = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
    L6:
        return f561961f;
    }

    public static void c(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static float e(Matrix r100) {
        float[] r101 = f561959d;
        r101[0] = 0.0f;
        r101[1] = 0.0f;
        float r102 = f561960e;
        r101[2] = r102;
        r101[3] = r102;
        r100.mapPoints(r101);
        return ((float) Math.hypot(r101[2] - r101[0], r101[3] - r101[1])) / 2.0f;
    }

    public static void b(Path r100, r r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        a(r100, r101.f521545c.e().floatValue() / 100.0f, r101.f521546d.e().floatValue() / 100.0f, r101.f521547e.e().floatValue() / 360.0f);
    }

    public static void a(Path r100, float r101, float r110, float r111) {
        Set<String> r102 = com.bytedance.lottie.c.f264422a;
        PathMeasure r103 = f561956a;
        r103.setPath(r100, false);
        float r104 = r103.getLength();
        if (r101 != 1.0f) goto L9;
        if (r110 != 0.0f) goto L9;
        com.bytedance.lottie.c.a();
        return;
    L9:
        if (r104 >= 1.0f) goto L11;
    L38:
        com.bytedance.lottie.c.a();
        return;
    L11:
        if (Math.abs((r110 - r101) - 1.0f) < 0.01d) goto L38;
        float r105 = r101 * r104;
        float r112 = r110 * r104;
        float r113 = r111 * r104;
        float r106 = Math.min(r105, r112) + r113;
        float r107 = Math.max(r105, r112) + r113;
        if (r106 < r104) goto L19;
        if (r107 < r104) goto L19;
        r106 = f.c(r106, r104);
        r107 = f.c(r107, r104);
    L19:
        if (r106 >= 0.0f) goto L22;
        r106 = f.c(r106, r104);
    L22:
        if (r107 >= 0.0f) goto L25;
        r107 = f.c(r107, r104);
    L25:
        if (r106 != r107) goto L28;
        r100.reset();
        com.bytedance.lottie.c.a();
        return;
    L28:
        if (r106 < r107) goto L30;
        r106 = r106 - r104;
    L30:
        Path r114 = f561957b;
        r114.reset();
        r103.getSegment(r106, r107, r114, true);
        if (r107 <= r104) goto L34;
        Path r108 = f561958c;
        r108.reset();
        r103.getSegment(0.0f, r107 % r104, r108, true);
        r114.addPath(r108);
    L36:
        r100.set(r114);
        com.bytedance.lottie.c.a();
        return;
    L34:
        if (r106 >= 0.0f) goto L36;
        Path r109 = f561958c;
        r109.reset();
        r103.getSegment(r106 + r104, r104, r109, true);
        r114.addPath(r109);
        goto L36
    }
}
