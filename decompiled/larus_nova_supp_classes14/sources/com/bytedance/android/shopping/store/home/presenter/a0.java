package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopCartInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2.d a;
    public final /* synthetic */ ECShopCartInfo b;

    public a0(ECShopFloatCartEntryPresenterV2.d r1, ECShopCartInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopFloatCartEntryPresenterV2 r0 = this.a.a;     // Catch: Throwable -> L8
        r0.u = AnimationStatus.RUNNING;     // Catch: Throwable -> L8
        CartCtrlInfo r1 = this.b.getCartCtrlInfo();     // Catch: Throwable -> L8
        View r2 = r0.y();     // Catch: Throwable -> L8
        c0 r3 = new c0(r0, r1);     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        Integer r4 = r1.getLatencySeconds();     // Catch: Throwable -> L8
    L6:
        r2.postDelayed(r3, com.bytedance.android.shopping.extensions.c.a(r4, 1000));     // Catch: Throwable -> L8
        return;
    L5:
        r4 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
