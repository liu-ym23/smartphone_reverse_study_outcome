package com.larus.im.internal.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class n {
    public static final JSONObject a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        if (StringsKt.isBlank(r103.getKey()) == true) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        return r101;
    }

    public static final Map<String, String> b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L20;
        String r103 = r102.next();
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L4;
        Object r105 = r100.opt(r103);
        if (r105 == null) goto L4;
        String r106 = r105.toString();
        if (r106 == null) goto L4;
        r101.put(r103, r106);
        goto L4
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
        goto L12
    L20:
        return r101;
    }
}
