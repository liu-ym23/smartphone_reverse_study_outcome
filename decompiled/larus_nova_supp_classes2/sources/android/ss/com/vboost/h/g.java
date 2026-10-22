package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f88b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f89c;
    private static Method d;
    private static Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f90f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f91g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f92h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f93a;

    public g(Context r6) {
        this.f93a = null;
        c();
        Class<?> r1 = f89c;     // Catch: Exception -> L7
        if (r1 == null) goto L16;
        this.f93a = android.ss.com.vboost.utils.b.a(r1, new Class[]{Context.class}).newInstance(new Object[]{r6});     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        this.f93a = android.ss.com.vboost.utils.b.a(f89c, new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        return;
    L10:
        LogUtil.error("MTKPerfService", "MTKPerfService() : Exception_4 = " + e);
    }

    private void c() {
        monitor-enter(g.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f88b == false) goto L18;
    L13:
        monitor-exit(g.class);     // Catch: Throwable -> L15
        return;
    L18:
        LogUtil.debug("MTKPerfService", "reflect com.mediatek.perfservice.PerfServiceWrapper class.");     // Catch: Exception -> L9 Throwable -> L15
        f89c = android.ss.com.vboost.utils.b.a("com.mediatek.perfservice.PerfServiceWrapper");     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userGetCapability method.");     // Catch: Exception -> L9 Throwable -> L15
        Class r5 = Integer.TYPE;     // Catch: Exception -> L9 Throwable -> L15
        d = android.ss.com.vboost.utils.b.a(f89c, "userGetCapability", new Class[]{r5});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userRegScn method.");     // Catch: Exception -> L9 Throwable -> L15
        e = android.ss.com.vboost.utils.b.a(f89c, "userRegScn", new Class[0]);     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userRegScnConfig method.");     // Catch: Exception -> L9 Throwable -> L15
        f90f = android.ss.com.vboost.utils.b.a(f89c, "userRegScnConfig", new Class[]{r5, r5, r5, r5, r5, r5});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userEnable method.");     // Catch: Exception -> L9 Throwable -> L15
        android.ss.com.vboost.utils.b.a(f89c, "userEnable", new Class[]{r5});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userEnableTimeoutMs method.");     // Catch: Exception -> L9 Throwable -> L15
        f91g = android.ss.com.vboost.utils.b.a(f89c, "userEnableTimeoutMs", new Class[]{r5, r5});     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.debug("MTKPerfService", "reflect userDisable method.");     // Catch: Exception -> L9 Throwable -> L15
        f92h = android.ss.com.vboost.utils.b.a(f89c, "userDisable", new Class[]{r5});     // Catch: Exception -> L9 Throwable -> L15
        f88b = true;     // Catch: Exception -> L9 Throwable -> L15
        LogUtil.info("MTKPerfService", "MTKPerfService is loaded.");     // Catch: Exception -> L9 Throwable -> L15
    L9:
        e = move-exception;
        f88b = false;     // Catch: Throwable -> L15
        LogUtil.error("MTKPerfService", "PerfService() : Exception_1 = " + e);     // Catch: Throwable -> L15
        goto L13
    }

    public void a(int r8) {
        Method r2 = f92h;     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        r2.invoke(this.f93a, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userDisable with handle " + r8);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public void a(int r8, int r9) {
        Method r2 = f91g;     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        r2.invoke(this.f93a, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userEnableTimeoutMs with handle " + r8 + " and timeout " + r9);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public void a(int r8, int r9, int r10, int r11, int r12, int r13) {
        Method r2 = f90f;     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        r2.invoke(this.f93a, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});     // Catch: Exception -> L7
        LogUtil.info("MTKPerfService", "invoke userRegScnConfig with handle " + r8 + " and cmd " + r9);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
    }

    public boolean a() {
        return f88b;
    }

    public int b() {
        Method r0 = e;     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return ((Integer) r0.invoke(this.f93a, new Object[0])).intValue();
    L8:
        return -1;
    L6:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
        goto L8
    }

    public int b(int r5) {
        Method r0 = d;     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return ((Integer) r0.invoke(this.f93a, new Object[]{Integer.valueOf(r5)})).intValue();
    L8:
        return -1;
    L6:
        e = move-exception;
        LogUtil.error("MTKPerfService", "Exception " + e);
        goto L8
    }
}
