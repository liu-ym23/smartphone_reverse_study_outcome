package com.bytedance.android.shopping.buynow.monitor.order;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final String b;
    public final Lazy c;
    public final Lazy d;
    public final Map<String, Object> e;
    public final ConcurrentHashMap<BuyNowOrderNode, Long> f;
    public JSONObject g;
    public boolean h;
    public boolean i;
    public final List<BuyNowOrderNode> j;
    public final String k;

    public final String b() {
        return (String) this.c.getValue();
    }

    public a(String r3) {
        Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");
        Intrinsics.checkNotNullParameter(r3, "bizCode");
        this.k = "ies_ecommerce_fe_custom_log";
        this.a = "BuyNowOrderMonitor_ies_ecommerce_fe_custom_log";
        this.b = "a1.b7411.c5642.d1959";
        this.c = LazyKt.lazy(new BuyNowOrderMonitor$durationMonitorKey$2(this));
        this.d = LazyKt.lazy(new BuyNowOrderMonitor$orderPerfCommonParams$2(this));
        this.e = new LinkedHashMap();
        this.f = new ConcurrentHashMap();
        this.j = CollectionsKt.listOf(new BuyNowOrderNode[]{BuyNowOrderNode.INITIAL, BuyNowOrderNode.REQUEST_START, BuyNowOrderNode.REQUEST_END, BuyNowOrderNode.STANDARD_RENDER_START, BuyNowOrderNode.STANDARD_RENDER_END});
    }

    public final void a(final BuyNowOrderNode r7, final long r8) {
        Intrinsics.checkNotNullParameter(r7, "node");
        if (this.i == false) goto L6;
        return;
    L6:
        if (this.h == false) goto L9;
        return;
    L9:
        if (this.f.contains(r7) == false) goto L11;
        this.h = true;
        return;
    L11:
        this.f.put(r7, Long.valueOf(r8));
        if (r7 != BuyNowOrderNode.END) goto L65;
        Lazy r9 = BuyNowLog.a;
        BuyNowLog.a(this.a, "add node: " + r7.getValue() + " 查单完成，上报埋点");
        JSONObject r10 = this.g;
        if (r10 != null) goto L16;
    L36:
        Iterator<Map.Entry<String, String>> r11 = sa3.a.a.entrySet().iterator();
    L38:
        if (r11.hasNext() == false) goto L42;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getValue();
        d r0 = i.a.get(b());
        if (r0 == null) goto L38;
        r0.b(r12.getKey(), r13);
        goto L38
    L42:
        Map<String, Object> r14 = this.e;
        if (r14 == null) goto L52;
        Iterator r15 = ((LinkedHashMap) r14).entrySet().iterator();
    L46:
        if (r15.hasNext() == false) goto L52;
        Map.Entry r16 = (Map.Entry) r15.next();
        Object r17 = r16.getValue();
        if (r17 == null) goto L46;
        d r1 = i.a.get(b());
        if (r1 == null) goto L46;
        r1.b((String) r16.getKey(), r17);
    L52:
        Iterator r18 = ((Map) this.d.getValue()).entrySet().iterator();
    L54:
        if (r18.hasNext() == false) goto L60;
        Map.Entry r19 = (Map.Entry) r18.next();
        Object r20 = r19.getValue();
        if (r20 == null) goto L54;
        d r2 = i.a.get(b());
        if (r2 == null) goto L54;
        r2.b((String) r19.getKey(), r20.toString());
        goto L54
    L60:
        d r21 = i.a.get(b());
        if (r21 == null) goto L63;
        r21.report();
    L63:
        this.i = true;
        return;
    L16:
        if (r10.length() == 0) goto L36;
        JSONObject r22 = this.g;
        if (r22 == null) goto L36;
        Iterator<String> r23 = r22.keys();
        if (r23 == null) goto L36;
    L22:
        if (r23.hasNext() == false) goto L36;
        String r24 = r23.next();
        JSONObject r25 = this.g;
        if (r25 == null) goto L22;
        Long r26 = Long.valueOf(r25.optLong(r24, 0));
        if (r26.longValue() <= 0) goto L28;
        boolean r3 = true;
    L29:
        if (r3 == true) goto L32;
        r26 = null;
    L32:
        if (r26 == null) goto L22;
        long r4 = r26.longValue();
        d r27 = i.a.get(b());
        if (r27 == null) goto L22;
        r27.b(r24, Long.valueOf(r4));
        goto L22
    L28:
        r3 = false;
        goto L29
    L65:
        if (this.j.contains(r7) == true) goto L67;
        d r5 = i.a.get(b());
        if (r5 == null) goto L109;
        r5.b(r7.getValue(), Long.valueOf(r8));
        return;
    L109:
        return;
    L67:
        if (r7 != BuyNowOrderNode.STANDARD_RENDER_END) goto L69;
        com.bytedance.android.shopping.buynow.utils.i.a r6 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowOrderMonitor$addNodeInner$2(this, r7, r8));
        return;
    L69:
        d r28 = i.a.get(b());
        if (r28 == null) goto L107;
        r28.d(r7.getValue(), r8);
        return;
    }

    public final void c(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (((Map) this.d.getValue()).containsKey(r2) == true) goto L5;
        return;
    L5:
        ((Map) this.d.getValue()).put(r2, r3);
    }
}
