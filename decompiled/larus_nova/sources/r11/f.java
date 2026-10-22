package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    public static final boolean a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isForceDegradeEnable");
        if (r100.getEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.V6() == false) goto L9;
        if (r100.g2() == false) goto L9;
        return true;
    }
}
