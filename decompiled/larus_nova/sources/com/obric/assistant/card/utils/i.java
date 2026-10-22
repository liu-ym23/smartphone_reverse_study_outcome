package com.obric.assistant.card.utils;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public static final String a(String r100, String r101, char r102) {
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
    L23:
        if (r101 != null) goto L26;
        r101 = "";
    L26:
        return StringsKt.trim(r101).toString();
    L11:
        if (StringsKt.isBlank(r100) == true) goto L23;
        if (r101 != null) goto L15;
    L16:
        r103 = true;
    L17:
        if (r103 == true) goto L28;
        if (StringsKt.isBlank(r101) == true) goto L28;
        return StringsKt.trim(r100).toString() + r102 + StringsKt.trim(r101).toString();
    L28:
        return StringsKt.trim(r100).toString();
    L15:
        if (r101.length() != 0) goto L17;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
