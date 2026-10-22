package com.larus.office.base.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w {
    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        r100.setAlpha(1.0f);
        return;
    L9:
        r100.animate().cancel();
        r100.setAlpha(0.0f);
        r100.setVisibility(0);
        r100.animate().alpha(1.0f).setDuration(300).setListener(null).start();
        return;
    L5:
        r101 = false;
        goto L7
    }

    public static void b(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        r100.animate().cancel();
        r100.animate().alpha(0.0f).setDuration(300).withEndAction(new v(r100)).start();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
