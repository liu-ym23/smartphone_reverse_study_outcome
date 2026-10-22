package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements Runnable {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ ECHybridRecyclerView b;
    public final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.k c;

    public z(ECShopHybridProductListPresenter r1, ECHybridRecyclerView r2, com.bytedance.android.ec.hybrid.list.entity.k r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopHybridProductListPresenter.e0(this.a, 0, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
