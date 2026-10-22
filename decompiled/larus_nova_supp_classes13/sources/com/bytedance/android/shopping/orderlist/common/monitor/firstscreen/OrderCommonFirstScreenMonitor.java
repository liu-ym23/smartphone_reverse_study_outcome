package com.bytedance.android.shopping.orderlist.common.monitor.firstscreen;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.a;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonFirstScreenMonitor {
    public final String a;
    public final Map<String, String> b;
    public final Lazy c;
    public final Map<String, Object> d;
    public final List<FirstScreenPoint> e;
    public final ConcurrentHashMap<FirstScreenPoint, Long> f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final String l;

    public final String c() {
        return (String) this.c.getValue();
    }

    public final void a(final FirstScreenPoint r6) {
        Intrinsics.checkNotNullParameter(r6, "point");
        long r0 = System.currentTimeMillis();
        if (this.h == false) goto L6;
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$1(r6));
        return;
    L6:
        if (this.g == false) goto L9;
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$2(r6));
        return;
    L9:
        if (this.f.containsKey(r6) == false) goto L11;
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$3(r6));
        this.g = true;
        return;
    L11:
        this.f.put(r6, Long.valueOf(r0));
        if (r6 != FirstScreenPoint.END) goto L52;
        this.h = true;
        Lazy r4 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$4(r6));
        boolean r5 = this.k;
        if (r5 == false) goto L36;
        if (r5 == false) goto L34;
        Lazy r7 = ECSettingKeys.a;
        int r8 = p.a;
        Object r9 = Float.valueOf(0.1f);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        b r11 = b.b;     // Catch: Throwable -> L21
        Object r12 = a.a("iesec_trade_tti_sampling_rate", Float.class, r9, false);     // Catch: Throwable -> L21
        if (r12 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L21
    L28:
        if (new SecureRandom().nextFloat() > ((Number) r12).floatValue()) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == false) goto L34;
    L30:
        r13 = false;
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == true) goto L26;
        r9 = r15;
    L26:
        r12 = r9;
    L34:
        if (this.k == false) goto L71;
        Lazy r16 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$6(r6));
        return;
    L71:
        return;
    L36:
        Lazy r17 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$5(r6));
        d r18 = i.a.get(c());
        if (r18 == null) goto L46;
        Iterator<Map.Entry<String, Object>> r19 = this.d.entrySet().iterator();
    L40:
        if (r19.hasNext() == false) goto L42;
        Map.Entry<String, Object> r20 = r19.next();
        r18.b(r20.getKey(), String.valueOf(r20.getValue()));
        goto L40
    L42:
        Iterator r21 = ((LinkedHashMap) this.b).entrySet().iterator();
    L44:
        if (r21.hasNext() == false) goto L46;
        Map.Entry r22 = (Map.Entry) r21.next();
        r18.b((String) r22.getKey(), r22.getValue());
    L46:
        d r23 = i.a.get(c());
        if (r23 == null) goto L50;
        r23.report();
    L50:
        if (ECAppInfoService.e.i() == false) goto L73;
        final List r24 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("preload_template_duration", TuplesKt.to(FirstScreenPoint.PRELOAD_TEMPLATE_END, FirstScreenPoint.PRELOAD_TEMPLATE_START)), TuplesKt.to("parse_schema_duration", TuplesKt.to(FirstScreenPoint.PARSE_SCHEMA_END, FirstScreenPoint.PARSE_SCHEMA_START)), TuplesKt.to("api_duration", TuplesKt.to(FirstScreenPoint.REQUEST_END, FirstScreenPoint.REQUEST_START)), TuplesKt.to("query_net_duration", TuplesKt.to(FirstScreenPoint.QUERY_NET_END, FirstScreenPoint.QUERY_NET_START)), TuplesKt.to("parse_response_duration", TuplesKt.to(FirstScreenPoint.PARSE_RESPONSE_END, FirstScreenPoint.PARSE_RESPONSE_START)), TuplesKt.to("container_init_duration", TuplesKt.to(FirstScreenPoint.CONTAINER_INIT_END, FirstScreenPoint.CONTAINER_INIT_START)), TuplesKt.to("page_init_duration", TuplesKt.to(FirstScreenPoint.PAGE_INIT_END, FirstScreenPoint.PAGE_INIT_START)), TuplesKt.to("yata_init_duration", TuplesKt.to(FirstScreenPoint.YATA_INIT_END, FirstScreenPoint.YATA_INIT_START)), TuplesKt.to("yata_render_duration", TuplesKt.to(FirstScreenPoint.YATA_RENDER_END, FirstScreenPoint.YATA_RENDER_START)), TuplesKt.to("render_duration", TuplesKt.to(FirstScreenPoint.RENDER_END, FirstScreenPoint.RENDER_START)), TuplesKt.to("duration", TuplesKt.to(FirstScreenPoint.END, FirstScreenPoint.INITIAL))});
        Lazy r25 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$printDebugLog$1(this, r24));
        return;
    L73:
        return;
    L52:
        Lazy r26 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$addPointInner$7(r6));
        if (this.e.contains(r6) == true) goto L55;
        d r27 = i.a.get(c());
        if (r27 == null) goto L78;
        r27.b(r6.getValue(), Long.valueOf(r0));
        return;
    L78:
        return;
    L55:
        if (r6 != FirstScreenPoint.RENDER_END) goto L57;
        m.a r28 = m.a;
        m.c(new OrderCommonFirstScreenMonitor$addPointInner$8(this, r6));
        return;
    L57:
        d r29 = i.a.get(c());
        if (r29 == null) goto L76;
        r29.d(r6.getValue(), r0);
        return;
    }

    public final void b(final boolean r3) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$forceReport$1(r3));
        if (ECAppInfoService.e.i() == false) goto L5;
        this.k = false;
    L6:
        OrderCommonLog.a(this.a, new OrderCommonFirstScreenMonitor$forceReport$2(this));
        return;
    L5:
        this.k = !r3;
        goto L6
    }

    public final void e(final MonitorScenes r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        if (ECAppInfoService.e.i() == false) goto L8;
        this.k = q.a.getBoolean("ies_ecommerce_fe_custom_log_up_sampling", false);
    L8:
        m.a r0 = m.a;
        m.b(new OrderCommonFirstScreenMonitor$onPageStart$1(this, r4));
    }

    public final void g(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramMap");
        this.d.putAll(r2);
    }

    public OrderCommonFirstScreenMonitor(String r6, Uri r7) {
        Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");
        Intrinsics.checkNotNullParameter(r6, "bizCode");
        Intrinsics.checkNotNullParameter(r7, "uri");
        this.l = "ies_ecommerce_fe_custom_log";
        this.a = "OrderCommonFirstScreenMonitor_ies_ecommerce_fe_custom_log";
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(ig3.b.a);
        int r0 = k.a;
        r8.put("extra", k.b(j1.a(r7)).toString());
        Unit r9 = Unit.INSTANCE;
        this.b = r8;
        this.c = LazyKt.lazy(new OrderCommonFirstScreenMonitor$durationMonitorKey$2(this));
        this.d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "order_list_page"), TuplesKt.to("btm", "a1.b6871.c0.d0"), TuplesKt.to("spma", "a1.b6871.c0.d0"), TuplesKt.to("font_scale", ECAppInfoService.e.getCurrentFontScale())});
        this.e = CollectionsKt.listOf(new FirstScreenPoint[]{FirstScreenPoint.INITIAL, FirstScreenPoint.REQUEST_START, FirstScreenPoint.REQUEST_END, FirstScreenPoint.RENDER_START, FirstScreenPoint.RENDER_END});
        this.f = new ConcurrentHashMap();
        this.k = true;
    }

    public final void f(Map<String, String> r4, LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        this.b.putAll(r4);
        d r0 = i.a.get(c());
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r6.next();
        if (r0 == null) goto L4;
        r0.b(r1.getKey(), r1.getValue());
        goto L4
    L8:
        BtmSDK r7 = BtmSDK.INSTANCE;
        if ((r5 instanceof OrderListFragment) == false) goto L11;
        String r2 = "a1.b6871.c0.d0";
    L12:
        Iterator r8 = r7.createReportParams(r2, PageFinder.via(r5)).entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r9 = (Map.Entry) r8.next();
        Map<String, String> r3 = this.b;
        Object r10 = r9.getKey();
        String r11 = (String) r10;
        r3.put(r11, String.valueOf(r9.getValue()));
        goto L14
    L16:
        return;
    L11:
        r2 = "a1.b5418.c0.d0";
        goto L12
    }

    public final void d(final MonitorScenes r3, final Integer r4, final String r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (r4 != null) goto L6;
    L7:
        this.g = true;
    L9:
        if (this.j == false) goto L11;
        return;
    L11:
        this.j = true;
        m.a r0 = m.a;
        m.b(new OrderCommonFirstScreenMonitor$onPageShow$1(this, r3, r4, r5));
        return;
    L6:
        if (r4.intValue() == 0) goto L9;
        goto L7
    }
}
