package com.bytedance.android.shopping.commentv3.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static Map a(Map r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r5.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if ((r2 instanceof String) == false) goto L7;
        r0.put(r2, r3);
        goto L4
    L7:
        return null;
    L10:
        return r0;
    }
}
