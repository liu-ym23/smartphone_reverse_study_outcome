package p31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L8;
        ((c) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "RevLinkPreloadViewConfig(resId=0, viewClazz=null)";
    }
}
