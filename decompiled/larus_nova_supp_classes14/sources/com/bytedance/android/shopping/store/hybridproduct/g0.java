package com.bytedance.android.shopping.store.hybridproduct;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ ECShopHybridProductViewModel.a a;

    public g0(ECShopHybridProductViewModel.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;     // Catch: Throwable -> L6
        com.bytedance.android.shopping.store.lifecycle.m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.a.getStoreParam().getLifecycleMonitorId()));     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.N(this.a.a.getTabConfig());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
