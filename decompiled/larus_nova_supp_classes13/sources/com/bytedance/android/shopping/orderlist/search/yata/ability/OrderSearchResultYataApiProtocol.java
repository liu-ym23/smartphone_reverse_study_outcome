package com.bytedance.android.shopping.orderlist.search.yata.ability;

import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.e;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultYataApiProtocol implements v96.a {
    public final OrderSearchResultViewModel a;

    public final j a(m r6) {
        Intrinsics.checkNotNullParameter(r6, "info");
        int r7 = ECSdk.a;
        IECHostService r8 = (IECHostService) ECSdk.a(IECHostService.class);
        final Boolean r0 = this.a.getStaticState().d;
        if (r0 != null) goto L9;
        if (r8 == null) goto L8;
        IECAIHostService r1 = r8.getECHostAIService();
        if (r1 == null) goto L8;
        r0 = Boolean.valueOf(r1.isInApplet());
    L8:
        r0 = null;
    L9:
        Boolean r2 = this.a.getStaticState().e;
        if (r2 == null) goto L12;
        final boolean r9 = r2.booleanValue();
    L13:
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataApiProtocol", new OrderSearchResultYataApiProtocol$createUpdateApi$1(r0, r9));
        return new j(OrderCommonApi.UPDATE_PATH, MapsKt.mapOf(new Pair[]{TuplesKt.to("page_type", "YATA_Android"), TuplesKt.to("is_in_applet", r0), TuplesKt.to("is_in_first_applet_page", Boolean.valueOf(r9))}));
    L12:
        OrderAppletPageScene r4 = OrderAppletPageScene.PAGE_INTERNAL;
        Intrinsics.checkNotNullParameter(r4, "scene");
        r9 = e.a(r8, r4).b;
        goto L13
    }

    public OrderSearchResultYataApiProtocol(OrderSearchResultActivity r2, OrderSearchResultViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r3;
    }
}
