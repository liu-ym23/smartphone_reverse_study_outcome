package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q {
    public static final float a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getValidRatio");
        if (Float.compare(0.0f, r100.getRatio()) < 0) goto L6;
        return 0.72f;
    L6:
        return r100.getRatio();
    }
}
