package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes33.dex */
public final class i1 {
    public static final void a(View r100) {
        r100.forceLayout();
        r100.requestLayout();
        if ((r100 instanceof ViewGroup) == false) goto L11;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L15;
        View r104 = r101.getChildAt(r103);
        if (r104 == null) goto L10;
        a(r104);
    L10:
        r103 = r103 + 1;
        goto L5
    L15:
        return;
    }
}
