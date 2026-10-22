package com.relax.relaxui.value;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class JNIDataConverter {
    public JNIDataConverter() {
    }

    public static void parseJavaOnlyArrayNonNull(JavaOnlyArray r100, List<Object> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isEmpty() == true) goto L29;
        Iterator<Object> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L30;
        Object r103 = r102.next();
        if ((r103 instanceof Map) == true) goto L11;
        if ((r103 instanceof List) == true) goto L14;
        if (r103 == null) goto L8;
        r100.add(r103);
        goto L8
    L14:
        JavaOnlyArray r104 = new JavaOnlyArray();
        parseJavaOnlyArrayNonNull(r104, (List) r103);
        r100.add(r104);
        goto L8
    L11:
        JavaOnlyMap r105 = new JavaOnlyMap();
        parseJavaOnlyMapNonNull(r105, (Map) r103);
        r100.add(r105);
        goto L8
    L30:
        return;
    }

    public static void parseJavaOnlyMapNonNull(JavaOnlyMap r100, Map<String, Object> r101) {
        Iterator<String> r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        Object r104 = r101.get(r103);
        if ((r104 instanceof Map) == true) goto L7;
        if ((r104 instanceof List) == true) goto L10;
        if (r104 == null) goto L4;
        r100.put(r103, r104);
        goto L4
    L10:
        JavaOnlyArray r105 = new JavaOnlyArray();
        parseJavaOnlyArrayNonNull(r105, (List) r104);
        r100.put(r103, r105);
        goto L4
    L7:
        JavaOnlyMap r106 = new JavaOnlyMap();
        parseJavaOnlyMapNonNull(r106, (Map) r104);
        r100.put(r103, r106);
        goto L4
    }
}
