package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.window.shop.home.ECWindowParam;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final ConcurrentHashMap<String, String> a;

    public d(ConcurrentHashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "commonParams");
        this.a = r2;
    }

    public final void b(JSONObject r4) {
        Iterator<Map.Entry<String, String>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        r4.put(r1.getKey(), r1.getValue());
        goto L4
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.put(r2, r3);
    }

    public static void c(d r1, String r2, ECWindowParam r3, JSONObject r4, JSONObject r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "eventName");
        int r7 = ECMonitorService.b;
        if (r4 != null) goto L11;
        r4 = new JSONObject();
    L11:
        r1.b(r4);
        Unit r8 = Unit.INSTANCE;
        ECMonitorService.a.a(r2, r4, r5, null);
    }
}
