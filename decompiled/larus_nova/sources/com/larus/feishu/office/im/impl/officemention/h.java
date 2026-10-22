package com.larus.feishu.office.im.impl.officemention;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class h {
    public static final String a(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L12:
        if ((true ^ r104) == true) goto L16;
        r102 = r102 + 1;
    L16:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
        goto L12
    L15:
        r103 = null;
        goto L16
    }
}
