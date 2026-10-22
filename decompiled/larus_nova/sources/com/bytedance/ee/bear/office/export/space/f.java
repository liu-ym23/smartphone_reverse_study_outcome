package com.bytedance.ee.bear.office.export.space;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class f {
    public static final ArrayList a(Set r100) {
        OfficeSpaceTab.Companion.getClass();
        List r101 = CollectionsKt.listOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        if (r100.contains((OfficeSpaceTab) r104) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        return new ArrayList(r102);
    }
}
