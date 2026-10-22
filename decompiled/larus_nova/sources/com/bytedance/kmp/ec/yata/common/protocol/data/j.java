package com.bytedance.kmp.ec.yata.common.protocol.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {
    public static final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, List<String>> r101 = r100.h();
        if (r101 == null) goto L18;
        Iterator<Map.Entry<String, List<String>>> r102 = r101.entrySet().iterator();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r103 = r102.next();
        if (Intrinsics.areEqual(r103.getKey(), "null_null") == false) goto L12;
        r102.remove();
    L12:
        Iterator<String> r104 = r103.getValue().iterator();
    L14:
        if (r104.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r104.next(), "null_null") == false) goto L14;
        r104.remove();
        goto L14
    L26:
        return;
    }

    public static final void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        String r103 = r100.g();
        if (r103 == null) goto L5;
        r102.add(r103);
    L5:
        List<String> r104 = r100.e();
        if (r104 == null) goto L8;
        r102.addAll(r104);
    L8:
        List<String> r105 = r100.c();
        if (r105 == null) goto L11;
        r102.addAll(r105);
    L11:
        Iterator r106 = r102.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        c(r100, (String) r106.next(), r101);
        goto L13
    L15:
        Map<String, List<String>> r107 = r100.h();
        if (r107 == null) goto L25;
        Iterator<Map.Entry<String, List<String>>> r108 = r107.entrySet().iterator();
        if (r108 != null) goto L21;
        return;
    L21:
        if (r108.hasNext() == false) goto L33;
        if (r101.contains(r108.next().getKey()) == true) goto L21;
        r108.remove();
        goto L21
    L33:
        return;
    }

    public static final void c(i r100, String r101, List<String> r102) {
        if (r101 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        ((ArrayList) r102).add(r101);
        Map<String, List<String>> r104 = r100.h();
        if (r104 == null) goto L13;
        List<String> r105 = r104.get(r101);
    L14:
        if (r105 == null) goto L19;
        Iterator<T> r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        c(r100, (String) r106.next(), r102);
        goto L17
    L21:
        return;
    L19:
        return;
    L13:
        r105 = null;
        goto L14
    L4:
        if (r101.length() == 0) goto L7;
        r103 = false;
        goto L8
    }
}
