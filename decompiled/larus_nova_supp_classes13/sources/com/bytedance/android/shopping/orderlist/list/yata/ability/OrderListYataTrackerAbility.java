package com.bytedance.android.shopping.orderlist.list.yata.ability;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListYataTrackerAbility implements h {
    public final OrderListViewModel a;

    public OrderListYataTrackerAbility(OrderListViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "btm");
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r4, Boolean.TRUE).withPageFinder(this.a.getBtmPageFinder()).build());
    }

    public final void c(Map<String, ? extends Object> r2) {
        PageFinder r0 = this.a.getBtmPageFinder();
        if (r0 == null) goto L6;
        com.bytedance.android.bcm.api.b.f(r0, r2);
        return;
    }

    public final void a(final String r3, final Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (ECAppInfoService.e.i() == false) goto L6;
        Lazy r1 = OrderCommonLog.a;     // Catch: Throwable -> L8
        OrderCommonLog.a("OrderListYataTrackerAbility", new OrderListYataTrackerAbility$track$$inlined$runCatching$lambda$1(r3, r4));     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        this.a.getTracker().b(r3, r4);
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
