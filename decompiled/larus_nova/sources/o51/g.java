package o51;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final String a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$focusLinkerID");
        if ((r100 instanceof e.d) == false) goto L6;
        return ((e.d) r100).f522044f;
    L6:
        if ((r100 instanceof e.c) == false) goto L9;
        return ((e.c) r100).f522042f;
    L9:
        if ((r100 instanceof e.C7015e) == true) goto L15;
        return null;
    L15:
        return ((e.C7015e) r100).f522047g;
    }

    public static final String b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$focusUID");
        if ((r100 instanceof e.d) == false) goto L6;
        return ((e.d) r100).f522043e;
    L6:
        if ((r100 instanceof e.c) == false) goto L9;
        return ((e.c) r100).f522041e;
    L9:
        if ((r100 instanceof e.C7015e) == true) goto L15;
        return null;
    L15:
        return ((e.C7015e) r100).f522046f;
    }

    public static final UILayout c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toCompactUILayout");
        if ((r100 instanceof e.f) == false) goto L6;
        return UILayout.Normal;
    L6:
        if ((r100 instanceof e.c) == false) goto L9;
        return UILayout.Enlarge;
    L9:
        if ((r100 instanceof e.d) == true) goto L15;
        if ((r100 instanceof e.C7015e) == true) goto L15;
        return UILayout.Normal;
    L15:
        return UILayout.FULL;
    }
}
