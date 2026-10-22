package com.bytedance.android.shopping.commentv3.event_chain;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements h {
    public final ic3.d a;

    public e() {
        this(0);
    }

    public final void c(Map<String, ? extends Object> r1) {
    }

    public e(int r1) {
        this.a = null;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "btm");
        Intrinsics.checkNotNullParameter(r2, "btm");
    }

    public final void a(String r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        ic3.d r1 = this.a;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "extra");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r1.a);
        r0.putAll(r1.b);
        r0.put("tab_id", String.valueOf(r1.e.e.b.f()));
        r0.put("tag_type", String.valueOf(r1.e.e.b.g()));
        Iterator<Map.Entry<String, Object>> r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, Object> r2 = r7.next();
        r0.put(r2.getKey(), String.valueOf(r2.getValue()));
        goto L6
    L8:
        new ic3.a(r5, r0).post(null, null);
        return;
    }
}
