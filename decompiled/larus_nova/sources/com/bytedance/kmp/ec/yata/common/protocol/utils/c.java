package com.bytedance.kmp.ec.yata.common.protocol.utils;

import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final Object a(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof Boolean) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof Number) == false) goto L15;
        return r100;
    L15:
        if ((r100 instanceof List) == false) goto L22;
        Iterable r101 = (Iterable) r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L18:
        if (r103.hasNext() == false) goto L20;
        r102.add(a(r103.next()));
        goto L18
    L20:
        return r102;
    L22:
        if ((r100 instanceof Map) == false) goto L29;
        Map r104 = (Map) r100;
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator r106 = r104.entrySet().iterator();
    L25:
        if (r106.hasNext() == false) goto L27;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.put(r107.getKey(), a(r107.getValue()));
        goto L25
    L27:
        return r105;
    L29:
        if ((r100 instanceof m) == true) goto L31;
        String r108 = YaTaLog.f251436a;
        YaTaLog.b("convertToBase", "convertToBase this data is not supported " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName());
        return r100;
    L31:
        return ((m) r100).f();
    }
}
