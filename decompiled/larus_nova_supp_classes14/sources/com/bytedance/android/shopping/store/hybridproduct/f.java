package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ ECShopProductListBffResponseDTO b;

    public f(g r1, ECShopProductListBffResponseDTO r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopHybridProductListPresenter.d0(this.a.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
