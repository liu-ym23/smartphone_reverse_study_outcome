package com.bytedance.kmp.ec.yata.common.utils;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class g {
    @Deprecated(message = "SDK内部API")
    public static final boolean a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getMessage();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r101, "network not available", false, 2, null) == false) goto L8;
        return true;
    L8:
        String r102 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        if (StringsKt.contains$default(r102, "Cronet", false, 2, null) != true) goto L13;
        r103 = true;
        goto L14
    }
}
