package u0;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import i0.s;
import java.io.Closeable;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f548112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f548113b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f548114c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f548115d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f548116e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PathMeasure f548117f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Path f548118g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Path f548119h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float[] f548120i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f548121j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float f548122k;

    public static class a extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        public final PathMeasure initialValue() {
            return new PathMeasure();
        }

        public a() {
        }
    }

    public static class b extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }

        public b() {
        }
    }

    public static class c extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }

        public c() {
        }
    }

    public static class d extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        public final float[] initialValue() {
            return new float[4];
        }

        public d() {
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f548112a = new a();
        f548113b = new b();
        f548114c = new c();
        f548115d = new d();
        f548116e = (float) (Math.sqrt(2.0d) / 2.0d);
        f548117f = new PathMeasure();
        f548118g = new Path();
        f548119h = new Path();
        f548120i = new float[4];
        f548121j = (float) Math.sqrt(2.0d);
        f548122k = -1.0f;
    }

    public static float d() {
        if (f548122k != (-1.0f)) goto L6;
        Resources r100 = Resources.getSystem();
        f548122k = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
    L6:
        return f548122k;
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
        if (r0.c.a.f535397a == false) goto L6;
        float[] r101 = f548115d.get();
        r101[0] = 0.0f;
        r101[1] = 0.0f;
        float r102 = f548116e;
        r101[2] = r102;
        r101[3] = r102;
        r100.mapPoints(r101);
        return (float) Math.hypot(r101[2] - r101[0], r101[3] - r101[1]);
    L6:
        float[] r103 = f548120i;
        r103[0] = 0.0f;
        r103[1] = 0.0f;
        float r104 = f548121j;
        r103[2] = r104;
        r103[3] = r104;
        r100.mapPoints(r103);
        return ((float) Math.hypot(r103[2] - r103[0], r103[3] - r103[1])) / 2.0f;
    }

    public static void b(Path r100, s r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r0.c.a.f535397a == false) goto L8;
        float r102 = r101.f487842c.l();
        float r103 = r101.f487843d.l();
        a(r100, r102 / 100.0f, r103 / 100.0f, r101.f487844e.l() / 360.0f);
        return;
    L8:
        a(r100, r101.f487842c.g().floatValue() / 100.0f, r101.f487843d.g().floatValue() / 100.0f, r101.f487844e.g().floatValue() / 360.0f);
    }

    public static void a(Path r110, float r111, float r112, float r113) {
        Set<String> r100 = com.airbnb.lottie.f.f24776a;
        if (r0.c.a.f535397a == false) goto L5;
        PathMeasure r101 = f548112a.get();
        Path r102 = f548113b.get();
        Path r103 = f548114c.get();
    L6:
        r101.setPath(r110, false);
        float r104 = r101.getLength();
        if (r111 != 1.0f) goto L13;
        if (r112 != 0.0f) goto L13;
        com.airbnb.lottie.f.a();
        return;
    L13:
        if (r104 >= 1.0f) goto L15;
    L42:
        com.airbnb.lottie.f.a();
        return;
    L15:
        if (Math.abs((r112 - r111) - 1.0f) < 0.01d) goto L42;
        float r114 = r111 * r104;
        float r115 = r112 * r104;
        float r116 = r113 * r104;
        float r105 = Math.min(r114, r115) + r116;
        float r117 = Math.max(r114, r115) + r116;
        if (r105 < r104) goto L23;
        if (r117 < r104) goto L23;
        r105 = e.c(r105, r104);
        r117 = e.c(r117, r104);
    L23:
        if (r105 >= 0.0f) goto L26;
        r105 = e.c(r105, r104);
    L26:
        if (r117 >= 0.0f) goto L29;
        r117 = e.c(r117, r104);
    L29:
        if (r105 != r117) goto L32;
        r110.reset();
        com.airbnb.lottie.f.a();
        return;
    L32:
        if (r105 < r117) goto L34;
        r105 = r105 - r104;
    L34:
        r102.reset();
        r101.getSegment(r105, r117, r102, true);
        if (r117 <= r104) goto L38;
        r103.reset();
        r101.getSegment(0.0f, r117 % r104, r103, true);
        r102.addPath(r103);
    L40:
        r110.set(r102);
        com.airbnb.lottie.f.a();
        return;
    L38:
        if (r105 >= 0.0f) goto L40;
        r103.reset();
        r101.getSegment(r105 + r104, r104, r103, true);
        r102.addPath(r103);
        goto L40
    L5:
        r101 = f548117f;
        r102 = f548118g;
        r103 = f548119h;
        goto L6
    }
}
