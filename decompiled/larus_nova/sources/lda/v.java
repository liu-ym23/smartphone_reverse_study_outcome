package lda;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class v {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = StringsKt.trim(r100).toString();
        return new Regex("^#+\\s*").replace(r101, "");
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = StringsKt.trim(r100).toString();
        if (StringsKt.startsWith$default(r101, "omni_", false, 2, null) == false) goto L6;
        return r101;
    L6:
        return "omni_" + r101;
    }
}
