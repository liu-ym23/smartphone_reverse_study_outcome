package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y implements Runnable {
    public final /* synthetic */ ECMallFeed a;

    public y(ECMallFeed r1) {
        this.a = r1;
    }

    public final void a() {
        ECMallFeed r0 = this.a;
        r0.H = true;
        if (r0.G == true) goto L14;
        DataEngineWrapper r1 = r0.C1;
        if (r1 == null) goto L9;
        y93.a r2 = r1.b;
        if (r2 == null) goto L9;
        Long r3 = r2.e();
    L10:
        if (r3 != null) goto L14;
        DataEngineWrapper r4 = this.a.C1;
        if (r4 == null) goto L14;
        r4.l(System.currentTimeMillis(), 3);
    L9:
        r3 = null;
    L14:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko get time out");
        this.a.G();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
