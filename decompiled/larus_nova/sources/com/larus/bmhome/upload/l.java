package com.larus.bmhome.upload;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class l {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = "h264";
        if (StringsKt.contains$default(r100, "avc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "h264", false, 2, null) == true) goto L18;
        r101 = "h265";
        if (StringsKt.contains$default(r100, "hevc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "h265", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, "dolby-vision", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r100, '/', false, 2, null) == true) goto L20;
        return r100;
    L20:
        return StringsKt.substringAfterLast$default(r100, '/', null, 2, null);
    L18:
        return r101;
    }
}
