package k31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {
    public static final String b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$formatString");
        return "needMovePlayer4StatusBar = " + r100.f501667a + ", distance = " + r100.f501668b;
    }

    public static final int a(k r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$computeMoveDistance");
        if (r101 == true) goto L5;
    L7:
        return 0;
    L5:
        if (r100.f501667a == false) goto L7;
        return r100.f501668b;
    }
}
