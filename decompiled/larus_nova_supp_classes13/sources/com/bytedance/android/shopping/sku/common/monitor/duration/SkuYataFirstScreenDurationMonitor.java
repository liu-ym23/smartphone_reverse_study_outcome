package com.bytedance.android.shopping.sku.common.monitor.duration;

import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import hd3.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataFirstScreenDurationMonitor {
    public final String a;
    public final ConcurrentHashMap<SkuYataFirstScreenPoint, Long> b;
    public final Lazy c;
    public boolean d;
    public boolean e;
    public Object f;
    public d g;
    public final String h;
    public final JSONObject i;

    public SkuYataFirstScreenDurationMonitor(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "baseParams");
        this.h = r3;
        this.i = r4;
        i r5 = i.a;
        String r0 = r5.create("ec_perf_duration_sku_panel");
        this.a = r0;
        this.b = new ConcurrentHashMap();
        this.c = LazyKt.lazy(SkuYataFirstScreenDurationMonitor$extraParams$2.INSTANCE);
        com.bytedance.android.ec.monitor.duration.d r6 = r5.get(r0);
        if (r6 == null) goto L8;
        Iterator<String> r7 = r4.keys();
    L6:
        if (r7.hasNext() == false) goto L10;
        String r1 = r7.next();
        r6.b(r1, this.i.get(r1));
        goto L6
    L10:
        return;
    }

    public static void b(final SkuYataFirstScreenDurationMonitor r3, final SkuYataFirstScreenPoint r4) {
        Intrinsics.checkNotNullParameter(r4, "point");
        final Long r2 = null;
        SkuRunCatchExtKt.a(r3.h, "SkuYataFirstScreenDurationMonitor-addPointSafely", new SkuYataFirstScreenDurationMonitor$addPointSafely$1(r3, r4, r2));
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        ((JSONObject) this.c.getValue()).put(r2, r3);
    }
}
