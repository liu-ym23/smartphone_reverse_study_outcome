package vg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L9:
        return "";
    L8:
        if (Intrinsics.areEqual("null", r100) == true) goto L9;
        return r100;
    L5:
        r101 = false;
        goto L6
    }
}
