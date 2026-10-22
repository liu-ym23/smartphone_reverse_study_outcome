package com.bytedance.kmp.ec.yata.common.protocol.data;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public static final boolean a(aa6.a r100, String r101, Map<String, ? extends Object> r102) {
        if (r102 != null) goto L5;
        return false;
    L5:
        Object r103 = r102.get("enable");
        if ((r103 instanceof Boolean) == false) goto L8;
        Boolean r104 = (Boolean) r103;
    L9:
        if (r104 != null) goto L11;
    L54:
        return false;
    L11:
        if (r104.booleanValue() == true) goto L13;
        return false;
    L13:
        Object r105 = r102.get("conditions");
        if ((r105 instanceof List) == false) goto L16;
        List r106 = (List) r105;
    L17:
        List r107 = r106;
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == false) goto L26;
        return true;
    L26:
        Iterator r109 = r106.iterator();
    L28:
        if (r109.hasNext() == false) goto L54;
        Map r110 = (Map) r109.next();
        if (r110 == null) goto L32;
        Object r111 = r110.get("source");
    L34:
        if ((r111 instanceof String) == false) goto L36;
        String r112 = (String) r111;
    L38:
        if (Intrinsics.areEqual(r112, r100.f2347a) == false) goto L28;
        Object r113 = r110.get("triggers");
        if ((r113 instanceof List) == false) goto L42;
        List r114 = (List) r113;
    L43:
        if (r114 == null) goto L28;
        Iterator r115 = r114.iterator();
    L46:
        if (r115.hasNext() == false) goto L28;
        String r116 = (String) r115.next();
        if (Intrinsics.areEqual(r116, "*") == true) goto L49;
        if (Intrinsics.areEqual(r116, r101) == false) goto L46;
        if (r116 == null) goto L46;
        return true;
    L49:
        return true;
    L42:
        r114 = null;
        goto L43
    L36:
        r112 = null;
        goto L38
    L32:
        r111 = null;
        goto L34
    L20:
        if (r107.isEmpty() == true) goto L23;
        r108 = false;
        goto L24
    L16:
        r106 = null;
        goto L17
    L8:
        r104 = null;
        goto L9
    }
}
