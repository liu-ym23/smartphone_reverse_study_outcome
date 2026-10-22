package th8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {
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
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "VlmImageRenderInfo(itemViewSize=null, indexInList=0, moreImageSize=0, renderType=null, imageList=null, mixedMediaList=null, attachImageIndexList=null)";
    }
}
