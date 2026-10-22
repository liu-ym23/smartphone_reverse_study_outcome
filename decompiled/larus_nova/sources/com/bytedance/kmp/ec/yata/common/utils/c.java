package com.bytedance.kmp.ec.yata.common.utils;

import kotlin.Deprecated;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    @Deprecated(message = "SDK内部工具")
    public static final String a(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        String r101 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r101 != null) goto L9;
        return "unknown";
    L9:
        return r101;
    }
}
