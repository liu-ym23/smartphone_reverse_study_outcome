package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ ECShopExplainCardPresenter a;

    public a(ECShopExplainCardPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ShopLiveState r4 = (ShopLiveState) r3;
        if (r4.b == ShopLiveState.LiveScene.LIVE_TAB) goto L5;
        return;
    L5:
        if (r4.a != ShopLiveState.PlayState.ERROR) goto L12;
        cf.d r5 = this.a.l;
        if (r5 == null) goto L9;
        r5.onDestroy();
    L9:
        this.a.l = null;
        return;
    }
}
