package com.bytedance.android.shopping.hybrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final List<Object> a(JSONArray r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toList");
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L8;
        r3 = a((JSONArray) r3);
    L10:
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONObject) == false) goto L10;
        r3 = b((JSONObject) r3);
        goto L10
    L11:
        return r0;
    }

    public static final Map<String, Object> b(JSONObject r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = a((JSONArray) r3);
    L11:
        r0.put(r2, r3);
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = b((JSONObject) r3);
        goto L11
    L12:
        return r0;
    }
}
