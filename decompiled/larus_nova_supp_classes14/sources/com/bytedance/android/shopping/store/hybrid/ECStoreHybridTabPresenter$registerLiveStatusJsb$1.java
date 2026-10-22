package com.bytedance.android.shopping.store.hybrid;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreHybridTabPresenter$registerLiveStatusJsb$1 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ ECStoreHybridTabPresenter a;

    public ECStoreHybridTabPresenter$registerLiveStatusJsb$1(ECStoreHybridTabPresenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        boolean r0 = ECServiceManager.a;
        IAdapterService r1 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r1 == null) goto L9;
        pd.e r2 = r1.getIExternaHybridService();
        if (r2 == null) goto L9;
        pd.f r3 = r2.getExternalJsBridgeMethodInjectorAdapter();
        if (r3 == null) goto L9;
        return r3.d(new ECStoreHybridTabPresenter$registerLiveStatusJsb$1$method$1(this));
    L9:
        return null;
    }
}
