package s21;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "str");
        if (r100.length() > r101) goto L5;
        return r100;
    L5:
        return r100.substring(0, r101 - 1) + "...";
    }
}
