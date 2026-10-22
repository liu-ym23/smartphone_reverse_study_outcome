package com.bytedance.android.shopping.mall.homepage.card.common;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECLynxCardMonitorHolder a;

    public e(ECLynxCardMonitorHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECLynxCardMonitorHolder r0 = this.a;     // Catch: Throwable -> L4
        int r1 = ECLynxCardMonitorHolder.g2;     // Catch: Throwable -> L4
        r0.I4();     // Catch: Throwable -> L4
        Lazy r2 = ECMallLogUtil.a;     // Catch: Throwable -> L4
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "timeout to clear animation view");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
