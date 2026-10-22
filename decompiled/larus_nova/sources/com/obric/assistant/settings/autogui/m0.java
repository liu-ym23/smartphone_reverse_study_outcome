package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m0 {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = l.f391936a;
        Intrinsics.checkNotNullParameter(r100, "value");
        com.obric.assistant.e.f389188a.getClass();
        com.obric.assistant.e.a r102 = com.obric.assistant.e.a(r100);
        if (r102 == null) goto L16;
        String r103 = r102.f389190a;
        if (r103 == null) goto L16;
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L16;
        return r103;
    L9:
        r104 = false;
    L16:
        return l.a().f391934a;
    }
}
