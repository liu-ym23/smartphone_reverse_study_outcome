package com.bytedance.locallife.groupon.basic.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final Map<String, Object> a(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<?, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<?, ?> r103 = r102.next();
        Object r104 = r103.getKey();
        if ((r104 instanceof String) == false) goto L4;
        Object r105 = r103.getValue();
        if (r105 == null) goto L4;
        r101.put(r104, r105);
        goto L4
    L12:
        return r101;
    }
}
