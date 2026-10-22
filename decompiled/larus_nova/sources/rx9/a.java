package rx9;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f539833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f539834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f539835c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f539836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f539837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f539838f;

    static {
        f539833a = new AtomicBoolean(false);
        f539835c = 3600000;
        f539836d = -1;
        f539838f = true;
    }

    public static void a() {
        f539836d = SystemClock.elapsedRealtime();
        if ((SystemClock.elapsedRealtime() - f539836d) <= f539835c) goto L8;
        Lazy r100 = q.f539873a;
        b r101 = f539837e;
        if (r101 == null) goto L8;
        q.a(new m(r101));
    L8:
        f539838f = true;
        if (f539833a.get() == true) goto L11;
        return;
    L11:
        b r102 = f539837e;
        if (r102 != null) goto L14;
        return;
    L14:
        long r103 = r102.f539839a;
        long r104 = r102.f539840b;
        if (100 <= r104) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == true) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == true) goto L27;
        return;
    L27:
        final g r107 = new g(r102);
        if (r107.f539848c.compareAndSet(0, 1) == false) goto L30;
        g.a.a(0, new c(r107));
    L30:
        f539834b = r107;
        return;
    L22:
        if (r102.f539841c < 1.0f) goto L24;
        r106 = true;
        goto L25
    L17:
        if (r104 > r103) goto L19;
        r105 = true;
        goto L20
    }
}
