package com.bytedance.android.shopping.orderlist.list.yata.ability;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.e;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListYataApiProtocol implements v96.a {
    public final OrderListFragment a;
    public final OrderListViewModel b;

    public final j a(m r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListYataApiProtocol", OrderListYataApiProtocol$createUpdateApi$1.INSTANCE);
        d r1 = new d();
        r1.a = "a1.b6871.c36711.d543737";
        r1.b = PageFinder.via(this.a);
        r1.c = new BcmParams();
        int r2 = ECSdk.a;
        IECHostService r3 = (IECHostService) ECSdk.a(IECHostService.class);
        final Boolean r4 = this.b.getStaticState().c;
        String r5 = null;
        if (r4 != null) goto L9;
        if (r3 == null) goto L8;
        IECAIHostService r6 = r3.getECHostAIService();
        if (r6 == null) goto L8;
        r4 = Boolean.valueOf(r6.isInApplet());
    L8:
        r4 = null;
    L9:
        Boolean r7 = this.b.getStaticState().d;
        if (r7 == null) goto L12;
        final boolean r8 = r7.booleanValue();
    L13:
        com.bytedance.kmp.ec.yata.store.node.c r10 = r9.a.j();
        if (r10 == null) goto L21;
        p r11 = r10.b.b;
        if (r11 == null) goto L21;
        Object r12 = q.b(r11, Reflection.getOrCreateKotlinClass(Boolean.class), "is_saas_order");
        if ((r12 instanceof Boolean) == true) goto L20;
        r12 = null;
    L20:
        Boolean r13 = (Boolean) r12;
    L22:
        final boolean r14 = Intrinsics.areEqual(r13, Boolean.TRUE);
        OrderCommonLog.c("OrderListYataApiProtocol", new OrderListYataApiProtocol$createUpdateApi$2(r4, r8, r14));
        if (r14 == false) goto L25;
        String r15 = "?ecom_appid=7386";
    L26:
        String r16 = OrderCommonApi.UPDATE_PATH.concat(r15);
        Pair[] r17 = new Pair[5];
        r17[0] = TuplesKt.to("page_type", "YATA_Android");
        JSONObject r18 = EcomBcmTracker.e(r1, new JSONObject());
        if (r18 == null) goto L29;
        r5 = r18.toString();
    L29:
        r17[1] = TuplesKt.to("cart_track", r5);
        r17[2] = TuplesKt.to("bcm_chain", EcomBcmTracker.g(r1));
        r17[3] = TuplesKt.to("is_in_applet", r4);
        r17[4] = TuplesKt.to("is_in_first_applet_page", Boolean.valueOf(r8));
        return new j(r16, MapsKt.mutableMapOf(r17));
    L25:
        r15 = "";
    L21:
        r13 = null;
        goto L22
    L12:
        OrderAppletPageScene r19 = OrderAppletPageScene.PAGE_INTERNAL;
        Intrinsics.checkNotNullParameter(r19, "scene");
        r8 = e.a(r3, r19).b;
        goto L13
    }

    public OrderListYataApiProtocol(OrderListFragment r2, OrderListViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
