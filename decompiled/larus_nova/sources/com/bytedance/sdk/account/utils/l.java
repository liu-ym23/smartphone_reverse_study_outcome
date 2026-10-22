package com.bytedance.sdk.account.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class l {
    public static final boolean a(String r100) {
        if (r100 == null) goto L5;
        k r101 = new k(r100);
    L7:
        if (Intrinsics.areEqual(r101, null) == false) goto L9;
    L12:
        return true;
    L9:
        if (StringsKt.isBlank(r100) == true) goto L12;
        return false;
    L5:
        r101 = null;
        goto L7
    }
}
