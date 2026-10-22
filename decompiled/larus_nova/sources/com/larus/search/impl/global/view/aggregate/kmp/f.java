package com.larus.search.impl.global.view.aggregate.kmp;

import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f {
    public static final String a(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((!StringsKt.isBlank((String) r102)) == false) goto L4;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L8:
        r102 = null;
        goto L9
    }

    public static String b(String r110) {
        if (r110 != null) goto L4;
        r110 = "";
    L4:
        String r111 = StringsKt.replace$default(StringsKt.replace$default(r110, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r111.length() > 32) goto L8;
        return r111;
    L8:
        return StringsKt.take(r111, 32) + "...";
    }
}
