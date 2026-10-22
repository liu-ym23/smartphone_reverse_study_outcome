package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        ((b) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "DatasetInjectItem(filePath=null, resolution=null, ratio=null)";
    }
}
