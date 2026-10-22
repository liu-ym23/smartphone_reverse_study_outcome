package com.bytedance.kmp.ec.yata.common.protocol.utils;

import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.protocol.CopyConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    @Deprecated(message = "SDK内部API")
    public static final List<Object> a(List<? extends Object> r100, @CopyConfig int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L33;
        Object r104 = r103.next();
        boolean r105 = r104 instanceof Map;
        Object r106 = null;
        if (r105 == true) goto L7;
        boolean r107 = r104 instanceof List;
        if (r107 == true) goto L15;
        if ((r104 instanceof m) == true) goto L23;
        if (r104 != null) goto L26;
    L32:
        r102.add(r104);
        goto L4
    L26:
        if ((r104 instanceof String) == true) goto L32;
        if ((r104 instanceof Number) == true) goto L32;
        if ((r104 instanceof Boolean) == true) goto L32;
        String r108 = YaTaLog.f251436a;
        YaTaLog.b("List.deepCopy", "List.deepCopy暂不支持这种类型" + Reflection.getOrCreateKotlinClass(r104.getClass()).getSimpleName());
        goto L32
    L23:
        r102.add(((m) r104).d(r101));
        goto L4
    L15:
        if (r107 == false) goto L17;
        List r109 = (List) r104;
    L18:
        if (r109 == null) goto L20;
        r106 = a(r109, r101);
    L20:
        r102.add(r106);
        goto L4
    L17:
        r109 = null;
        goto L18
    L7:
        if (r105 == false) goto L9;
        Map r110 = (Map) r104;
    L10:
        if (r110 == null) goto L12;
        r106 = b(r110, r101);
    L12:
        r102.add(r106);
        goto L4
    L9:
        r110 = null;
        goto L10
    L33:
        return r102;
    }

    @Deprecated(message = "SDK内部API")
    public static final Map<String, Object> b(Map<String, ? extends Object> r100, @CopyConfig int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L41;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        Object r105 = r104.getValue();
        boolean r106 = r105 instanceof Map;
        Object r107 = null;
        if (r106 == true) goto L7;
        boolean r108 = r105 instanceof List;
        if (r108 == true) goto L16;
        boolean r109 = r105 instanceof m;
        if (r109 == true) goto L25;
        if (r105 != null) goto L34;
    L40:
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L34:
        if ((r105 instanceof String) == true) goto L40;
        if ((r105 instanceof Number) == true) goto L40;
        if ((r105 instanceof Boolean) == true) goto L40;
        String r110 = YaTaLog.f251436a;
        YaTaLog.b("Map.deepCopy", "Map.deepCopy暂不支持这种类型" + Reflection.getOrCreateKotlinClass(r105.getClass()).getSimpleName());
        goto L40
    L25:
        String r111 = r104.getKey();
        if (r109 == false) goto L28;
        m r112 = (m) r105;
    L29:
        if (r112 == null) goto L31;
        r107 = r112.d(r101);
    L31:
        r102.put(r111, r107);
        goto L4
    L28:
        r112 = null;
        goto L29
    L16:
        String r113 = r104.getKey();
        if (r108 == false) goto L19;
        List r114 = (List) r105;
    L20:
        if (r114 == null) goto L22;
        r107 = a(r114, r101);
    L22:
        r102.put(r113, r107);
        goto L4
    L19:
        r114 = null;
        goto L20
    L7:
        String r115 = r104.getKey();
        if (r106 == false) goto L10;
        Map r116 = (Map) r105;
    L11:
        if (r116 == null) goto L13;
        r107 = b(r116, r101);
    L13:
        r102.put(r115, r107);
        goto L4
    L10:
        r116 = null;
        goto L11
    L41:
        return r102;
    }
}
