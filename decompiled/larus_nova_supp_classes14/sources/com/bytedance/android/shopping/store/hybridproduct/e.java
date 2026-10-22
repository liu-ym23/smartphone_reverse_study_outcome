package com.bytedance.android.shopping.store.hybridproduct;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public e(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ECShopHybridProductViewModel r0 = this.a.m0();
        r0.setCartAnimationView((WeakReference) r2);
    }
}
