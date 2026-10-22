package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ SkuOuterAddToCartHelper a;

    public i(SkuOuterAddToCartHelper r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.f.c(null, r4);
        mh3.a r0 = this.a.a;
        if (r0 != null) goto L5;
    L7:
        SkuCommonToast.c("添加失败，请稍后重试");
        return;
    L5:
        if (r0.e == null) goto L7;
        SkuYataAddCartChain.c(null, r4);
        goto L7
    }
}
