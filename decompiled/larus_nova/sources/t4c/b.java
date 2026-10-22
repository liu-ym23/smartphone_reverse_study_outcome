package t4c;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100.setVisibility(8);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100.setVisibility(0);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
