package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.list.adapter.OfficeListSortFilterScene;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final g a = null;

    static {
        a = new g("", true, null, 0, null);
    }

    public static OfficeListSortFilterScene.c a(List r8, int... r9) {
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        Object r0 = r10.next();
        OfficeListSortFilterScene.c r1 = (OfficeListSortFilterScene.c) r0;
        int r2 = r9.length;
        boolean r3 = false;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        if (r9[r4] != r1.b) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L12;
        r4 = r4 + 1;
        goto L6
    L12:
        r3 = true;
        goto L14
    L10:
        r5 = false;
    L14:
        if (r3 == false) goto L4;
    L18:
        return (OfficeListSortFilterScene.c) r0;
    L16:
        r0 = null;
        goto L18
    }
}
