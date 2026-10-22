package com.bytedance.kmp.ec.yata.common.platform.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f251537a = null;

    static {
        f251537a = new AtomicInteger(0);
    }

    public static final void a(Object r100) {
        if (Thread.holdsLock(r100) == false) goto L6;
        return;
    L6:
        throw new AssertionError("Thread " + ThreadMethodProxy.currentThread().getName() + " must hold lock on " + r100);
    }
}
