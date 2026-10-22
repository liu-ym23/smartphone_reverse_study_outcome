package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public j3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((ShopLiveState) r2).a != ShopLiveState.PlayState.ERROR) goto L6;
        ECShopTopBarSearchPresenterV2.s0(this.a, 1.0f);
        return;
    }
}
