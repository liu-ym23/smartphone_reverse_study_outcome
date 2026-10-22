package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class h {
    public static final List a(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();
        if (((FlowSearchData) r104).f243280b != 1) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L10:
        List r105 = CollectionsKt.take(r101, 3);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r100.iterator();
    L12:
        if (r107.hasNext() == false) goto L23;
        Object r108 = r107.next();
        int r109 = ((FlowSearchData) r108).f243280b;
        if (r109 != 110) goto L16;
    L19:
        boolean r110 = true;
    L20:
        if (r110 == false) goto L12;
        r106.add(r108);
        goto L12
    L16:
        if (r109 == 107) goto L19;
        r110 = false;
        goto L20
    L23:
        return CollectionsKt.plus(r105, r106);
    }
}
