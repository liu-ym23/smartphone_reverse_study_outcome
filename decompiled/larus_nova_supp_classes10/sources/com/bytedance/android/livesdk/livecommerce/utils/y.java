package com.bytedance.android.livesdk.livecommerce.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y {
    public static Map<String, String> a(List<si2.k> r3) {
        HashMap r0 = new HashMap();
        if (r3 == null) goto L8;
        Iterator<si2.k> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        si2.k r1 = r4.next();
        r0.put(((com.bytedance.android.ec.core.utils.i) r1).a, ((com.bytedance.android.ec.core.utils.i) r1).b);
    L8:
        return r0;
    }
}
