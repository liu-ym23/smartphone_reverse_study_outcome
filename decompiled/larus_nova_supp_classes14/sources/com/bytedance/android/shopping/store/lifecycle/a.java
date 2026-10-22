package com.bytedance.android.shopping.store.lifecycle;

import com.bytedance.android.shopping.store.home.s;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Map<Long, m> a = null;
    public static final Map<Long, s> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    public static m a(Long r1) {
        return (m) ((LinkedHashMap) a).get(r1);
    }

    public static s b(Long r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Map<Long, s> r0 = b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.get(r3) != null) goto L9;
        r0.put(r3, new s());
    L9:
        return (s) r1.get(r3);
    }
}
