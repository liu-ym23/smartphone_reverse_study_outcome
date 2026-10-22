package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ CheckPayStatusController a;

    public k(CheckPayStatusController r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        SsResponse r5 = (SsResponse) r4;
        if (((ma3.p) r5.body()).e() == false) goto L9;
        ma3.p r6 = (ma3.p) r5.body();
        BuyNowLog.d("selfPayAndCheck", "check pay status response received");
        CheckPayStatusController r0 = this.a;
        if (r6 == null) goto L7;
        ma3.o r7 = r6.a();
    L8:
        r0.f(4, r7, true);
        this.a.d();
        goto L9
    L7:
        r7 = null;
    L9:
        this.a.c(BuyNowCloseMethod.PAY_FAIL);
    }
}
