package com.bytedance.android.livesdk.livecommerce.intro.auction;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ IntroAuctionPresenter a;

    public c(IntroAuctionPresenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        final IntroAuctionPresenter r0 = this.a;
        r0.getClass();
        boolean r1 = ECServiceManager.a;
        IAdapterService r2 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r2 == null) goto L9;
        pd.e r3 = r2.getIExternaHybridService();
        if (r3 == null) goto L9;
        pd.f r4 = r3.getExternalJsBridgeMethodInjectorAdapter();
        if (r4 == null) goto L9;
        return r4.d(new IntroAuctionPresenter$getUpdateContainerHeightMethod$1(r0));
    L9:
        return null;
    }
}
