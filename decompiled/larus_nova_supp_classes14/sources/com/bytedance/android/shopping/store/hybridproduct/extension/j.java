package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public j(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        if (Intrinsics.areEqual((Integer) this.a.N.getTotalProductNum().getValue(), r3) == true) goto L7;
        this.a.N.getTotalProductNum().setValue(r3);
        return;
    }
}
