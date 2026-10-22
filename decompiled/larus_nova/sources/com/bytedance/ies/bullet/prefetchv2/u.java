package com.bytedance.ies.bullet.prefetchv2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class u {
    public static final Map<String, String> a(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue().toString());
        goto L7
    L9:
        return r101;
    }
}
