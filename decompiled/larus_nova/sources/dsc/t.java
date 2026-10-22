package dsc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class t {
    public static final float[] a(s r100, prc.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "state");
        float[] r102 = r100.getTransform().H(r101);
        s r103 = r100.x();
    L3:
        if (r103 == null) goto L5;
        fsc.a.c(r102, r103.getTransform().H(r101));
        r103 = r103.x();
        goto L3
    L5:
        return r102;
    }
}
