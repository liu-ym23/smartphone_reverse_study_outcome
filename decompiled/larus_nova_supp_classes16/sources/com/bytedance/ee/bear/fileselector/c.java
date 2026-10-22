package com.bytedance.ee.bear.fileselector;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ FileSelectFragment a;

    public c(FileSelectFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileSelectFragment r0 = this.a;     // Catch: Throwable -> L4
        int r1 = FileSelectFragment.q;     // Catch: Throwable -> L4
        r0.dismissDialog();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
