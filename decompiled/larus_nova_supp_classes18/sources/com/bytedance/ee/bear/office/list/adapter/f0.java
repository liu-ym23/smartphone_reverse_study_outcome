package com.bytedance.ee.bear.office.list.adapter;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 {
    public static final String a(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof g0.a) == false) goto L5;
        g0.a r2 = (g0.a) r1;
    L6:
        if (r2 == null) goto L10;
        String r3 = r2.a;
        if (r3 == null) goto L10;
        return r3;
    L10:
        return com.bytedance.ee.bear.more.office.f.c();
    L5:
        r2 = null;
        goto L6
    }

    public static final OfficeLongPressMenuItemState b(g0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1, g0.c.a) == false) goto L6;
        return OfficeLongPressMenuItemState.VISIBLE;
    L6:
        if (Intrinsics.areEqual(r1, g0.b.a) == false) goto L9;
        return OfficeLongPressMenuItemState.HIDDEN;
    L9:
        if ((r1 instanceof g0.a) == false) goto L13;
        return OfficeLongPressMenuItemState.DISABLED;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
