package com.bytedance.ee.docsdk.impl.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes18.dex */
public class TintUtils {
    private TintUtils() {
    }

    public static void updateBackgroundTint(View r100, int r101) {
        updateBackgroundTint(r100, r100.getContext(), r101);
    }

    public static void updateImageTint(ImageView r100, int r101) {
        updateImageTint(r100, r100.getContext(), r101);
    }

    private static Drawable getTintDrawable(Context r100, Drawable r101, int r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        r101.mutate();
        Drawable r103 = DrawableCompat.unwrap(r101);
        DrawableCompat.setTintList(r103, null);
        Drawable r104 = DrawableCompat.wrap(r103);
        r104.setTintList(r100.getResources().getColorStateList(r102));
        return r104;
    }

    public static void updateBackgroundDrawableTint(View r100, int r101, int r102) {
        r100.setBackgroundDrawable(getTintDrawable(r100.getContext(), r101, r102));
    }

    private static void updateBackgroundTint(View r100, Context r101, int r102) {
        r100.setBackgroundTintList(r101.getResources().getColorStateList(r102));
    }

    public static void updateImageDrawableTint(ImageView r100, int r101, int r102) {
        r100.setImageDrawable(getTintDrawable(r100.getContext(), r101, r102));
    }

    private static void updateImageTint(ImageView r100, Context r101, int r102) {
        r100.setImageTintList(r101.getResources().getColorStateList(r102));
    }

    public static Drawable getTintDrawable(Context r100, int r101, int r102) {
        return getTintDrawable(r100, AppCompatResources.getDrawable(r100, r101), r102);
    }
}
