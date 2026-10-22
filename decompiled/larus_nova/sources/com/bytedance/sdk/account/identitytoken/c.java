package com.bytedance.sdk.account.identitytoken;

import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import wqa.i;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static final String a(List r100, String r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(((i) r103).f560775a, r101, true) == false) goto L4;
    L9:
        i r104 = (i) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.f560776b;
    L8:
        r103 = null;
        goto L9
    }
}
