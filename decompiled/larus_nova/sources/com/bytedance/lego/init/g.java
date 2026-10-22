package com.bytedance.lego.init;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f254521a = null;

    static {
        f254521a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        InitScheduler.startDispatchIdleTask();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
