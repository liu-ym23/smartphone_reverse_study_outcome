package eh9;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class o {
    public static final String a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        r100 = "voice";
    L8:
        if (r101 != null) goto L10;
    L14:
        r101 = "fallback";
    L16:
        return r100 + ':' + r101 + ':' + r102;
    L10:
        if ((!StringsKt.isBlank(r101)) == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L16;
        goto L14
    }
}
