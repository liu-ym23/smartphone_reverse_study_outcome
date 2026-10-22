package com.bytedance.locallife.common.utils;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes21.dex */
public final class l {
    public static final void a(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        r104.leftMargin = 0;
        r104.topMargin = 0;
        if (r101 < 0) goto L11;
        r104.rightMargin = r101;
    L11:
        if (r102 < 0) goto L13;
        r104.bottomMargin = r102;
    L13:
        r100.setLayoutParams(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
