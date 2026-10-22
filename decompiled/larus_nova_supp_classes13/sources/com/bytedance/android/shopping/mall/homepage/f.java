package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ ECMallFragment a;

    public f(ECMallFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECMallFragment r0 = this.a;     // Catch: Throwable -> L9
        r0.g2 = true;     // Catch: Throwable -> L9
        if (r0.b2 == true) goto L7;
        DataEngineWrapper r1 = r0.L0;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.l(System.currentTimeMillis(), 3);     // Catch: Throwable -> L9
    L7:
        Lazy r2 = ECMallLogUtil.a;     // Catch: Throwable -> L9
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko get time out");     // Catch: Throwable -> L9
        this.a.ta0();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
