package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public u(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        com.bytedance.android.ec.hybrid.list.entity.k r7 = (com.bytedance.android.ec.hybrid.list.entity.k) r6;
        ArrayList r0 = r7.c;
        if (r0 == null) goto L13;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        com.bytedance.android.ec.hybrid.list.entity.i r2 = (com.bytedance.android.ec.hybrid.list.entity.i) r1.next();
        ArrayList r3 = r2.i;
        if (r3 == null) goto L6;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        ECHybridListItemVO r5 = (ECHybridListItemVO) r4.next();
        ShopHybridTabExtKt.d(r5, r2);
        ShopHybridTabExtKt.c(r5, true);
    L13:
        ECShopHybridProductListPresenter r8 = this.a;
        ShopHybridTabExtKt.f(r8, r7, r8.m0().getHasNextPage());
    }
}
