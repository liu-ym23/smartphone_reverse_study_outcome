package com.bytedance.helios.common.utils;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f245394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f245395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f245396e;

    public d() {
        super("helios.monitor", 0);
    }

    public static void d() {
        if (f245394c != null) goto L6;
        d r100 = new d();
        f245394c = r100;
        ThreadMethodProxy.start(r100);
        Handler r101 = new Handler(f245394c.getLooper());
        f245395d = r101;
        f245396e = new b(r101);
        return;
    }

    public static b e() {
        monitor-enter(d.class);
        d();     // Catch: Throwable -> L7
        b r100 = f245396e;     // Catch: Throwable -> L7
        monitor-exit(d.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static Handler f() {
        monitor-enter(d.class);
        d();     // Catch: Throwable -> L7
        Handler r100 = f245395d;     // Catch: Throwable -> L7
        monitor-exit(d.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }
}
