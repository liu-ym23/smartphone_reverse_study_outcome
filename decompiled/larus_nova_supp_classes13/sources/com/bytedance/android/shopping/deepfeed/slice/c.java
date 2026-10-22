package com.bytedance.android.shopping.deepfeed.slice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements wc3.a {
    public final Map<String, Object> a;
    public wc3.c b;
    public final Map<String, Object> c;

    public static final class a {
    }

    static {
    }

    public final void b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.a);
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(this.c);
        r0.put("state", r1);
        wc3.c r2 = this.b;
        if (r2 == null) goto L6;
        r2.updateData(r0);
        return;
    }

    @Override // wc3.a
    public final void a(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        e(r2);
        b();
    }

    public final void c(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Iterator<T> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        String r1 = (String) r0.next();
        Object r2 = r5.get(r1);
        if (r2 == null) goto L4;
        if ((!Intrinsics.areEqual(r1, "state")) == true) goto L10;
        if ((r2 instanceof Map) == true) goto L14;
        r2 = null;
    L14:
        Map<? extends String, ? extends Object> r3 = (Map) r2;
        if (r3 == null) goto L4;
        this.c.putAll(r3);
        goto L4
    L10:
        this.a.put(r1, r5.get(r1));
        goto L4
    }

    public final void d(com.bytedance.android.shopping.deepfeed.slice.a r2) {
        Intrinsics.checkNotNullParameter(r2, "slcData");
        this.b = r2;
    }

    public final void e(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.c.putAll(r2);
    }

    public c(Map<String, Object> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "drawData");
        Intrinsics.checkNotNullParameter(r4, "firstBindState");
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        this.c = r1;
        r0.putAll(r3);
        Object r5 = r3.get("state");
        if ((r5 instanceof Map) == true) goto L5;
        r5 = null;
    L5:
        Map r6 = (Map) r5;
        if (r6 == null) goto L8;
        r1.putAll(r6);
    L8:
        r1.putAll(r4);
    }
}
