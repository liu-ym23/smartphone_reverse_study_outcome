package w1a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g<T> extends a<T> {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        ((g) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "Success(value=null)";
    }
}
