package com.bytedance.android.shopping.orderlist.list.tracker;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.orderlist.common.monitor.error.a {
    public final EventActionImpl a;

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final Map<String, Object> c() {
        return new LinkedHashMap();
    }

    public b(com.bytedance.android.shopping.orderlist.list.viewmodel.a r8) {
        Intrinsics.checkNotNullParameter(r8, "orderStaticState");
        EventActionImpl r0 = new EventActionImpl();
        this.a = r0;
        Pair[] r1 = new Pair[11];
        r1[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_page");
        r1[2] = TuplesKt.to("btm", "a1.b6871.c0.d0");
        r1[3] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r1[4] = TuplesKt.to("spma", "a1.b6871.c0.d0");
        r1[5] = TuplesKt.to("font_scale", ECAppInfoService.e.getCurrentFontScale());
        r1[6] = TuplesKt.to("session_id", r8.b);
        OrderListParams r3 = r8.g;
        String r5 = null;
        if (r3 == null) goto L5;
        String r4 = r3.getEnterFrom();
    L6:
        r1[7] = TuplesKt.to(SimilarProductParam.ENTER_FROM, r4);
        OrderListParams r6 = r8.g;
        if (r6 == null) goto L9;
        r5 = r6.getPreviousPage();
    L9:
        r1[8] = TuplesKt.to("previous_page", r5);
        r1[9] = TuplesKt.to("btm", r8.p);
        r1[10] = TuplesKt.to("spma", r8.p);
        r0.appendEventParams(MapsKt.mapOf(r1));
        r0.appendEventParams(r8.a());
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
    public final void b(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "params");
        EventActionImpl r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(r4);
        Unit r5 = Unit.INSTANCE;
        r0.doEventAction(r3, null, r1);
    }
}
