package com.bytedance.applet.impl;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final String a(String r5) {
        if (r5 == null) goto L21;
        String r0 = "png";
        if (StringsKt.contains$default(r5, "png", false, 2, null) == true) goto L24;
        r0 = "gif";
        if (StringsKt.contains$default(r5, "gif", false, 2, null) == true) goto L24;
        r0 = "webp";
        if (StringsKt.contains$default(r5, "webp", false, 2, null) == true) goto L24;
        if (StringsKt.contains$default(r5, "heif", false, 2, null) == false) goto L16;
        return "heic";
    L16:
        if (StringsKt.contains$default(r5, "heic", false, 2, null) == true) goto L25;
        r0 = "bmp";
        if (StringsKt.contains$default(r5, "bmp", false, 2, null) == false) goto L21;
    L25:
        return "heic";
    L24:
        return r0;
    L21:
        return "jpg";
    }
}
