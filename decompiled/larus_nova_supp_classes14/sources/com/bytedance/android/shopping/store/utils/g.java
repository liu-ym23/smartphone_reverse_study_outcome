package com.bytedance.android.shopping.store.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final Map<String, String> b(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toNullableStrMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, ? extends Object> r1 = r4.next();
        String r2 = r1.getKey();
        Object r5 = r1.getValue();
        if (r5 == null) goto L8;
        String r6 = r5.toString();
    L9:
        r0.put(r2, r6);
        goto L4
    L8:
        r6 = null;
        goto L9
    L10:
        return r0;
    }

    public static final void a(Map<String, Object> r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$putIfNotNull");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == null) goto L6;
        r1.put(r2, r3);
        return;
    }
}
