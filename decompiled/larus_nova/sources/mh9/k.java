package mh9;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class k {
    public static final String a(String r100) {
        if (Intrinsics.areEqual(r100, "my") == false) goto L6;
        return "my_tab";
    L6:
        if (Intrinsics.areEqual(r100, "recommend") == false) goto L9;
        return "rec_tab";
    L9:
        if (r100 == null) goto L14;
        if ((!StringsKt.isBlank(r100)) == false) goto L14;
        return r100;
    L14:
        return null;
    }
}
