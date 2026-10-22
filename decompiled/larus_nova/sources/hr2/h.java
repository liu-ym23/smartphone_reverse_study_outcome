package hr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        ((h) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "IRTCSpatialAudioHumanOrientationParams(forward=null, right=null, up=null)";
    }
}
