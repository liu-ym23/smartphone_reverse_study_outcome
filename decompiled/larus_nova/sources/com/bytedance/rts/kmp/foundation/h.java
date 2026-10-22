package com.bytedance.rts.kmp.foundation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h {
    @RTSHiddenFromObjC
    public static final Object b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("uid", "key");
        int r101 = g.f267611a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter("uid", "key");
        return a(r100.get("uid"), 0, new f());
    }

    public static final Object a(Object r100, int r101, Function1<Object, ? extends Object> r102) {
        if (r101 != 0) goto L6;
        return r102.invoke(r100);
    L6:
        if ((r100 instanceof Iterable) == false) goto L9;
        List r103 = CollectionsKt.toList((Iterable) r100);
    L11:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L18;
        Object r106 = a(r105.next(), r101 - 1, r102);
        if (r106 == null) goto L16;
        r104.add(r106);
        goto L13
    L16:
        return null;
    L18:
        return r104;
    L9:
        if ((r100 instanceof Object[]) == false) goto L19;
        r103 = ArraysKt.toList((Object[]) r100);
        goto L11
    L19:
        return null;
    }

    @RTSHiddenFromObjC
    public static final Object c(Map<String, ? extends Object> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = g.f267611a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        return a(r100.get(r101), r102, new e());
    }
}
