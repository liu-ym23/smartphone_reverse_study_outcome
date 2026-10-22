package com.larus.account.saas.security.internal;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f {
    public f() {
    }

    public static String a(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L12:
        if ((true ^ r104) == true) goto L19;
        r102 = r102 + 1;
        goto L3
    L19:
        return r103;
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
        goto L12
    L15:
        return null;
    }
}
