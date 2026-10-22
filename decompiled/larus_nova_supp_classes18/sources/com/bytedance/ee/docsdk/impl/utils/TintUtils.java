package com.bytedance.ee.docsdk.impl.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TintUtils {
    private TintUtils() {
    }

    public static void updateBackgroundTint(View r1, int r2) {
        updateBackgroundTint(r1, r1.getContext(), r2);
    }

    public static void updateImageTint(ImageView r1, int r2) {
        updateImageTint(r1, r1.getContext(), r2);
    }

    private static Drawable getTintDrawable(Context r1, Drawable r2, int r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        r2.mutate();
        Drawable r4 = DrawableCompat.unwrap(r2);
        DrawableCompat.setTintList(r4, null);
        Drawable r5 = DrawableCompat.wrap(r4);
        r5.setTintList(r1.getResources().getColorStateList(r3));
        return r5;
    }

    public static void updateBackgroundDrawableTint(View r1, int r2, int r3) {
        r1.setBackgroundDrawable(getTintDrawable(r1.getContext(), r2, r3));
    }

    private static void updateBackgroundTint(View r0, Context r1, int r2) {
        r0.setBackgroundTintList(r1.getResources().getColorStateList(r2));
    }

    public static void updateImageDrawableTint(ImageView r1, int r2, int r3) {
        r1.setImageDrawable(getTintDrawable(r1.getContext(), r2, r3));
    }

    private static void updateImageTint(ImageView r0, Context r1, int r2) {
        r0.setImageTintList(r1.getResources().getColorStateList(r2));
    }

    public static Drawable getTintDrawable(Context r0, int r1, int r2) {
        return getTintDrawable(r0, AppCompatResources.getDrawable(r0, r1), r2);
    }
}
