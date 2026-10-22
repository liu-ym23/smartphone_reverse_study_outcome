package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.data.model.PageStartupStatus;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ CheckPayStatusController a;
    public final /* synthetic */ int b;

    public h(CheckPayStatusController r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        BuyNowLog.d("selfPayAndCheck", "check pay status api request fails completely, triggering onError");
        Object r1 = null;
        if ((r8 instanceof CheckPayStatusController.QueryPayStatusException) == true) goto L5;
        r8 = null;
    L5:
        CheckPayStatusController.QueryPayStatusException r9 = (CheckPayStatusController.QueryPayStatusException) r8;
        if (r9 == null) goto L8;
        String r10 = r9.getLogId();
    L9:
        String r11 = "checkPayResult request success logID: " + r10;
        Intrinsics.checkNotNullParameter("CheckPayStatusController", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        dm.a.a("buynow_CheckPayStatusController").w(r11, null);     // Catch: Throwable -> L12
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L17;
        ECExceptionMonitor.e(r13);
    L17:
        this.a.f.W90().updateCheckStatus(CheckStatus.FAIL);
        Map<String, ? extends Object> r14 = this.a.b;
        if (r14 == null) goto L20;
        Object r15 = r14.get("pay_params");
    L22:
        if ((r15 instanceof Map) == true) goto L24;
        r15 = null;
    L24:
        Map r16 = (Map) r15;
        if (r16 == null) goto L27;
        Object r17 = r16.get("sdk_info");
    L29:
        if ((r17 instanceof Map) == true) goto L31;
        r17 = null;
    L31:
        Map r18 = (Map) r17;
        com.bytedance.android.shopping.buynow.tracker.a r2 = this.a.f.W90().getTracker();
        if (r18 == null) goto L34;
        r1 = r18.get("extra");
    L34:
        String r19 = String.valueOf(r1);
        r2.getClass();
        r2.b("wallet_cashier_ds_callback_sdk", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", 0), TuplesKt.to("extra", r19)}));
        CheckPayStatusController.a(this.a, false, this.b);
        this.a.f.W90().setPageStartupStatus(PageStartupStatus.PAY_FAIL);
        return;
    L27:
        r17 = null;
        goto L29
    L20:
        r15 = null;
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L8:
        r10 = null;
        goto L9
    }
}
