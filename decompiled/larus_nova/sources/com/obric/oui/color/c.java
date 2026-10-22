package com.obric.oui.color;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static final a[] a(b[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        b r104 = r100[r103];
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r101.add(new a(r104.f399491a, r104.f399492b));
        r103 = r103 + 1;
        goto L3
    L5:
        Object[] r105 = r101.toArray(new a[0]);
        if (r105 == null) goto L10;
        return (a[]) r105;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final b[] b(a[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        a r104 = r100[r103];
        r104.getClass();
        r101.add(new b(r104.f399488a, r104.f399489b));
        r103 = r103 + 1;
        goto L3
    L5:
        Object[] r105 = r101.toArray(new b[0]);
        if (r105 == null) goto L10;
        return (b[]) r105;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
