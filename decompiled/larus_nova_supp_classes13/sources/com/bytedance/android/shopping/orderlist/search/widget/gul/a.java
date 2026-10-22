package com.bytedance.android.shopping.orderlist.search.widget.gul;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.ies.web.jsbridge2.f;
import pd.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements f.b {
    public final /* synthetic */ OrderSearchResultGULComponent a;

    public a(OrderSearchResultGULComponent r1) {
        this.a = r1;
    }

    public final f<Object, Object> a() {
        final OrderSearchResultGULComponent r0 = this.a;
        r0.getClass();
        ECBaseBridgeMethod r1 = new OrderSearchResultGULComponent$getBridgeMethod$bridgeMethod$1(r0);
        boolean r2 = ECServiceManager.a;
        e r3 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r3 == null) goto L7;
        pd.f r4 = r3.getExternalJsBridgeMethodInjectorAdapter();
        if (r4 == null) goto L7;
        return r4.d(r1);
    L7:
        return null;
    }
}
