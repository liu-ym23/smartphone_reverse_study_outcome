package com.bytedance.android.shopping.buynow.monitor.firstscreen;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.utils.i;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.c;
import sc3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowFirstScreenMonitor {
    public static final /* synthetic */ int l = 0;
    public final String a;
    public final Lazy b;
    public final ConcurrentHashMap<String, Long> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public HttpRequestInfo g;
    public final Map<String, String> h;
    public final String i;
    public final c j;
    public final b k;

    public static final class a {
    }

    static {
    }

    public final String d() {
        return (String) this.b.getValue();
    }

    public static /* synthetic */ void b(BuyNowFirstScreenMonitor r2, BuyNowFirstScreenNode r3) {
        r2.a(r3, System.currentTimeMillis());
    }

    public final void a(BuyNowFirstScreenNode r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        c(r2.getValue(), r3);
    }

    public final void c(final String r5, final long r6) {
        if (this.e == false) goto L7;
        Lazy r7 = BuyNowLog.a;
        BuyNowLog.a(this.a, "addNode node:" + r5 + "  已经完成首屏埋点 直接返回");
        return;
    L7:
        if (this.d == false) goto L11;
        Lazy r8 = BuyNowLog.a;
        BuyNowLog.a(this.a, "addNode node:" + r5 + "  首屏接口错误或者链路错误 丢弃此次埋点");
        return;
    L11:
        if (this.c.containsKey(r5) == false) goto L14;
        Lazy r9 = BuyNowLog.a;
        BuyNowLog.a(this.a, "addNode node:" + r5 + "  重复节点 丢弃此次埋点");
        this.d = true;
        return;
    L14:
        this.c.put(r5, Long.valueOf(r6));
        if (Intrinsics.areEqual(r5, BuyNowFirstScreenNode.END.getValue()) == false) goto L17;
        this.e = true;
        b2.b(new BuyNowFirstScreenMonitor$addNodeInner$1(this));
        return;
    L17:
        BuyNowFirstScreenNode r1 = BuyNowFirstScreenNode.STANDARD_RENDER_END;
        if (CollectionsKt.listOf(new String[]{BuyNowFirstScreenNode.INITIAL.getValue(), BuyNowFirstScreenNode.REQUEST_START.getValue(), BuyNowFirstScreenNode.REQUEST_END.getValue(), BuyNowFirstScreenNode.STANDARD_RENDER_START.getValue(), r1.getValue()}).contains(r5) == false) goto L26;
        if (Intrinsics.areEqual(r5, r1.getValue()) == false) goto L22;
        i.a r0 = i.a;
        i.a(new BuyNowFirstScreenMonitor$addNodeInner$2(this, r5, r6));
        return;
    L22:
        d r2 = com.bytedance.android.ec.monitor.duration.i.a.get(d());
        if (r2 == null) goto L34;
        r2.d(r5, r6);
        return;
    L34:
        return;
    L26:
        if (Intrinsics.areEqual(r5, BuyNowFirstScreenNode.RENDER_END.getValue()) == false) goto L28;
        i.a r3 = i.a;
        i.a(new BuyNowFirstScreenMonitor$addNodeInner$3(this, r5, r6));
        return;
    L28:
        d r4 = com.bytedance.android.ec.monitor.duration.i.a.get(d());
        if (r4 == null) goto L37;
        r4.b(r5, Long.valueOf(r6));
        return;
    }

    public BuyNowFirstScreenMonitor(String r3, c r4, b r5) {
        Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");
        Intrinsics.checkNotNullParameter(r3, "bizCode");
        Intrinsics.checkNotNullParameter(r4, "schemaQuery");
        this.i = "ies_ecommerce_fe_custom_log";
        this.j = r4;
        this.k = r5;
        this.a = "BuyNowCommonFirstScreenMonitor_ies_ecommerce_fe_custom_log";
        this.b = LazyKt.lazy(new BuyNowFirstScreenMonitor$durationMonitorKey$2(this));
        this.c = new ConcurrentHashMap();
        this.h = new LinkedHashMap();
    }
}
