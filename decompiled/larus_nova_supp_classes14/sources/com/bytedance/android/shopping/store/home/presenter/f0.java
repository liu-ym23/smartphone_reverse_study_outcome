package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;

    public f0(ECShopFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        uj3.j r6 = (uj3.j) r5;
        ECShopFloatLynxPresenter.u0(this.a, r6.c(), true);
        uj3.j r0 = this.a.T().getLastTab();
        if (r0 == null) goto L5;
        ECShopFloatLynxPresenter.u0(this.a, r0.c(), false);
    L5:
        boolean r7 = !r6.h();
        if (this.a.D == null) goto L11;
        IMarketingService r1 = (IMarketingService) ECMarketingSDK.a.getValue();
        if (r1 == null) goto L12;
        Context r2 = this.a.u().c();
        String r3 = this.a.D;
        Intrinsics.checkNotNull(r3);
        r1.a(r2, r3, r7);
        return;
    L12:
        return;
    }
}
