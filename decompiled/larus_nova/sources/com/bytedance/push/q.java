package com.bytedance.push;

import com.bytedance.android.service.manager.PushServiceManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        PushServiceManager.get().getIAllianceService().onInitOnProcessIsolationProtectedMode();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q() {
    }
}
