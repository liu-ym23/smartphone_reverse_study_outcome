package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.common.utility.collection.CollectionUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ ProductDetailInfoViewModel c;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.vm.j d;
    public final /* synthetic */ boolean e;

    @Override // java.lang.Runnable
    public final void run() {
        if (CollectionUtils.isEmpty(this.d.i) == false) goto L9;
        tg3.a r0 = this.c.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("asyncFetchActionHandler");
    L7:
        boolean r1 = this.e;
        r0.a(r0.c.F(), r1);
        return;
    }

    public y(ProductDetailInfoViewModel r1, com.bytedance.android.shopping.anchorv4.vm.j r2, boolean r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super("execute_async_task");
    }
}
