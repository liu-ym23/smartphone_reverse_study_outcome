package com.bytedance.android.shopping.sku.params.schema;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final List<Object> a(JSONArray r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        Object r3 = r5.get(r2);     // Catch: Exception -> L15
        if ((r3 instanceof JSONArray) == false) goto L8;
        r3 = a((JSONArray) r3);     // Catch: Exception -> L15
    L13:
        r0.add(r3);     // Catch: Exception -> L15
    L17:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = b((JSONObject) r3);     // Catch: Exception -> L15
        goto L13
    L11:
        if (r5.isNull(r2) == false) goto L13;
        r3 = null;
    L15:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L17
    L18:
        return r0;
    }

    public static final Map<String, Object> b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toObjectMapForSku");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();     // Catch: Exception -> L16
        Object r3 = r5.get(r2);     // Catch: Exception -> L16
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = a((JSONArray) r3);     // Catch: Exception -> L16
    L14:
        r0.put(r2, r3);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L12;
        r3 = b((JSONObject) r3);     // Catch: Exception -> L16
        goto L14
    L12:
        if (r5.isNull(r2) == false) goto L14;
        r3 = null;
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r0;
    }
}
