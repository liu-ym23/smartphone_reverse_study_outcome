package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.larus.apm.impl.protector.RunnableProtector;
import kk.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 implements Runnable {
    public final /* synthetic */ MallDeliveryLifecycleGeneralCallback a;

    public MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1(MallDeliveryLifecycleGeneralCallback r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.c(new AnonymousClass1(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
