package com.obric.assistant.ipc;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes33.dex */
public final class o {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, String> a(Map<Object, Object> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r101 = true;
        if (r100.isEmpty() == true) goto L19;
        Iterator<Map.Entry<Object, Object>> r102 = r100.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<Object, Object> r103 = r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r104 instanceof String) == true) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == true) goto L10;
        r101 = false;
        goto L19
    L14:
        if ((r105 instanceof String) == false) goto L16;
        r106 = true;
    L19:
        if (r101 == true) goto L22;
        r100 = null;
    L22:
        if (r100 != null) goto L24;
        return null;
    L24:
        return r100;
    }
}
