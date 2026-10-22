package kd1;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final k a(c r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAnimByState");
        if (r101 != 1) goto L6;
        return r100.getLowImg();
    L6:
        if (r101 != 2) goto L9;
        return r100.getMediumImg();
    L9:
        return r100.getHighImg();
    }
}
