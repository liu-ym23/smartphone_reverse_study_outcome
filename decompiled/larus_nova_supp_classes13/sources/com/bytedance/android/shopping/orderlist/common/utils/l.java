package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final Map<String, Object> a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toObjectMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();     // Catch: Exception -> L16
        Object r3 = r5.get(r2);     // Catch: Exception -> L16
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = cd.a.d((JSONArray) r3);     // Catch: Exception -> L16
    L14:
        r0.put(r2, r3);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L12;
        r3 = a((JSONObject) r3);     // Catch: Exception -> L16
        goto L14
    L12:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == false) goto L14;
        r3 = null;
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r0;
    }
}
