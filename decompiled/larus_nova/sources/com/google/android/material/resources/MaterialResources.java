package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context r100, TypedArray r101, int r102) {
        if (r101.hasValue(r102) == false) goto L10;
        int r103 = r101.getResourceId(r102, 0);
        if (r103 == 0) goto L10;
        ColorStateList r104 = AppCompatResources.getColorStateList(r100, r103);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return r101.getColorStateList(r102);
    }

    public static Drawable getDrawable(Context r100, TypedArray r101, int r102) {
        if (r101.hasValue(r102) == false) goto L10;
        int r103 = r101.getResourceId(r102, 0);
        if (r103 == 0) goto L10;
        Drawable r104 = AppCompatResources.getDrawable(r100, r103);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return r101.getDrawable(r102);
    }

    public static int getIndexWithValue(TypedArray r100, int r101, int r102) {
        if (r100.hasValue(r101) == false) goto L5;
        return r101;
    L5:
        return r102;
    }

    public static TextAppearance getTextAppearance(Context r100, TypedArray r101, int r102) {
        if (r101.hasValue(r102) == false) goto L8;
        int r103 = r101.getResourceId(r102, 0);
        if (r103 != 0) goto L7;
        return null;
    L7:
        return new TextAppearance(r100, r103);
    L8:
        return null;
    }
}
