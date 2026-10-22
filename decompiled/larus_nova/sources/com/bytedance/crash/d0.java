package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.ensure.EnsureApi;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f203144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f203145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f203146d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f203147a;

        public a(Context r100, PolarisFileWrapper r101) {
            if (new PolarisFileWrapper(r101, "crash").exists() == true) goto L6;
            bi4.a.f19105n = true;
        L6:
            monitor-enter(com.bytedance.crash.crash.c.class);
            com.bytedance.crash.util.p.d("CrashManager startMonitor");     // Catch: Throwable -> L13
            if (com.bytedance.crash.crash.c.f203123d != null) goto L10;
            com.bytedance.crash.crash.c.f203123d = new com.bytedance.crash.crash.c(r100, r101);     // Catch: Throwable -> L13
        L10:
            monitor-exit(com.bytedance.crash.crash.c.class);
            ch4.b.a("Crash_Init");
            xg4.p.e(r100, r101);
            ch4.b.a("Anr_Init");
            b0 r102 = new b0();
            wh4.b.d().e(r102, 0);
            bi4.e.f19140g.f19141a = true;
            wh4.b.post(new c0());
            ch4.b.a("DefaultWorkThread_Init");
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f203148a;

        public b() {
            wh4.b.post(new e0());
        }
    }

    public static void a() {
        com.bytedance.crash.util.p.d("initAsyncForEvent");
        if (ch4.c.f23766b == null) goto L5;
    L14:
        com.bytedance.crash.general.a r100 = com.bytedance.crash.general.a.a();
        if (r100 == null) goto L17;
        r100.b();
    L17:
        EnsureApi.a();
        return;
    L5:
        monitor-enter(ch4.c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ch4.c.f23766b != null) goto L9;
        ch4.c.f23766b = new ch4.c(i.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ch4.c.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void c() {
        if (b.f203148a == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f203148a != null) goto L9;
        b.f203148a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    }

    public static boolean d() {
        if (a.f203147a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Context r100, PolarisFileWrapper r101) {
        if (a.f203147a == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f203147a != null) goto L9;
        a.f203147a = new a(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    }
}
