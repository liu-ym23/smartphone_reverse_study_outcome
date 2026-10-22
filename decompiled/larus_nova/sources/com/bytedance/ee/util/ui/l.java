package com.bytedance.ee.util.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public static void b(View r100, int r101) {
        r100.setBackgroundTintList(r100.getContext().getResources().getColorStateList(r101));
    }

    public static void c(ImageView r100, int r101) {
        r100.setImageTintList(r100.getContext().getResources().getColorStateList(r101));
    }

    public static Drawable a(Context r100, int r101, int r102) {
        Drawable r103 = AppCompatResources.getDrawable(r100, r101);
        if (r103 == null) goto L7;
        r103.mutate();
        Drawable r104 = DrawableCompat.unwrap(r103);
        DrawableCompat.setTintList(r104, null);
        Drawable r105 = DrawableCompat.wrap(r104);
        r105.setTintList(r100.getResources().getColorStateList(r102));
        return r105;
    L7:
        return null;
    }
}
