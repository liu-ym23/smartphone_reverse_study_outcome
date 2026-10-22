package com.bytedance.ee.bear.office.export.space;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final ArrayList a(Set r4) {
        OfficeSpaceTab.Companion.getClass();
        List r0 = CollectionsKt.listOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();
        if (r4.contains((OfficeSpaceTab) r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        return new ArrayList(r1);
    }
}
