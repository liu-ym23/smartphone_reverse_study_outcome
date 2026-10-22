package com.bytedance.ee.bear.office.common.upload;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(b r2) {
        if ((r2 instanceof b.a) == false) goto L6;
        return "available";
    L6:
        if ((r2 instanceof b.c) == false) goto L9;
        return "hidden:" + ((b.c) r2).a.name();
    L9:
        if ((r2 instanceof b.C0131b) == false) goto L12;
        return "disabled:" + ((b.C0131b) r2).a.name();
    L12:
        if ((r2 instanceof b.d) == false) goto L16;
        return "permission_action:" + ((b.d) r2).a.getDenySource().getUiType();
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static String b(g0 r2) {
        if (Intrinsics.areEqual(r2, g0.b.a) == false) goto L6;
        return "root_mine";
    L6:
        if ((r2 instanceof g0.a) == false) goto L10;
        return "folder_hash=" + ((g0.a) r2).a.hashCode();
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
