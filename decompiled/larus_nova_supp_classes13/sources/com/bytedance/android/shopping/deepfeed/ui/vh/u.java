package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u implements Runnable {
    public final /* synthetic */ uc3.f a;

    public u(uc3.f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uc3.f r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.k(System.currentTimeMillis());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
