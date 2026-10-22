package qz9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final String a(zo8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.b();
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r101.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L16;
        String r104 = r100.a();
        if (r104 == null) goto L15;
        r102 = r104;
    L15:
        return r102;
    L16:
        return r101;
    L8:
        r103 = false;
        goto L9
    }
}
