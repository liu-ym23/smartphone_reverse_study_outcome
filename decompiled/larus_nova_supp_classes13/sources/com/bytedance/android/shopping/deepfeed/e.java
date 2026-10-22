package com.bytedance.android.shopping.deepfeed;

import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ DeepFeedProductRecyclerview a;
    public final /* synthetic */ DeepFeedProductFragment b;

    public e(DeepFeedProductRecyclerview r1, DeepFeedProductFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.i(this.b.K, "smooth scroll to pos 1, cur state " + this.a.getScrollState());     // Catch: Throwable -> L4
        this.a.smoothScrollToPosition(1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
