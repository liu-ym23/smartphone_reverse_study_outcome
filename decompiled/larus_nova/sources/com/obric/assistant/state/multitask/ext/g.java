package com.obric.assistant.state.multitask.ext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {
    public g() {
    }

    public static String a(g r100, String[] r110) {
        Intrinsics.checkNotNullParameter(r110, "parts");
        Intrinsics.checkNotNullParameter("#", "separator");
        List r101 = ArraysKt.filterNotNull(r110);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Object r111 = r103.next();
        if (((String) r111).length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r102.add(r111);
        goto L4
    L8:
        r104 = false;
        goto L9
    L12:
        return CollectionsKt.joinToString$default(r102, "#", null, null, 0, null, null, 62, null);
    }
}
