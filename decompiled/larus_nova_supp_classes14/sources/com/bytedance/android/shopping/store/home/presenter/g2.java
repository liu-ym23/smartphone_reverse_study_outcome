package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g2<T> implements Observer {
    public final /* synthetic */ ECShopSliceTopBarPresenter.b a;

    public g2(ECShopSliceTopBarPresenter.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Pair r2 = (Pair) r1;
        ECShopSliceTopBarPresenter.r0(this.a.a);
    }
}
