package gb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final boolean a(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, 0) == false) goto L8;
    L20:
        return false;
    L8:
        if (Intrinsics.areEqual(r100, "") == true) goto L20;
        if ((r100 instanceof Number) == false) goto L13;
    L19:
        return true;
    L13:
        if ((r100 instanceof String) == true) goto L19;
        if ((r100 instanceof Boolean) == false) goto L19;
        return ((Boolean) r100).booleanValue();
    }
}
