package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f67a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f68b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f69c;
    private static Object d;

    public a(Context r4) {
        b();
    L20:
        e = move-exception;
        LogUtil.error("CHRYBoostFramework", "CHRYBoostFramework() : Exception_2 = " + e);
        return;
    L4:
        if (f68b == null) goto L25;
        int r5 = Build.VERSION.SDK_INT;     // Catch: Exception -> L20
        if (r5 != 29) goto L12;
        d = android.ss.com.vboost.utils.b.a(f68b, "getInstance", new Class[0]).invoke(f68b, new Object[0]);     // Catch: Exception -> L20
        android.ss.com.vboost.utils.b.a(f68b, "init", new Class[0]).invoke(d, new Object[0]);     // Catch: Exception -> L20
    L18:
        f67a = true;     // Catch: Exception -> L20
        return;
    L12:
        if (r5 != 28) goto L14;
    L17:
        d = android.ss.com.vboost.utils.b.a(f68b, "getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L20
        goto L18
    L14:
        if (r5 == 27) goto L17;
        if (r5 == 26) goto L17;
        return;
    }

    private void b() {
        monitor-enter(a.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (f67a == false) goto L30;
    L22:
        monitor-exit(a.class);     // Catch: Throwable -> L24
        return;
    L30:
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L19 Throwable -> L24
        if (r2 != 29) goto L10;
        Class<?> r3 = android.ss.com.vboost.utils.b.a("android.scrollerboostmanager.ScrollerBoostManager");     // Catch: Exception -> L19 Throwable -> L24
        f68b = r3;     // Catch: Exception -> L19 Throwable -> L24
        f69c = android.ss.com.vboost.utils.b.a(r3, "listFling", new Class[]{Integer.TYPE});     // Catch: Exception -> L19 Throwable -> L24
    L29:
    L10:
        if (r2 != 28) goto L12;
    L15:
        Class<?> r4 = android.ss.com.vboost.utils.b.a("android.iawareperf.UniPerf");     // Catch: Exception -> L19 Throwable -> L24
        f68b = r4;     // Catch: Exception -> L19 Throwable -> L24
        f69c = android.ss.com.vboost.utils.b.a(r4, "uniPerfEvent", new Class[]{Integer.TYPE, String.class, int[].class});     // Catch: Exception -> L19 Throwable -> L24
        LogUtil.info("CHRYBoostFramework", "CHRYBoostFramework is loaded.");     // Catch: Exception -> L19 Throwable -> L24
        goto L29
    L12:
        if (r2 == 27) goto L15;
        if (r2 != 26) goto L29;
    L19:
        e = move-exception;
        LogUtil.error("CHRYBoostFramework", "CHRYBoostFramework() : Exception_1 = " + e);     // Catch: Throwable -> L24
        goto L22
    }

    public int a(long r10) {
        int r3 = -1;
        int r4 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L19
        if (r4 != 29) goto L7;
        f69c.invoke(d, new Object[]{Integer.valueOf((int) r10)});     // Catch: Throwable -> L19
        String r11 = "invoke listFling result  for " + r10;     // Catch: Throwable -> L19
    L15:
        LogUtil.info("CHRYBoostFramework", r11);     // Catch: Throwable -> L19
    L21:
        return r3;
    L7:
        if (r4 != 28) goto L9;
    L12:
        int r2 = ((Integer) f69c.invoke(d, new Object[]{4099, "canBoost=true|screenOn=1", new int[0]})).intValue();     // Catch: Throwable -> L19
        r11 = "invoke uniPerfEvent result " + r2 + " for " + r10;     // Catch: Throwable -> L17
        r3 = r2;
    L17:
        th = th;
        r3 = r2;
    L20:
        LogUtil.warn("cpuboost boost fail:", th.getMessage());
        goto L21
    L9:
        if (r4 == 27) goto L12;
        if (r4 != 26) goto L21;
    L19:
        th = th;
        goto L20
    }

    public boolean a() {
        return f67a;
    }
}
