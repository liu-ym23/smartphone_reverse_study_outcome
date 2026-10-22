package com.bytedance.crash;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.crash.monitor.d f203197a;

    @Override // java.lang.Runnable
    public final void run() {
        new com.bytedance.crash.monitor.e(this.f203197a).c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(com.bytedance.crash.monitor.k r100) {
        this.f203197a = r100;
    }
}
