package com.bytedance.ee.bear.list.office.longpress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q {
    static {
    }

    public static boolean a(oj5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "moreInfo");
        if (b(r100, 2) == false) goto L5;
    L12:
        return true;
    L5:
        if (b(r100, 22) == true) goto L12;
        if (b(r100, 3) == true) goto L12;
        if (b(r100, 30) == true) goto L12;
        return false;
    }

    public static boolean b(oj5.c r100, int r101) {
        if (r100.getType() != r101) goto L5;
    L8:
        return true;
    L5:
        if (r100.i() == r101) goto L8;
        return false;
    }
}
