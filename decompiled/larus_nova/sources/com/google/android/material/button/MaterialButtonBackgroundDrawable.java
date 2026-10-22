package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

/* JADX INFO: loaded from: classes23.dex */
class MaterialButtonBackgroundDrawable extends RippleDrawable {
    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        if (getDrawable(0) == null) goto L6;
        ((GradientDrawable) ((LayerDrawable) ((InsetDrawable) getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(r100);
        return;
    }

    public MaterialButtonBackgroundDrawable(ColorStateList r100, InsetDrawable r101, Drawable r102) {
        super(r100, r101, r102);
    }
}
