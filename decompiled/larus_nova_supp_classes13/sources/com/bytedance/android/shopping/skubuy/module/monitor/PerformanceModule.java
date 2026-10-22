package com.bytedance.android.shopping.skubuy.module.monitor;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.model.abscontainer.OrderPerformancePointType;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n33.f;
import s33.b;
import u33.a;
import v43.l;
import w33.c;
import w33.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PerformanceModule<STATE extends g & l, PROPS extends u33.a> extends b<STATE, PROPS> {
    public final String b;
    public final Map<String, String> c;
    public final int d;
    public HttpRequestInfo e;
    public String f;
    public final Map<String, Long> g;
    public final Map<String, Object> h;

    public static final class a<DATA> implements c {
        public final /* synthetic */ PerformanceModule a;

        public a(PerformanceModule r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            p43.c.i r9 = (p43.c) r8;
            String r1 = null;
            if ((r9 instanceof p43.c.c) == false) goto L6;
            ((LinkedHashMap) this.a.g).clear();
            PerformanceModule r10 = this.a;
            r10.f = null;
            PerformanceModule.B(r10, OrderPerformancePointType.ORDER_SUBMIT);
            return;
        L6:
            if ((r9 instanceof p43.c.g) == false) goto L9;
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CREATE_START);
            com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r11 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
            s43.a.a(CheckPointType.PAY_START, null, 6);
            return;
        L9:
            if ((r9 instanceof p43.c.e) == false) goto L12;
            PerformanceModule.B(this.a, OrderPerformancePointType.REQUEST_START);
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CREATE_NET_START);
            com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r12 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
            s43.a.a("request_start", "电商提单", 4);
            return;
        L12:
            if ((r9 instanceof p43.c.d) == false) goto L15;
            PerformanceModule.B(this.a, OrderPerformancePointType.REQUEST_END);
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CREATE_NET_END);
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CREATE_END);
            PerformanceModule.B(this.a, OrderPerformancePointType.STANDARD_RENDER_START);
            com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r13 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
            s43.a.a("request_end", "电商提单", 4);
            return;
        L15:
            if ((r9 instanceof p43.c.i) == false) goto L20;
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_TTPAY_CALL_START);
            Map<? extends String, ? extends Object> r14 = r9.a;
            if (r14 == null) goto L66;
            this.a.h.putAll(r14);
            return;
        L66:
            return;
        L20:
            if ((r9 instanceof p43.c.h) == false) goto L47;
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_TTPAY_CALL_END);
            p43.c.h r15 = (p43.c.h) r9;
            if (a2.b(r15.a) == false) goto L68;
            b43.c r0 = b43.c.a;
            Map r16 = b43.c.d(r15.a);
            if (r16 == null) goto L26;
            Object r17 = r16.get("sdk_performance");
        L28:
            if ((r17 instanceof Map) == true) goto L30;
            r17 = null;
        L30:
            Map r18 = (Map) r17;
            if (r18 == null) goto L35;
            Object r2 = r18.get("performace_stages");
            if (r2 == null) goto L35;
            String r3 = r2.toString();
        L36:
            Map<? extends String, ? extends Object> r4 = b43.c.d(r3);
            if (r4 == null) goto L39;
            this.a.h.putAll(r4);
        L39:
            if (r18 == null) goto L43;
            Object r19 = r18.get("performance_common_params");
            if (r19 == null) goto L43;
            r1 = r19.toString();
        L43:
            Map<? extends String, ? extends Object> r20 = b43.c.d(r1);
            if (r20 == null) goto L69;
            this.a.h.putAll(r20);
            return;
        L69:
            return;
        L35:
            r3 = null;
            goto L36
        L26:
            r17 = null;
            goto L28
        L68:
            return;
        L47:
            if ((r9 instanceof p43.c.b) == false) goto L50;
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CHECK_START);
            com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r21 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
            s43.a.a("request_start", "电商查单", 4);
            return;
        L50:
            if ((r9 instanceof p43.c.a) == false) goto L72;
            PerformanceModule.B(this.a, OrderPerformancePointType.ORDER_CHECK_END);
            PerformanceModule.B(this.a, OrderPerformancePointType.STANDARD_RENDER_END);
            PerformanceModule.B(this.a, OrderPerformancePointType.END);
            com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r5 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
            s43.a.a("request_end", "电商查单", 4);
            s43.a.a("pay_end", null, 6);
            String r6 = this.a.f;
            if (r6 != null) goto L54;
        L57:
            boolean r7 = true;
        L58:
            if (r7 == false) goto L60;
            this.a.h.put("result", Integer.valueOf(((p43.c.a) r9).a ? 1 : 0));
            PerformanceModule r22 = this.a;
            r22.h.putAll(r22.g);
            PerformanceModule r23 = this.a;
            r23.h.putAll(r23.c);
            ((b) this.a).a.d.a().a("ies_ecommerce_fe_custom_log", this.a.h);
        L60:
            ((LinkedHashMap) this.a.g).clear();
            return;
        L54:
            if (r6.length() == 0) goto L57;
            r7 = false;
            goto L58
        }
    }

    public final void b() {
        ((b) this).a.d.e().c(new PerformanceModule$flowFirstScreenRenderFinished$1(this, null));
    }

    public final void y() {
        ((b) this).a.a.o().a(new a(this));
    }

    public final String j() {
        return this.b;
    }

    public PerformanceModule(l33.b<STATE, PROPS> r5) {
        Intrinsics.checkNotNullParameter(r5, "containerContext");
        super(r5);
        this.b = "PerformanceModule";
        this.c = MapsKt.mapOf(TuplesKt.to("type", "PERFORMANCE_LOG"));
        this.d = 50000;
        this.g = new LinkedHashMap();
        this.h = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("btm", "a1.b7411.c5642.d1959"), TuplesKt.to("order_type", ""), TuplesKt.to("involved_pay", ""), TuplesKt.to("pay_type", ""), TuplesKt.to("order_check_loop_count", ""), TuplesKt.to("result", ""), TuplesKt.to("no_password_pay", 0), TuplesKt.to("new_bind_card", 0)});
    }

    public final void f(f r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        this.e = r2.a;
    }

    public static void B(PerformanceModule r4, OrderPerformancePointType r5) {
        long r0 = System.currentTimeMillis();
        if (r4.g.containsKey(r5.getValue()) == false) goto L5;
        r4.f = r5.getValue();
        return;
    L5:
        r4.g.put(r5.getValue(), Long.valueOf(r0));
    }
}
