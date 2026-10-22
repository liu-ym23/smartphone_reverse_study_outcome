package com.bytedance.android.shopping.deepfeed.weights;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ DeepFeedProductHeaderView a;

    public h(DeepFeedProductHeaderView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductHeaderView r0 = this.a;     // Catch: Throwable -> L4
        r0.g(r0.k, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
