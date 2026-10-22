package hda;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c1 {
    public static final String a(String r100) {
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L8;
        if ((!StringsKt.isBlank(r101)) == false) goto L8;
        return r101;
    L8:
        return null;
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b1.a(r100);
    }

    public static final String c(String r100) {
        if (r100 == null) goto L10;
        String r101 = b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        return null;
    L9:
        return r101;
    L10:
        return null;
    }
}
