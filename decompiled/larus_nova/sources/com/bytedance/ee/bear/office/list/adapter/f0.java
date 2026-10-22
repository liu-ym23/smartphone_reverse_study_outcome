package com.bytedance.ee.bear.office.list.adapter;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 {
    public static final String a(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof g0.a) == false) goto L5;
        g0.a r101 = (g0.a) r100;
    L6:
        if (r101 == null) goto L10;
        String r102 = r101.f235767a;
        if (r102 == null) goto L10;
        return r102;
    L10:
        return com.bytedance.ee.bear.more.office.f.c();
    L5:
        r101 = null;
        goto L6
    }

    public static final OfficeLongPressMenuItemState b(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100, g0.c.f235769a) == false) goto L6;
        return OfficeLongPressMenuItemState.VISIBLE;
    L6:
        if (Intrinsics.areEqual(r100, g0.b.f235768a) == false) goto L9;
        return OfficeLongPressMenuItemState.HIDDEN;
    L9:
        if ((r100 instanceof g0.a) == false) goto L13;
        return OfficeLongPressMenuItemState.DISABLED;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
