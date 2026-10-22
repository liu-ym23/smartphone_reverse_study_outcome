package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ pa3.a a;

    public h(pa3.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pa3.a r0 = this.a;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        BuyNowFirstScreenMonitor r1 = r0.a;     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.a(BuyNowFirstScreenNode.CACHE_RENDER_END, System.currentTimeMillis());     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
