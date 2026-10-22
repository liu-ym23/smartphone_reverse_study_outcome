package com.bytedance.kmp.ec.yata.common.utils;

import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    @Deprecated(message = "SDK内部API")
    public static final void a(Map<String, Object> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "incrementalData");
        Iterator<Map.Entry<String, ? extends Object>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (TypeIntrinsics.isMutableMap(r105) == true) goto L7;
        r100.put(r104, r105);
        goto L4
    L7:
        Map r106 = (Map) r105;
        Object r107 = r100.get(r104);
        if (TypeIntrinsics.isMutableMap(r107) == true) goto L9;
        r100.put(r104, r105);
        goto L4
    L9:
        a((Map) r107, r106);
        goto L4
    }
}
