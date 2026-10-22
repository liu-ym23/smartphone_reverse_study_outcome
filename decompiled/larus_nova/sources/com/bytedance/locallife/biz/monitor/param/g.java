package com.bytedance.locallife.biz.monitor.param;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f256756a = null;

    static {
        f256756a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
