package com.bytedance.ee.bear.more.view3;

import com.bytedance.ee.bear.more.protocol3.k;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final Map<Class<?>, Integer> b = null;
    public k a;

    public c() {
    }

    static {
        b = new HashMap();
    }

    public static int a(k r2) {
        Class<?> r3 = r2.getClass();
        Map<Class<?>, Integer> r0 = b;
        Integer r1 = (Integer) ((HashMap) r0).get(r3);
        if (r1 != null) goto L6;
        r1 = Integer.valueOf(((HashMap) r0).size() + 1);
        ((HashMap) r0).put(r3, r1);
    L6:
        return r1.intValue();
    }
}
