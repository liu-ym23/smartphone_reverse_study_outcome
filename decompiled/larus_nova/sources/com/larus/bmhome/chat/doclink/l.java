package com.larus.bmhome.chat.doclink;

import com.larus.utils.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class l {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = StringsKt.trim(r100).toString();
        if (StringsKt.isBlank(r101) == false) goto L7;
        return "";
    L7:
        if (y0.e(r101) == false) goto L10;
        return r101;
    L10:
        return "https://" + r101;
    }
}
