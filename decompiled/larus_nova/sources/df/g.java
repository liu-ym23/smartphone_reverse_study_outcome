package df;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        ((g) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final Context getContext() {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "ECShareResources(context=null, view=null)";
    }
}
