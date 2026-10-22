package com.bytedance.sdk.account.utils;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class q {
    public static final String a(String r110) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
    L30:
        return null;
    L9:
        if (StringsKt.startsWith$default(r110, "http://", false, 2, null) == false) goto L11;
    L13:
        int r101 = StringsKt.indexOf$default(r110, "://", 0, false, 6, null) + 3;
        if (r101 < r110.length()) goto L16;
        return "";
    L16:
        int r102 = StringsKt.indexOf$default(r110, '/', r101, false, 4, null);
        if (r102 != (-1)) goto L19;
        return "";
    L19:
        int r103 = StringsKt.indexOf$default(r110, '?', r102, false, 4, null);
        int r104 = StringsKt.indexOf$default(r110, '#', r102, false, 4, null);
        if (r103 == (-1)) goto L23;
        if (r104 == (-1)) goto L23;
        r103 = Math.min(r103, r104);
    L29:
        return r110.substring(r102, r103);
    L23:
        if (r103 != (-1)) goto L29;
        if (r104 == (-1)) goto L27;
        r103 = r104;
        goto L29
    L27:
        r103 = r110.length();
        goto L29
    L11:
        if (StringsKt.startsWith$default(r110, "https://", false, 2, null) == true) goto L13;
    L5:
        r100 = false;
        goto L7
    }
}
