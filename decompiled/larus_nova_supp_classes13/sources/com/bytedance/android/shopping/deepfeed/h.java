package com.bytedance.android.shopping.deepfeed;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductFragment r0 = this.a.a;     // Catch: Throwable -> L4
        int r1 = DeepFeedProductFragment.k1;     // Catch: Throwable -> L4
        r0.la0();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
