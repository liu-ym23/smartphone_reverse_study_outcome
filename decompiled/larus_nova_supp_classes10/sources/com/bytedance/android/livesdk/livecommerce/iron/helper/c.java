package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final Map<String, String> a;
    public final Map<String, Pair<String, String>> b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public static void c(String r3, Pair r4) {
        sg2.v r0 = new sg2.v("schema_report", com.bytedance.android.ec.common.api.jump.model.b.a);
        r0.c(LocationMonitorConst.LOCATION, (String) r4.getFirst());
        r0.c("business", "live_purchase_refactor");
        r0.c("in_schema", r3);
        r0.c("out_schema", (String) r4.getSecond());
        r0.i(null);
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        if (this.b.containsKey(r2) == false) goto L7;
        Pair<String, String> r4 = this.b.remove(r2);
        if (r4 == null) goto L9;
        c(r3, r4);
        return;
    L9:
        return;
    L7:
        this.a.put(r2, r3);
    }

    public final void b(String r2, Pair<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "schema");
        if (this.a.containsKey(r2) == false) goto L7;
        String r4 = this.a.remove(r2);
        if (r4 == null) goto L9;
        c(r4, r3);
        return;
    L9:
        return;
    L7:
        this.b.put(r2, r3);
    }
}
