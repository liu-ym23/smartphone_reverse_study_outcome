package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public g0(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        boolean r5 = !Intrinsics.areEqual((Boolean) r4, Boolean.TRUE);
        String r0 = this.a.D;
        if (r0 == null) goto L8;
        IMarketingService r1 = (IMarketingService) ECMarketingSDK.a.getValue();
        if (r1 == null) goto L9;
        r1.a(this.a.u().c(), r0, r5);
        return;
    L9:
        return;
    }
}
