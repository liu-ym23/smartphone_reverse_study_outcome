package com.bytedance.ee.bear.office.list.adapter;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w {
    public static final OfficeLongPressMenuItemState a(z r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100, z.d.f235884a) == false) goto L6;
        return OfficeLongPressMenuItemState.VISIBLE;
    L6:
        if (Intrinsics.areEqual(r100, z.b.f235882a) == false) goto L9;
        return OfficeLongPressMenuItemState.HIDDEN;
    L9:
        if ((r100 instanceof z.c) == false) goto L12;
        return OfficeLongPressMenuItemState.LOADING_BLOCKED;
    L12:
        if ((r100 instanceof z.a) == false) goto L16;
        return OfficeLongPressMenuItemState.DISABLED;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
