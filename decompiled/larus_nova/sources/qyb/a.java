package qyb;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
