package com.lynx.animax.player;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f380355c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f380356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f380357b;

    public c() {
    }

    public static synchronized c a() {
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f380355c != null) goto L9;
        c r100 = new c();     // Catch: Throwable -> L12
        f380355c = r100;     // Catch: Throwable -> L12
        if (r100.f380356a != null) goto L9;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("Animax_Codec", -4);     // Catch: Throwable -> L12
        r100.f380356a = r101;     // Catch: Throwable -> L12
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L12
        r100.f380357b = new Handler(r100.f380356a.getLooper());     // Catch: Throwable -> L12
    L9:
        c r102 = f380355c;     // Catch: Throwable -> L12
        monitor-exit(c.class);
        return r102;
    }
}
