package com.bytedance.ee.docsdk.impl.utils.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RoundRectDrawableCreator {
    public RoundRectDrawableCreator() {
    }

    public static GradientDrawable noneCornerDrawable(int r2, ColorStateList r3) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r2).colorStateList(r3).build();
    }

    public static GradientDrawable bottomCornerDrawable(int r4, float r5, ColorStateList r6) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r4).colorStateList(r6).cornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r5, r5, r5, r5}).build();
    }

    public static GradientDrawable cornerDrawable(int r2, float r3, ColorStateList r4) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r2).colorStateList(r4).cornerRadius(r3).build();
    }

    public static GradientDrawable createRoundDrawable(int r2, float[] r3, ColorStateList r4) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r2).colorStateList(r4).cornerRadii(r3).build();
    }

    public static GradientDrawable leftCornerDrawable(int r4, float r5, ColorStateList r6) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r4).colorStateList(r6).cornerRadii(new float[]{r5, r5, 0.0f, 0.0f, 0.0f, 0.0f, r5, r5}).build();
    }

    public static GradientDrawable rightCornerDrawable(int r4, float r5, ColorStateList r6) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r4).colorStateList(r6).cornerRadii(new float[]{0.0f, 0.0f, r5, r5, r5, r5, 0.0f, 0.0f}).build();
    }

    public static GradientDrawable topCornerDrawable(int r3, float r4, ColorStateList r5) {
        return new GradientDrawableCreator.Builder().shape(0).fillColor(r3).colorStateList(r5).cornerRadii(new float[]{r4, r4, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f}).build();
    }
}
