package mm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final boolean a(Integer r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.intValue() == 0) goto L7;
        return false;
    }

    public static final boolean b(Long r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.longValue() == 0) goto L7;
        return false;
    }

    public static final String c(Boolean r100, Object r101, Object r102) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        return String.valueOf(r101);
    L6:
        return String.valueOf(r102);
    }
}
