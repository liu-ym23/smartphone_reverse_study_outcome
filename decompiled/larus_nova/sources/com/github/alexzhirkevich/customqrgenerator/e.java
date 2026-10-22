package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Deprecated(message = "Use QrCodeDrawable with QrVectorOptions instead")
public final class e {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        r101.getClass();
        r101.getClass();
        Float r102 = Float.valueOf(0.0f);
        r101.getClass();
        if (Intrinsics.areEqual(r102, Float.valueOf(0.0f)) == true) goto L11;
        return false;
    L11:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L26;
        return false;
    L26:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L29;
        return false;
    L29:
        r101.getClass();
        return true;
    }

    public final int hashCode() {
        Float.floatToIntBits(0.0f);
        throw null;
    }

    public final String toString() {
        return "QrOptions(width=0, height=0, padding=0.0, offset=null, colors=null, logo=null, background=null, shapes=null, codeShape=null, errorCorrectionLevel=null)";
    }
}
