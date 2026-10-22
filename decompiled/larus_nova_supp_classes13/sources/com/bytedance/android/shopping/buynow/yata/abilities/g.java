package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements v96.h {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public g(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "btm");
        Intrinsics.checkNotNullParameter(r4, "btm");
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r4, Boolean.TRUE).withPageFinder(this.a.getStaticState().d).build());
    }

    public final void c(Map<String, ? extends Object> r2) {
        PageFinder r0 = this.a.getStaticState().d;
        if (r0 == null) goto L6;
        com.bytedance.android.bcm.api.b.f(r0, r2);
        return;
    }

    public final void a(String r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (ECAppInfoService.e.i() == false) goto L6;
        Lazy r2 = BuyNowLog.a;     // Catch: Throwable -> L8
        BuyNowLog.a("BuyNowYataTrackerAbility", "eventName:" + r4 + "  params:" + cd.a.c(r5));     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        this.a.getTracker().b(r4, r5);
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
