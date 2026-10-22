package xq8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public static final boolean a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r101 = r100.getParentFragment();
    L3:
        if (r101 == null) goto L9;
        if ((r101 instanceof a) == true) goto L6;
        r101 = r101.getParentFragment();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
