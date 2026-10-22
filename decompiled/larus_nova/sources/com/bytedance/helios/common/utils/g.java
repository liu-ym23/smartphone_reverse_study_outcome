package com.bytedance.helios.common.utils;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f245399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f245400d;

    public g() {
        super("helios.worker", 0);
    }

    public static g d() {
        g r100 = f245399c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f245399c != null) goto L10;
        g r101 = new g();     // Catch: Throwable -> L13
        f245399c = r101;     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L13
        f245400d = new Handler(f245399c.getLooper());     // Catch: Throwable -> L13
    L10:
        g r102 = f245399c;     // Catch: Throwable -> L13
        monitor-exit(g.class);     // Catch: Throwable -> L13
        return r102;
    }

    public static Handler e() {
        Handler r100 = f245400d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f245399c != null) goto L10;
        g r101 = new g();     // Catch: Throwable -> L13
        f245399c = r101;     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L13
        f245400d = new Handler(f245399c.getLooper());     // Catch: Throwable -> L13
    L10:
        Handler r102 = f245400d;     // Catch: Throwable -> L13
        monitor-exit(g.class);     // Catch: Throwable -> L13
        return r102;
    }
}
