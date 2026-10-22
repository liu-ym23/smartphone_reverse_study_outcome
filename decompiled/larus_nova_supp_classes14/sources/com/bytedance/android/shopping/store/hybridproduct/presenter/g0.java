package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ ShopSlicedProductCardPresenter a;

    public g0(ShopSlicedProductCardPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        ej3.a r5 = (ej3.a) r4;
        if (r5 == null) goto L20;
        String r0 = r5.a;
        com.bytedance.android.ec.store.repository.vo.l r1 = ((sm.l) this.a).k;
        if (r1 == null) goto L8;
        String r2 = ((StoreV2ProductItemVO) r1).a;
    L10:
        if ((!Intrinsics.areEqual(r0, r2)) == true) goto L21;
        com.bytedance.android.ec.store.repository.vo.l r3 = ((sm.l) this.a).k;
        if (r3 == null) goto L18;
        r3.U.put("product_is_appointed", Boolean.valueOf(Intrinsics.areEqual(r5.b, "open")));
        ShopSlicedProductCardPresenter r6 = this.a;
        com.bytedance.android.ecom.arch.slice.render.r r7 = r6.p;
        if (r7 == null) goto L19;
        r7.a(com.bytedance.android.ec.store.repository.vo.m.a(r3, r6.q.getSliceService().a()), this.a.m);
        return;
    L19:
        return;
    L18:
        return;
    L21:
        return;
    L8:
        r2 = null;
        goto L10
    }
}
