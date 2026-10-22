package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0 implements sm.k {
    public final /* synthetic */ ShopSlicedProductCardPresenter a;

    public final String c7() {
        com.bytedance.android.ec.store.repository.vo.l r0 = ((sm.l) this.a).k;
        if (r0 == null) goto L7;
        List r1 = ((StoreV2ProductItemVO) r0).f;
        if (r1 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r1);
    L7:
        return null;
    }

    public h0(ShopSlicedProductCardPresenter r1) {
        this.a = r1;
    }
}
