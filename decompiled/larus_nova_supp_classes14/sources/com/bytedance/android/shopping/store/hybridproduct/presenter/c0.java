package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ ShopSlicedProductCardBasePresenter a;
    public final /* synthetic */ ShopSlcProductItemV2 b;

    public c0(ShopSlicedProductCardBasePresenter r1, ShopSlcProductItemV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ShopSlicedProductCardBasePresenter r0 = this.a;     // Catch: Throwable -> L6
        HybridPageViewModel r1 = ((com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) r0).x;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.doEventAction("add_to_cart_show", r0.h0("show_product", this.b), new Pair[0]);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
