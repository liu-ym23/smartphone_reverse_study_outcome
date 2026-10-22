package com.bytedance.ee.bear.list.office.longpress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    static {
    }

    public static boolean a(oj5.c r1) {
        Intrinsics.checkNotNullParameter(r1, "moreInfo");
        if (b(r1, 2) == false) goto L5;
    L12:
        return true;
    L5:
        if (b(r1, 22) == true) goto L12;
        if (b(r1, 3) == true) goto L12;
        if (b(r1, 30) == true) goto L12;
        return false;
    }

    public static boolean b(oj5.c r1, int r2) {
        if (r1.getType() != r2) goto L5;
    L8:
        return true;
    L5:
        if (r1.i() == r2) goto L8;
        return false;
    }
}
