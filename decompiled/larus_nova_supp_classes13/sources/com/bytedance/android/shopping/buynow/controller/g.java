package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.shopping.buynow.data.model.PageStartupStatus;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ CheckPayStatusController a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public g(CheckPayStatusController r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r10) {
        SsResponse r11 = (SsResponse) r10;
        ma3.p r0 = (ma3.p) r11.body();
        long r1 = System.currentTimeMillis();
        BuyNowLog.d("selfPayAndCheck", "check pay status response received");
        CheckPayStatusController r3 = this.a;
        int r5 = this.b;
        String r6 = null;
        if (r0 == null) goto L5;
        ma3.o r7 = r0.a();
    L6:
        r3.f(r5, r7, false);
        CheckPayStatusController r4 = this.a;
        int r8 = r4.d + 1;
        r4.d = r8;
        pa3.a r9 = r4.i;
        if (r9 == null) goto L11;
        com.bytedance.android.shopping.buynow.monitor.order.a r12 = r9.b;
        if (r12 == null) goto L11;
        r12.c("order_check_loop_count", Integer.valueOf(r8));
    L11:
        if (r0 == null) goto L13;
        Integer r13 = r0.c();
    L14:
        if (r13 != null) goto L17;
    L18:
        if (r0 == null) goto L20;
        Integer r14 = r0.d();
    L21:
        if (r14 != null) goto L24;
    L26:
        BuyNowLog.d("selfPayAndCheck", "check pay status api request fails");
        if (r0 == null) goto L29;
        Integer r15 = r0.d();
    L30:
        if (r15 != null) goto L36;
        if (r0 == null) goto L33;
        Integer r16 = r0.c();
    L34:
        if (r16 != null) goto L36;
        String r17 = null;
    L37:
        com.bytedance.android.shopping.buynow.tracker.a r2 = this.a.f.W90().getTracker();
        if (r0 == null) goto L42;
        LogPbData r18 = r0.b();
        if (r18 == null) goto L42;
        String r19 = r18.getImprId();
    L43:
        com.bytedance.android.shopping.buynow.monitor.error.a.c(r2, "network error", r17, com.bytedance.android.shopping.extensions.k.j(r19), com.bytedance.android.shopping.extensions.k.j(this.c));
    L51:
        if (r0 == null) goto L56;
        LogPbData r20 = r0.b();
        if (r20 == null) goto L56;
        r6 = r20.getImprId();
    L56:
        throw new CheckPayStatusController.QueryPayStatusException(r6);
    L42:
        r19 = null;
        goto L43
    L33:
        r16 = null;
    L36:
        r17 = String.valueOf(r0.d());
        goto L37
    L29:
        r15 = null;
        goto L30
    L24:
        if (r14.intValue() != 0) goto L26;
    L44:
        ra3.b.a("/order/yata/confirmOrderRender", r11, r1);
        ma3.o r110 = r0.a();
        if (r110 == null) goto L51;
        if (r110.a() != 1) goto L51;
        BuyNowLog.d("selfPayAndCheck", "check pay status api request successes");
        com.bytedance.android.shopping.buynow.tracker.a r111 = this.a.f.W90().getTracker();
        r111.getClass();
        r111.b("wallet_cashier_ds_callback_sdk", MapsKt.mapOf(TuplesKt.to("result", 1)));
        this.a.f.W90().updateCheckStatus("success");
        CheckPayStatusController.a(this.a, true, this.b);
        this.a.f.W90().setPageStartupStatus(PageStartupStatus.PAY_SUCCESS);
        return;
    L20:
        r14 = null;
        goto L21
    L17:
        if (r13.intValue() == 0) goto L44;
    L13:
        r13 = null;
        goto L14
    L5:
        r7 = null;
        goto L6
    }
}
