package com.github.alexzhirkevich.customqrgenerator.encoder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {
    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        ((d) r100).getClass();
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

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "QrRenderResult(bitMatrix=null, paddingX=0, paddingY=0, pixelSize=0, shapeIncrease=0, frame=null, ball=null, error=0)";
    }
}
