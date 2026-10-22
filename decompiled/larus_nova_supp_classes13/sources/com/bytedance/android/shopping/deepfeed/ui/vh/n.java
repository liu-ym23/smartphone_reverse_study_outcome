package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ DeepFeedProductSlcVH a;

    public n(DeepFeedProductSlcVH r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductSlcVH r0 = this.a;     // Catch: Throwable -> L4
        int r1 = DeepFeedProductSlcVH.k0;     // Catch: Throwable -> L4
        r0.H4();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
