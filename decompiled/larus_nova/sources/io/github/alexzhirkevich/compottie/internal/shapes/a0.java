package io.github.alexzhirkevich.compottie.internal.shapes;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a0 {
    public static final boolean a(zrc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof TrimPathShape) == false) goto L11;
        byte r101 = ((TrimPathShape) r100).f491567g;
        bsc.y.Companion.getClass();
        if (r101 != bsc.y.f20488c) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = false;
        goto L8
    L11:
        return false;
    }
}
