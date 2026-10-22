package com.lynx.tasm.utils;

import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class j {
    public static Map<String, String> a(ReadableMap r100) {
        HashMap r101 = new HashMap();
        HashMap<String, Object> r102 = r100.asHashMap();
        Iterator<String> r103 = r102.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();
        Object r105 = r102.get(r104);
        if ((r105 instanceof List) == true) goto L7;
        if ((r105 instanceof Number) == true) goto L10;
        if (r105 == null) goto L4;
        r101.put(r104, r105.toString());
        goto L4
    L10:
        r101.put(r104, com.lynx.tasm.behavior.shadow.text.b.h(((Number) r105).doubleValue()));
        goto L4
    L7:
        r101.put(r104, android.text.TextUtils.join(",", (Iterable) r105));
        goto L4
    L13:
        return r101;
    }
}
