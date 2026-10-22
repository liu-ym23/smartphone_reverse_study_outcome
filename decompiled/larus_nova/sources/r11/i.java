package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i {
    public static final boolean a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLiveCoreCapEnable");
        if (r100.getEnable() == true) goto L5;
        return false;
    L5:
        if (r100.F7() == false) goto L13;
        float r101 = 0;
        if (r100.z8() > r101) goto L9;
        return false;
    L9:
        if (r100.q6() <= r101) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public static final boolean b(h.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isValid");
        if (r100.getW() > 0) goto L5;
    L9:
        return false;
    L5:
        if (r100.getH() <= 0) goto L9;
        if (r100.j() <= 0) goto L9;
        return true;
    }
}
