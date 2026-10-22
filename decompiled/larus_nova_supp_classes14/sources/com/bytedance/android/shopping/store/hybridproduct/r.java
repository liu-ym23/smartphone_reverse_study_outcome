package com.bytedance.android.shopping.store.hybridproduct;

import android.view.Choreographer;
import com.bytedance.android.shopping.store.lifecycle.ECStorePerfMonitor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements Choreographer.FrameCallback {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ Function0 b;

    public r(ECShopHybridProductListPresenter r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r2) {
        ECStorePerfMonitor r3 = this.a.N.getPerfMonitor();
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.store.lifecycle.g r4 = r3.k;
        if (r4 == null) goto L7;
        int r5 = com.bytedance.android.shopping.store.lifecycle.g.e;
        r4.c(11, null);
    L7:
        this.b.invoke();
    }
}
