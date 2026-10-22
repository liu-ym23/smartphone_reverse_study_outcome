package qx6;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class t {
    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (StringsKt.startsWith$default(r100, "$q$", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r100.length() <= 3) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (StringsKt.startsWith$default(r100, "mergekey_", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r100.length() <= 9) goto L9;
        return true;
    L9:
        return false;
    }
}
