package com.bytedance.ee.docsdk.impl.utils.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes18.dex */
public class RoundRectDrawableCreator {
    public RoundRectDrawableCreator() {
    }

    public static GradientDrawable noneCornerDrawable(int r100, ColorStateList r101) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r101).build();
    }

    public static GradientDrawable bottomCornerDrawable(int r100, float r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r101, r101, r101, r101}).build();
    }

    public static GradientDrawable cornerDrawable(int r100, float r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadius(r101).build();
    }

    public static GradientDrawable createRoundDrawable(int r100, float[] r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadii(r101).build();
    }

    public static GradientDrawable leftCornerDrawable(int r100, float r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadii(new float[]{r101, r101, 0.0f, 0.0f, 0.0f, 0.0f, r101, r101}).build();
    }

    public static GradientDrawable rightCornerDrawable(int r100, float r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadii(new float[]{0.0f, 0.0f, r101, r101, r101, r101, 0.0f, 0.0f}).build();
    }

    public static GradientDrawable topCornerDrawable(int r100, float r101, ColorStateList r102) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r100).colorStateList(r102).cornerRadii(new float[]{r101, r101, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f}).build();
    }
}
