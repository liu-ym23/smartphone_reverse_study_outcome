package osb;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements d {
    public final String toString() {
        return "StringData(content=null, raw=" + Arrays.toString(null) + ')';
    }

    public final int hashCode() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(h.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.myai.export.model.StringData");
        h r102 = (h) r100;
        r102.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        r102.getClass();
        if (Arrays.equals(null, null) == true) goto L18;
        return false;
    L18:
        r102.getClass();
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
