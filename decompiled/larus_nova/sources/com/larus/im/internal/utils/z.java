package com.larus.im.internal.utils;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z {
    public static final he9.a.C6134a a(he9.c r100, byte[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r103 = false;
        if (r101 == null) goto L17;
        Integer r104 = Integer.valueOf(r102);
        if (r104.intValue() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.intValue();
    L14:
        List r107 = ArraysKt.take(r101, r106);
        if (r107 == null) goto L17;
        byte[] r108 = CollectionsKt.toByteArray(r107);
    L18:
        if (r108 != null) goto L20;
        return null;
    L20:
        if (r108.length != 0) goto L22;
        r103 = true;
    L22:
        if (r103 == false) goto L25;
        return null;
    L25:
        return r100.a(r108);
    L13:
        r106 = r101.length;
        goto L14
    L7:
        r105 = false;
    L17:
        r108 = null;
        goto L18
    }
}
