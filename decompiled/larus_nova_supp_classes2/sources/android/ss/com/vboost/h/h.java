package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f94b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f95c;
    private static Method d;
    private static Method e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f96a;

    public h(Context r6) {
        this.f96a = null;
        c();
        Class<?> r1 = f95c;     // Catch: Exception -> L7
        if (r1 == null) goto L16;
        this.f96a = android.ss.com.vboost.utils.b.a(r1, new Class[]{Context.class}).newInstance(new Object[]{r6});     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        this.f96a = android.ss.com.vboost.utils.b.a(f95c, new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        return;
    L10:
        LogUtil.error("BoostFramework", "BoostFramework() : Exception_3 = " + e);
    }

    private void c() {
        monitor-enter(h.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f94b == false) goto L20;
    L13:
        monitor-exit(h.class);     // Catch: Throwable -> L15
        return;
    L20:
        LogUtil.debug("BoostFramework", "reflect android.util.BoostFramework class.");     // Catch: Exception -> L9 Throwable -> L15
        f95c = android.ss.com.vboost.utils.b.a("android.util.BoostFramework");     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("BoostFramework", "reflect perfLockAcquire method.");     // Catch: Exception -> L9 Throwable -> L15
        d = android.ss.com.vboost.utils.b.a(f95c, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("BoostFramework", "reflect perfLockRelease method.");     // Catch: Exception -> L9 Throwable -> L15
        e = android.ss.com.vboost.utils.b.a(f95c, "perfLockRelease", new Class[0]);     // Catch: Exception -> L9 Throwable -> L15
        f94b = true;     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.info("BoostFramework", "QcomBoostFramework is loaded.");     // Catch: Exception -> L9 Throwable -> L15
    L9:
        e = move-exception;
        f94b = false;     // Catch: Throwable -> L15
        LogUtil.error("BoostFramework", "BoostFramework() : Exception_1 = " + e);     // Catch: Throwable -> L15
        goto L13
    }

    public int a(int r9, int... r10) {
        int r2 = -1;
        Method r3 = d;     // Catch: Exception -> L7
        if (r3 == null) goto L12;
        r2 = ((Integer) r3.invoke(this.f96a, new Object[]{Integer.valueOf(r9), r10})).intValue();     // Catch: Exception -> L7
        LogUtil.info("BoostFramework", "invoke perfLockAcquire result " + r2 + " for " + r9 + " with " + Arrays.toString(r10));     // Catch: Exception -> L7
        return r2;
    L12:
        return -1;
    L7:
        e = move-exception;
        LogUtil.error("BoostFramework", "Exception " + e);
        return r2;
    }

    public boolean a() {
        return f94b;
    }

    public int b() {
        int r2 = -1;
        Method r3 = e;     // Catch: Exception -> L7
        if (r3 == null) goto L12;
        r2 = ((Integer) r3.invoke(this.f96a, new Object[0])).intValue();     // Catch: Exception -> L7
        LogUtil.info("BoostFramework", "invoke perfLockRelease result " + r2);     // Catch: Exception -> L7
        return r2;
    L12:
        return -1;
    L7:
        e = move-exception;
        LogUtil.error("BoostFramework", "Exception " + e);
        return r2;
    }
}
