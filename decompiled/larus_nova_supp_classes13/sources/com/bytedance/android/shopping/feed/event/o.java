package com.bytedance.android.shopping.feed.event;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toStringMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = r1.getKey().toString();
        Object r3 = r1.getValue();
        if (r3 == null) goto L8;
        String r6 = r3.toString();
    L10:
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L4;
        if (r6 == null) goto L4;
        if (com.bytedance.android.shopping.extensions.k.c(r6) == false) goto L4;
        r0.put(r2, r6);
        goto L4
    L8:
        r6 = null;
        goto L10
    L15:
        return r0;
    }
}
