package d78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<e> r101 = r100.b();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        return !r102;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }
}
