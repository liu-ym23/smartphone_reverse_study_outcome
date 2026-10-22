package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;

    public q0(ECMallFeed r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q0();     // Catch: Throwable -> L9
        ECMallFeed.i r0 = this.a.Y;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.a(false);     // Catch: Throwable -> L9
    L5:
        ECMallGulPrefetch r1 = this.a.v();     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
