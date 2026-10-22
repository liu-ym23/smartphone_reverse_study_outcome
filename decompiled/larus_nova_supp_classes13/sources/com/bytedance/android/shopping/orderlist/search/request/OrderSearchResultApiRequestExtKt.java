package com.bytedance.android.shopping.orderlist.search.request;

import android.content.Context;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.b;
import com.bytedance.android.shopping.orderlist.common.utils.e;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultApiRequestExtKt {
    public static final Map<String, Object> c(OrderSearchResultParams r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.getChineseKeyword();
    L6:
        r0.put("keyword", r2);
        if (r4 == null) goto L9;
        r1 = r4.getSearchSource();
    L9:
        r0.put("search_source", r1);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r3 = r0.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) r3.next();
        if (r6.getValue() == null) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L11;
        r5.put(r6.getKey(), r6.getValue());
        goto L11
    L15:
        r7 = false;
        goto L16
    L19:
        return MapsKt.toMutableMap(r5);
    L5:
        r2 = null;
        goto L6
    }

    public static final Map<String, Object> a(final String r11, final Boolean r12, final Boolean r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = ECSdk.a;
        IECHostService r2 = (IECHostService) ECSdk.a(IECHostService.class);
        Boolean r3 = null;
        if (r12 == null) goto L7;
        if (r13 == null) goto L7;
        b r4 = null;
    L8:
        if (r12 != null) goto L12;
        if (r4 == null) goto L11;
        Boolean r5 = r4.a;
    L13:
        if (r13 != null) goto L16;
        if (r4 == null) goto L17;
        r3 = Boolean.valueOf(r4.b);
    L17:
        if (r3 == null) goto L19;
        boolean r6 = r3.booleanValue();
    L20:
        Lazy r7 = OrderCommonLog.a;
        final Boolean r8 = r5;
        final boolean r9 = r6;
        OrderCommonLog.c("OrderSearchResultApiRequestExt", new OrderSearchResultApiRequestExtKt$createOrderSearchAppletExParams$$inlined$let$lambda$1(r8, r9, r12, r13, r11));
        r0.put("is_in_applet", r5);
        r0.put("is_in_first_applet_page", Boolean.valueOf(r6));
        return r0;
    L19:
        OrderAppletPageScene r10 = OrderAppletPageScene.PAGE_INTERNAL;
        Intrinsics.checkNotNullParameter(r10, "scene");
        r6 = e.a(r2, r10).b;
        goto L20
    L16:
        r3 = r13;
        goto L17
    L11:
        r5 = null;
        goto L13
    L12:
        r5 = r12;
    L7:
        r4 = e.a(r2, OrderAppletPageScene.PAGE_INTERNAL);
        goto L8
    }

    public static final Map b(final Map r17, final boolean r18, final JSONObject r19, final String r20, final String r21, final Map r22, final Boolean r23, final Boolean r24) {
        Intrinsics.checkNotNullParameter(r17, "orderSearchParams");
        Intrinsics.checkNotNullParameter(r22, "schemaParamsMap");
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r22);
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r23 == null) goto L7;
        if (r24 == null) goto L7;
        b r2 = null;
    L8:
        if (r23 != null) goto L12;
        if (r2 == null) goto L11;
        Boolean r15 = r2.a;
    L13:
        if (r24 != null) goto L17;
        if (r2 == null) goto L16;
        Boolean r3 = Boolean.valueOf(r2.b);
    L18:
        if (r3 == null) goto L20;
        boolean r4 = r3.booleanValue();
    L21:
        final boolean r16 = r4;
        Lazy r5 = OrderCommonLog.a;
        final int r7 = 2;
        final Boolean r6 = r15;
        OrderCommonLog.c("OrderSearchResultApiRequestExt", new OrderSearchResultApiRequestExtKt$createOrderSearchQueryExParams$$inlined$let$lambda$1(r6, r16, r22, r23, r24, r20, r7, r17, r18, r19, r21));
        r13.put("is_in_applet", r15);
        r13.put("is_in_first_applet_page", Boolean.valueOf(r16));
        r13.put("page_type", "YATA_Android");
        r13.put("query_type", 2);
        r13.put("order_search_params", r17);
        Context r8 = ECAppInfoService.e.getApplicationContext();
        if (r8 == null) goto L32;
        Object r9 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(eh.b.b(r8)));
        if ((r9 instanceof Number) == true) goto L26;
        r9 = null;
    L26:
        Number r10 = (Number) r9;
        if (r10 == null) goto L29;
        Integer r11 = Integer.valueOf(r10.intValue());
    L30:
        if (r11 == null) goto L32;
        int r12 = r11.intValue();
    L33:
        r13.put("status_bar_height", Integer.valueOf(r12));
        r13.put("hide_guess_you_like", Boolean.valueOf(r18));
        if (r19 == null) goto L36;
        String r14 = r19.toString();
    L37:
        r13.put("cart_track", r14);
        r13.put("safe_area_bottom_height", 0);
        r13.put("yata_session_id", r20);
        r13.put("bcm_chain", r21);
        return r13;
    L36:
        r14 = null;
        goto L37
    L29:
        r11 = null;
    L32:
        r12 = 60;
        goto L33
    L20:
        OrderAppletPageScene r25 = OrderAppletPageScene.PAGE_INTERNAL;
        Intrinsics.checkNotNullParameter(r25, "scene");
        r4 = e.a(r1, r25).b;
        goto L21
    L16:
        r3 = null;
        goto L18
    L17:
        r3 = r24;
        goto L18
    L11:
        r15 = null;
        goto L13
    L12:
        r15 = r23;
    L7:
        r2 = e.a(r1, OrderAppletPageScene.PAGE_INTERNAL);
        goto L8
    }
}
