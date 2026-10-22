package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;

    public g0(ECMallFeed r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECHybridListEngine r0 = this.a.J;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b.O();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
