package com.bytedance.rts.kmp.foundation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    @RTSHiddenFromObjC
    public static final Object b(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("uid", "key");
        int r2 = g.a;
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter("uid", "key");
        return a(r3.get("uid"), 0, new f());
    }

    public static final Object a(Object r4, int r5, Function1<Object, ? extends Object> r6) {
        if (r5 != 0) goto L6;
        return r6.invoke(r4);
    L6:
        if ((r4 instanceof Iterable) == false) goto L9;
        List r7 = CollectionsKt.toList((Iterable) r4);
    L11:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        Object r2 = a(r8.next(), r5 - 1, r6);
        if (r2 == null) goto L16;
        r0.add(r2);
        goto L13
    L16:
        return null;
    L18:
        return r0;
    L9:
        if ((r4 instanceof Object[]) == false) goto L19;
        r7 = ArraysKt.toList((Object[]) r4);
        goto L11
    L19:
        return null;
    }

    @RTSHiddenFromObjC
    public static final Object c(Map<String, ? extends Object> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = g.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        return a(r2.get(r3), r4, new e());
    }
}
