package com.bytedance.android.shopping.mall.homepage;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ ECMallFragment a;

    public g(ECMallFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECMallFragment r0 = this.a;     // Catch: Throwable -> L4
        int r1 = ECMallFragment.h4;     // Catch: Throwable -> L4
        r0.ta0();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
