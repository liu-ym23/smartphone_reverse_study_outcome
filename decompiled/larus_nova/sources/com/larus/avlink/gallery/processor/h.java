package com.larus.avlink.gallery.processor;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f292684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f292685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PthreadThreadV2 f292686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Process f292687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f292688e = null;

    public h() {
    }

    static {
        f292684a = new h();
        f292688e = new AtomicInteger(0);
    }

    public static void c() {
        PthreadThreadV2 r100 = new PthreadThreadV2(new g(), "LogMonitor");
        r100.setDaemon(true);
        ThreadMethodProxy.start(r100);
        f292686c = r100;
    }

    public final synchronized void d() {
        monitor-enter(this);
        AtomicInteger r100 = f292688e;     // Catch: Throwable -> L22
        int r101 = r100.decrementAndGet();     // Catch: Throwable -> L22
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L22
        r102.d("MorphoLogMonitor", "LogMonitor stop called, reference count: " + r101);     // Catch: Throwable -> L22
        if (r101 <= 0) goto L26;
    L20:
        monitor-exit(this);
        return;
    L26:
    L15:
        e = move-exception;
        FLogger.f375446a.e("MorphoLogMonitor", "Error stopping LogMonitor: " + e.getMessage(), e);     // Catch: Throwable -> L22
        goto L20
    L7:
        if (f292685b == false) goto L17;
        f292685b = false;     // Catch: Exception -> L15 Throwable -> L22
        Process r103 = f292687d;     // Catch: Exception -> L15 Throwable -> L22
        if (r103 == null) goto L11;
        r103.destroy();     // Catch: Exception -> L15 Throwable -> L22
    L11:
        f292687d = null;     // Catch: Exception -> L15 Throwable -> L22
        PthreadThreadV2 r104 = f292686c;     // Catch: Exception -> L15 Throwable -> L22
        if (r104 == null) goto L14;
        ThreadMethodProxy.join(r104, 2000);     // Catch: Exception -> L15 Throwable -> L22
    L14:
        f292686c = null;     // Catch: Exception -> L15 Throwable -> L22
        r102.i("MorphoLogMonitor", "LogMonitor stopped (all references released)");     // Catch: Exception -> L15 Throwable -> L22
    L17:
        r100.set(0);     // Catch: Exception -> L15 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static Process a(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public final synchronized void b(Context r100, boolean r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L14
        if (r101 == true) goto L12;
        int r102 = f292688e.incrementAndGet();     // Catch: Throwable -> L14
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L14
        r103.d("MorphoLogMonitor", "LogMonitor init called, reference count: " + r102);     // Catch: Throwable -> L14
        if (f292685b == true) goto L12;
        c();     // Catch: Exception -> L10 Throwable -> L14
        f292685b = true;     // Catch: Exception -> L10 Throwable -> L14
        r103.i("MorphoLogMonitor", "LogMonitor started (Release mode)");     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        FLogger.f375446a.e("MorphoLogMonitor", "Failed to start LogMonitor: " + e.getMessage(), e);     // Catch: Throwable -> L14
        f292688e.decrementAndGet();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
