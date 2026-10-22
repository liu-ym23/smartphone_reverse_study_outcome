package hga;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d {
    public static final String a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return "";
    L9:
        return "***" + StringsKt.takeLast(r100, 4);
    L5:
        r101 = false;
        goto L6
    }
}
