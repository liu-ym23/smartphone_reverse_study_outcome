package com.larus.im.internal.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w {
    public static final int a(com.larus.im.service.audio.v r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof v) == false) goto L5;
        v r101 = (v) r100;
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.L2();
    L5:
        r101 = null;
        goto L6
    }
}
