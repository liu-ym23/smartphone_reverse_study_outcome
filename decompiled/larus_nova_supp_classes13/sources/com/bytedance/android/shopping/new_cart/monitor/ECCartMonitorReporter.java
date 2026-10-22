package com.bytedance.android.shopping.new_cart.monitor;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.monitor.duration.c;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.bytedance.kmp.ec.yata.common.perf.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n83.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECCartMonitorReporter {
    public static int d;
    public static final Lazy e = null;
    public static final c f = null;
    public static final Function1<Long, Unit> g = null;
    public final ECCartMonitorReporter$ttnetExtraInfoMap$1 a;
    public final k b;
    public final ConcurrentHashMap<String, d> c;

    public static final class a {
        public static ECCartMonitorReporter a() {
            return (ECCartMonitorReporter) ECCartMonitorReporter.e.getValue();
        }
    }

    public static abstract class b {
        public final int a;
        public final String b;

        public static class a extends b {

            /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter$b$a$a, reason: collision with other inner class name */
            public static final class C0125a extends a {
                public C0125a() {
                    super(100, null);
                }
            }

            public a(int r1, String r2) {
                super(r1, r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter$b$b, reason: collision with other inner class name */
        public static final class C0126b extends b {
            public static final C0126b c = null;

            public C0126b() {
                super(0, null);
            }

            static {
                c = new C0126b();
            }
        }

        public b(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        e = LazyKt.lazy(ECCartMonitorReporter$Companion$instance$2.INSTANCE);
        f = new c();
        g = ECCartMonitorReporter$Companion$jsonParsCB$1.INSTANCE;
    }

    public ECCartMonitorReporter() {
        this.a = new ECCartMonitorReporter$ttnetExtraInfoMap$1();
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L5;
        k r2 = r1.getMonitorService();
    L6:
        this.b = r2;
        this.c = new ConcurrentHashMap();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(final String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        b2.b(new ECCartMonitorReporter$reportDurationEnd$1(this, r2));
    }

    public static void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "stamp");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        i r0 = i.a;
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.ec.monitor.duration.d r3 = r0.get(r1);
        if (r3 == null) goto L9;
        r3.a(r2);
        return;
    }

    public final void f(String r2, com.bytedance.kmp.ec.yata.common.perf.c r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        d r4 = this.c.get(r2);
        if (r4 == null) goto L6;
        AbsPerfMonitor.d(r4, r3);
        return;
    }

    public static final void a(ECCartMonitorReporter r2, hd3.d r3, com.bytedance.android.ec.monitor.duration.d r4) {
        r2.getClass();
        if (r3 == null) goto L12;
        Map<String, Object> r5 = r3.a();
        if (r5 == null) goto L12;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, Object> r0 = r6.next();
        Object r1 = r0.getValue();
        if (r1 == null) goto L8;
        r4.b(r0.getKey(), r1);
    L12:
        if (r3 == null) goto L21;
        Map<String, Object> r7 = r3.b();
        if (r7 == null) goto L32;
        Iterator<Map.Entry<String, Object>> r8 = r7.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L33;
        Map.Entry<String, Object> r9 = r8.next();
        Object r10 = r9.getValue();
        if (r10 == null) goto L17;
        r4.b(r9.getKey(), r10);
        goto L17
    L33:
        return;
    L32:
        return;
    }

    public static final void b(ECCartMonitorReporter r20, Object r21, com.bytedance.android.ec.monitor.duration.d r22) {
        r20.getClass();
        if (r21 == null) goto L12;
        Map r0 = k0.d(r21, null, 2);
        if (r0 == null) goto L18;
        Iterator r1 = CollectionsKt.listOf(new String[]{"tt_total_duration", "tt_timing_connect", "tt_net_duration", "tt_timing_ttfb_inner", "tt_resp_body_size", "tt_timing_body_recv", "tt_timing_parse", "tt_req_body_size", "tt_timing_dns", "tt_timing_ssl", "tt_timing_proxy", "tt_timing_send", "tt_timing_header_recv", "tt_timing_ttfb_edge", "tt_timing_ttfb_origin", "tt_timing_ttfb_rtt", "tt_timing_req_interceptor", "tt_timing_req_pre_process", "tt_timing_req_create"}).iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        String r2 = (String) r1.next();
        String r3 = (String) r0.get(r2);
        if (r3 == null) goto L8;
        r22.b(r2, r3);
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static void e(String r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (r1 == null) goto L10;
        com.bytedance.android.ec.monitor.duration.d r4 = i.a.get(r1);
        if (r4 == null) goto L11;
        r4.b(r2, r3);
        return;
    L11:
        return;
    }
}
