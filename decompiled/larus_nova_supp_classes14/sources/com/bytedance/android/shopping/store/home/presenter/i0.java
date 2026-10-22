package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0<T> implements Observer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public i0(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        ECShopFloatLynxPresenter.s0(this.a);
        Iterator r6 = ((LinkedHashMap) this.a.H).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r6.next();
        this.a.y0((com.bytedance.android.shopping.store.home.entity.l) r0.getKey());
        goto L4
    L6:
        ECShopFloatLynxPresenter.t0(this.a);
        IMarketingService r7 = (IMarketingService) ECMarketingSDK.a.getValue();
        if (r7 == null) goto L9;
        r7.a(this.a.u().c(), "shop_floating_layer", this.a.V());
    L9:
        ECShopFloatLynxPresenter r8 = this.a;
        r8.x0(r8.v);
    }
}
