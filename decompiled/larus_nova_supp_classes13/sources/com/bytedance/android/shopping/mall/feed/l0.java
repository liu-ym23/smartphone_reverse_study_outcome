package com.bytedance.android.shopping.mall.feed;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;

    public l0(ECMallFeed r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECMallFeed r0 = this.a;     // Catch: Throwable -> L4
        r0.Z0 = true;     // Catch: Throwable -> L4
        r0.q0();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
