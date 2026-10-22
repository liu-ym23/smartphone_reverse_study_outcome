package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j0<T> implements Observer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public j0(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Integer r10 = (Integer) r9;
        if (r10 != null) goto L6;
    L11:
        if (r10 != null) goto L14;
    L15:
        ECShopFloatLynxPresenter r0 = this.a;
        if (r0.A != 0) goto L18;
        ECShopFloatLynxPresenter.v0(r0, "ecom.marketing.event.scrollStart");
    L19:
        ECShopFloatLynxPresenter r1 = this.a;
        r1.A = r10.intValue();
        return;
    L18:
        ECShopFloatLynxPresenter.v0(this.a, "ecom.marketing.event.scrolling");
        goto L19
    L14:
        if (r10.intValue() == 0) goto L18;
    L6:
        if (r10.intValue() != 0) goto L11;
        Event r2 = new Event("ecom.shop.scroll.event", System.currentTimeMillis(), null, 4, null);
        Pair[] r3 = new Pair[2];
        r3[0] = TuplesKt.to("scroll", 0);
        String r4 = this.a.T().getStoreParam().getShopId();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r3[1] = TuplesKt.to("shop_id", r4);
        r2.setMapParams(MapsKt.mapOf(r3));
        EventCenter.enqueueEvent(r2);
        ECShopFloatLynxPresenter.v0(this.a, "ecom.marketing.event.scrollStop");
        goto L19
    }
}
