package com.bytedance.android.shopping.deepfeed.weights;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ DeepFeedProductHeaderView a;
    public final /* synthetic */ boolean b;

    public g(DeepFeedProductHeaderView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedProductHeaderView r0 = this.a;     // Catch: Throwable -> L4
        boolean r1 = this.b;     // Catch: Throwable -> L4
        Set<String> r2 = DeepFeedProductHeaderView.H0;     // Catch: Throwable -> L4
        r0.g(0, r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
