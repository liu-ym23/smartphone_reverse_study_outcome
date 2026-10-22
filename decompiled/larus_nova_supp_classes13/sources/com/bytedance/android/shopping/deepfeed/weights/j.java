package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ DeepFeedProductHeaderView a;

    public j(DeepFeedProductHeaderView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoCoverLayout r0 = this.a.getVideoProgressContainer();     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.g.setFillCurrent(true);     // Catch: Throwable -> L9
    L5:
        this.a.e.b();     // Catch: Throwable -> L9
        ProductCardProgressIndicator r1 = this.a.getProgressIndicator();     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setFillCurrent(false);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
