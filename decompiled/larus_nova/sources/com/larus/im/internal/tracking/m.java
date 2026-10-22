package com.larus.im.internal.tracking;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes30.dex */
public final class m {
    public static final <T> int a(com.larus.im.internal.network.e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "networkResult");
        if ((r100 instanceof com.larus.im.internal.network.e.f) == false) goto L6;
        return 0;
    L6:
        if ((r100 instanceof com.larus.im.internal.network.e.g) == false) goto L9;
        return 2;
    L9:
        if ((r100 instanceof com.larus.im.internal.network.e.a) == false) goto L11;
        return 3;
    L11:
        return 1;
    }

    public static final void b(e0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, ouc.i>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, ouc.i> r103 = r102.next();
        r100.b(r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }
}
