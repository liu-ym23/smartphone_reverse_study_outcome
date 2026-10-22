package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x implements Runnable {
    public final /* synthetic */ ECMallFeed a;
    public final /* synthetic */ int b;

    public x(ECMallFeed r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECHybridListEngine r0 = this.a.J;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        ECHybridRecyclerView r1 = r0.b;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.scrollBy(0, this.b);     // Catch: Throwable -> L9
    L7:
        this.a.x1 = null;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
