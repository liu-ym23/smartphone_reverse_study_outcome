package x54;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(4);
    }

    public static final boolean c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }
}
