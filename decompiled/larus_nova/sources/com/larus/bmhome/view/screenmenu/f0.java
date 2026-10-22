package com.larus.bmhome.view.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 implements ot8.a {
    @Override // ot8.a
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        ((f0) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // ot8.a
    public final int getId() {
        return 0;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "LottieMenu(id=0, text=0, textColor=null, imageAssetFolder=null, lottieFile=null, repeatCount=0, repeatMode=0, removeAroundDivider=false)";
    }
}
