package com.ss.android.lark.flow.threadwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class q {
    public static final String a(String r100) {
        if (r100 == null) goto L13;
        boolean r101 = false;
        if (r100.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
    L11:
        if (r101 == false) goto L13;
        return r100;
    L9:
        if (Intrinsics.areEqual(r100, "null") == true) goto L11;
        r101 = true;
        goto L11
    L6:
        r102 = false;
    L13:
        return null;
    }
}
