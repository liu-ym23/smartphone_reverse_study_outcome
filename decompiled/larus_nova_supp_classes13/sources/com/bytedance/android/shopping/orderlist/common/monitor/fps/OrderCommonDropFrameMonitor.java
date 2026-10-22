package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jh.b;
import jh.c;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonDropFrameMonitor {
    public boolean a;
    public int b;
    public final c c;
    public final Map<String, Object> d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        this.c.b();
    }

    public final void b() {
        if (this.a == true) goto L5;
        return;
    L5:
        final int r0 = System.identityHashCode(this.c);
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonFpsMonitor", new OrderCommonDropFrameMonitor$stopMonitor$1(r0));
        Iterator<Map.Entry<String, Object>> r2 = this.d.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, Object> r3 = r2.next();
        this.c.a(r3.getKey(), r3.getValue());
        goto L7
    L9:
        int r4 = this.b;
        if (r4 >= 0) goto L12;
        this.c.a("dScrollY", Integer.valueOf(-r4));
        this.c.a("operator_type", 0);
    L13:
        this.c.stop();
        this.b = 0;
        this.a = false;
        return;
    L12:
        this.c.a("dScrollY", Integer.valueOf(r4));
        this.c.a("operator_type", 1);
        goto L13
    }

    public /* synthetic */ OrderCommonDropFrameMonitor(MonitorScenes r2, String r3) {
        this(r2, r3, new LinkedHashMap());
    }

    public OrderCommonDropFrameMonitor(MonitorScenes r3, String r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.d = r5;
        b.a r6 = b.c;
        q r0 = new q(r3, r4, null);
        r6.getClass();
        this.c = b.a.c(r0);
    }
}
