package io.reactivex.internal.util;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static void b() {
        if (RxJavaPlugins.isFailOnNonBlockingScheduler() == true) goto L5;
        return;
    L5:
        if ((ThreadMethodProxy.currentThread() instanceof io.reactivex.internal.schedulers.h) == true) goto L10;
        if (RxJavaPlugins.onBeforeBlocking() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Attempt to block on a Scheduler " + ThreadMethodProxy.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
    }

    public static void a(d r100, Disposable r101) {
        if (r100.getCount() != 0) goto L10;
        return;
    L10:
        b();     // Catch: InterruptedException -> L7
        r100.await();     // Catch: InterruptedException -> L7
        return;
    L7:
        e = move-exception;
        r101.dispose();
        ThreadMethodProxy.currentThread().interrupt();
        throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
    }
}
