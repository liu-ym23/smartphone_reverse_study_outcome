package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.window.shop.home.WindowMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n1 implements Runnable {
    public final /* synthetic */ ECWindowInfoPresenterBase.f a;

    public n1(ECWindowInfoPresenterBase.f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowMonitor r0 = this.a.a.O().getShopParam().getMonitor();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.addRenderMetric();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
