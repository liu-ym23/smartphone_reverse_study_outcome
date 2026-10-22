package com.bytedance.sdk.account.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class h {
    public static final String a(List<com.ss.android.token.o> r100, String r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(((com.ss.android.token.o) r103).f449775a, r101, true) == false) goto L4;
    L9:
        com.ss.android.token.o r104 = (com.ss.android.token.o) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.f449776b;
    L8:
        r103 = null;
        goto L9
    }
}
