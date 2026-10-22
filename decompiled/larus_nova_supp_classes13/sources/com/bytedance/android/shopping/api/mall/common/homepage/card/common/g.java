package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ i a;

    public g(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.e(this.a.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
