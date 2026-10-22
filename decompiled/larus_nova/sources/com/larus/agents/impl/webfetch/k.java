package com.larus.agents.impl.webfetch;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class k {
    public static final String a(String r110) {
        if (r110 != null) goto L4;
        r110 = "";
    L4:
        String r111 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r110, 128), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r111.length() != 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L11;
        return "missing";
    L11:
        return r111;
    L7:
        r100 = false;
        goto L8
    }
}
