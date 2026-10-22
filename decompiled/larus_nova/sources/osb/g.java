package osb;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements d {
    public final int hashCode() {
        Arrays.hashCode(null);
        throw null;
    }

    public final String toString() {
        return "RawData(raw=" + Arrays.toString(null) + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(g.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.myai.export.model.RawData");
        g r102 = (g) r100;
        r102.getClass();
        if (Arrays.equals(null, null) == true) goto L15;
        return false;
    L15:
        r102.getClass();
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
