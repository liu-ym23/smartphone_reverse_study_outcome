package com.larksuite.framework.utils;

import android.os.Build;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p {
    public static final <T> List<T> a(Iterable<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT < 35) goto L7;
        return CollectionsKt.reversed(r100);
    L7:
        if ((r100 instanceof Collection) == true) goto L9;
    L12:
        List<T> r101 = CollectionsKt.toMutableList(r100);
        CollectionsKt.reverse(r101);
        return r101;
    L9:
        if (((Collection) r100).size() > 1) goto L12;
        return CollectionsKt.toList(r100);
    }
}
