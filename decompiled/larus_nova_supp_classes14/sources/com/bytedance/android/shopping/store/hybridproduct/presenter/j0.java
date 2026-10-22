package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ ShopSlicedProductCardPresenterV2 a;
    public final /* synthetic */ ShopSlcProductItemV2 b;

    public j0(ShopSlicedProductCardPresenterV2 r1, ShopSlcProductItemV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopHybridProductViewModel r0 = this.a.k0();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.doEventAction("add_to_cart_show", this.a.i0("show_product", this.b), new Pair[0]);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
