package com.bytedance.android.shopping.collect.monitor.duration;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataFirstScreenDurationMonitor {
    public final String a;
    public final ConcurrentHashMap<CollectYataFirstScreenPoint, Long> b;
    public final Lazy c;
    public boolean d;
    public boolean e;
    public final String f;
    public final JSONObject g;

    public CollectYataFirstScreenDurationMonitor(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "baseParams");
        this.f = r3;
        this.g = r4;
        i r5 = i.a;
        String r0 = r5.create("ec_perf_duration_collect");
        this.a = r0;
        this.b = new ConcurrentHashMap();
        this.c = LazyKt.lazy(CollectYataFirstScreenDurationMonitor$extraParams$2.INSTANCE);
        d r6 = r5.get(r0);
        if (r6 == null) goto L8;
        Iterator<String> r7 = r4.keys();
    L6:
        if (r7.hasNext() == false) goto L10;
        String r1 = r7.next();
        r6.b(r1, this.g.get(r1));
        goto L6
    L10:
        return;
    }

    public static void a(final CollectYataFirstScreenDurationMonitor r3, final CollectYataFirstScreenPoint r4) {
        Intrinsics.checkNotNullParameter(r4, "point");
        final Long r2 = null;
        CollectRunCatchExtKt.a(r3.f, "CollectYataFirstScreenDurationMonitor-addPointSafely", new CollectYataFirstScreenDurationMonitor$addPointSafely$1(r3, r4, r2));
    }
}
