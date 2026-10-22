package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes23.dex */
public class DrawableUtils {
    private DrawableUtils() {
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable r100, ColorStateList r101, PorterDuff.Mode r102) {
        if (r101 == null) goto L7;
        if (r102 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r101.getColorForState(r100.getState(), 0), r102);
    L7:
        return null;
    }
}
