package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static volatile Handler a;
    public static final Handler b = null;
    public static final a c = null;

    public a() {
    }

    static {
        c = new a();
        b = new Handler(Looper.getMainLooper());
    }

    public final Handler a() {
        if (a != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (a != null) goto L8;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("AnimWorkThread");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r0);     // Catch: Throwable -> L11
        a = new Handler(r0.getLooper());     // Catch: Throwable -> L11
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        Handler r2 = a;
        Intrinsics.checkNotNull(r2);
        return r2;
    }
}
