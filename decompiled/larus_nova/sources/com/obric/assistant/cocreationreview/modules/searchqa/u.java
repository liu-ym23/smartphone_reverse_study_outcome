package com.obric.assistant.cocreationreview.modules.searchqa;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class u {
    public static final String a(String r100) {
        String r101 = StringsKt.substringBefore(StringsKt.substringBefore(r100, "：", r100), ":", r100);
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L9;
        return "资料";
    L9:
        return r101;
    }
}
