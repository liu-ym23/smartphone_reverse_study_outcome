package com.bytedance.ug.sdk.share.impl.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        j.c.f272350a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f() {
    }
}
