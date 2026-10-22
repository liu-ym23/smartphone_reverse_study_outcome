package com.larksuite.component.ui.button;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static Drawable a(int r100, int r101, int r102, int r103) {
        GradientDrawable r104 = new GradientDrawable();
        r104.setCornerRadius(r101);
        r104.setColor(r100);
        if (r103 <= 0) goto L5;
        r104.setStroke(r103, r102);
    L5:
        return r104;
    }
}
