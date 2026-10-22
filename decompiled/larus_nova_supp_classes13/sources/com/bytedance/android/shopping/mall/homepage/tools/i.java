package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ ECHybridListEngine a;

    public i(ECHybridListEngine r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECHybridListEngine r0 = this.a;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        com.bytedance.android.ec.hybrid.list.ability.a r1 = r0.b.e;     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        k0 r2 = (k0) r1.getAbility(k0.class);     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r2.a();     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
