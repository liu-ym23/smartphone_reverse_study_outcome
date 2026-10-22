package yn6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "domainStr");
        if (Intrinsics.areEqual(r100, "") == false) goto L6;
        return false;
    L6:
        return true;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyStr");
        if (Intrinsics.areEqual(r100, "") == false) goto L6;
        return false;
    L6:
        return true;
    }
}
