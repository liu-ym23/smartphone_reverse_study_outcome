package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.list.adapter.OfficeListSortFilterScene;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f235949a = null;

    static {
        f235949a = new g("", true, null, 0, null);
    }

    public static OfficeListSortFilterScene.c a(List r100, int... r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        OfficeListSortFilterScene.c r104 = (OfficeListSortFilterScene.c) r103;
        int r105 = r101.length;
        boolean r106 = false;
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L14;
        if (r101[r107] != r104.f235673b) goto L10;
        boolean r108 = true;
    L11:
        if (r108 == true) goto L12;
        r107 = r107 + 1;
        goto L6
    L12:
        r106 = true;
        goto L14
    L10:
        r108 = false;
    L14:
        if (r106 == false) goto L4;
    L18:
        return (OfficeListSortFilterScene.c) r103;
    L16:
        r103 = null;
        goto L18
    }
}
