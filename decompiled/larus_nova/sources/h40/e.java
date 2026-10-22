package h40;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$errorMsg");
        String r101 = r100.getMessage();
        if (r101 == null) goto L13;
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        return r101;
    L7:
        r102 = false;
    L13:
        return r100.toString();
    }
}
