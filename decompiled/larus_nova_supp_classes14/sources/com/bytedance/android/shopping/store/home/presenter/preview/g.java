package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ ECShopLivePreviewPresenter a;

    public g(ECShopLivePreviewPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ShopLiveState r4 = (ShopLiveState) r3;
        if (r4.b == ShopLiveState.LiveScene.LIVE_TAB) goto L5;
        return;
    L5:
        if (r4.a != ShopLiveState.PlayState.ERROR) goto L18;
        ECShopLivePreviewPresenter r5 = this.a;
        int r0 = ECShopLivePreviewPresenter.D;
        r5.s0();
        im.b r6 = this.a.p0();
        if (r6 == null) goto L9;
        int r1 = im.b.q;
        r6.a(false);
    L9:
        im.b r7 = this.a.p0();
        if (r7 == null) goto L15;
        IECLivePlayerClient r2 = r7.c;
        if (r2 == null) goto L14;
        r2.release();
    L14:
        r7.c = null;
    L15:
        ExtensionsKt.gone(this.a.a0());
        return;
    }
}
