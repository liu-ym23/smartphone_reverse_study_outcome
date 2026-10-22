package com.bytedance.locallife.groupon.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final Integer a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof String) == false) goto L6;
        return StringsKt.toIntOrNull((String) r100);
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return (Integer) r100;
    L9:
        if ((r100 instanceof Number) == true) goto L15;
        return null;
    L15:
        return Integer.valueOf(((Number) r100).intValue());
    }
}
