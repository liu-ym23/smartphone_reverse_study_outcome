package com.bytedance.android.shopping.orderlist.search.starter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import bf.c;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.common.utils.o;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeOrderSearchResultRouter implements c {

    public static final class a {
    }

    static {
    }

    public NativeOrderSearchResultRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_order_search";
    }

    public final boolean c(final Context r6, final Uri r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "uri");
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("NativeOrderSearchRouter", new NativeOrderSearchResultRouter$open$1(r7));
        int r2 = b.d;
        b r3 = new b(UUID.randomUUID().toString());
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "uri");
        OrderCommonLog.c(r3.a, new OrderSearchResultStarter$openDirectly$1(r7));
        ph.a.a(r6);
        Map<String, ig3.a> r0 = ig3.a.h;
        ig3.a r4 = ig3.a.C0206a.b(r3.c, "yata_order_search_result", MonitorScenes.FPS_SCENE_ORDER_SEARCH_RESULT, r7);
        r3.b = r4;
        OrderCommonFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L5;
        r5.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_SEARCH_RESULT);
    L5:
        ig3.a r9 = r3.b;
        if (r9 == null) goto L10;
        OrderCommonFirstScreenMonitor r10 = r9.a;
        if (r10 == null) goto L10;
        r10.a(FirstScreenPoint.INITIAL);
    L10:
        ig3.a r11 = r3.b;
        if (r11 == null) goto L15;
        OrderCommonFirstScreenMonitor r12 = r11.a;
        if (r12 == null) goto L15;
        r12.a(FirstScreenPoint.C_PAGE_INIT);
    L15:
        ig3.a r13 = r3.b;
        if (r13 == null) goto L20;
        OrderCommonFirstScreenMonitor r14 = r13.a;
        if (r14 == null) goto L20;
        r14.a(FirstScreenPoint.PRELOAD_TEMPLATE_START);
    L20:
        m.a r15 = m.a;
        m.b(new OrderSearchResultStarter$openDirectly$2(r6));
        ig3.a r16 = r3.b;
        if (r16 == null) goto L25;
        OrderCommonFirstScreenMonitor r17 = r16.a;
        if (r17 == null) goto L25;
        r17.a(FirstScreenPoint.PRELOAD_TEMPLATE_END);
    L25:
        ig3.a r18 = r3.b;
        if (r18 == null) goto L30;
        OrderCommonFirstScreenMonitor r19 = r18.a;
        if (r19 == null) goto L30;
        r19.a(FirstScreenPoint.PARSE_SCHEMA_START);
    L30:
        String r20 = j1.c(r7, "keyword");
        if (r20 == null) goto L33;
        String r21 = o.a(r20);
    L35:
        if (StringsKt.isBlank(r21) == false) goto L37;
        OrderCommonErrorMonitorKt.b(null, "SCHEMA_ERROR", "OrderSearchResultStarter-composeQueryParams: keyword is null");
    L37:
        OrderCommonLog.c(r3.a, new OrderSearchResultStarter$composeQueryParams$1(r7));
        HashMap r22 = j1.a(r7);
        LinkedHashMap r23 = new LinkedHashMap();
        Iterator r24 = r22.entrySet().iterator();
    L39:
        if (r24.hasNext() == false) goto L41;
        Map.Entry r25 = (Map.Entry) r24.next();
        r23.put(r25.getKey(), r25.getValue());
        goto L39
    L41:
        OrderSearchResultParams r26 = new OrderSearchResultParams(UriProtector.getQueryParameter(r7, "source_btm_token"), r23);
        ig3.a r27 = r3.b;
        if (r27 == null) goto L46;
        OrderCommonFirstScreenMonitor r28 = r27.a;
        if (r28 == null) goto L46;
        r28.a(FirstScreenPoint.PARSE_SCHEMA_END);
    L46:
        ig3.a r29 = r3.b;
        if (r29 == null) goto L51;
        OrderCommonFirstScreenMonitor r30 = r29.a;
        if (r30 == null) goto L51;
        r30.a(FirstScreenPoint.CONTAINER_INIT_START);
    L51:
        ig3.a r31 = r3.b;
        if (r31 == null) goto L56;
        OrderCommonFirstScreenMonitor r32 = r31.a;
        if (r32 == null) goto L56;
        r32.a(FirstScreenPoint.T_CONTAINER_INIT);
    L56:
        int r33 = OrderSearchResultActivity.F;
        String r34 = r3.c;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r34, "sessionId");
        Intent r35 = new Intent(r6, OrderSearchResultActivity.class);
        Bundle r36 = new Bundle();
        r36.putSerializable("ORDER_SEARCH_PARAM", r26);
        r36.putSerializable("PrefetchSessionId", r34);
        Unit r37 = Unit.INSTANCE;
        r35.putExtras(r36);
        r6.startActivity(r35);
        return true;
    L33:
        r21 = "";
        goto L35
    }
}
