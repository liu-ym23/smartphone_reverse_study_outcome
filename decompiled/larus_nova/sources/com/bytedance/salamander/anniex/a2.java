package com.bytedance.salamander.anniex;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a2 {
    public static final Map<String, Integer> a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = com.bytedance.anniex.bd.foundation.impl.o.k(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        com.bytedance.rts.foundation.m.e(r101, r103, Integer.valueOf(com.bytedance.anniex.bd.foundation.impl.o.f(r100, r103, 0)));
        goto L4
    L6:
        return r101;
    }
}
