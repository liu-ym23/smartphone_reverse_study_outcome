package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: loaded from: classes40.dex */
public final class d {
    public static void a(Context r100, ImageView r101, int r102, int r103) {
        VectorDrawableCompat r104 = VectorDrawableCompat.create(r100.getResources(), r102, r100.getTheme());     // Catch: Exception -> L7
        Drawable r105 = r104;
        if (r104 == null) goto L11;
        r104.setTint(ResourcesCompat.getColor(r100.getResources(), r103, null));     // Catch: Exception -> L7
        r105 = r104;
    L11:
        if (r105 == null) goto L16;
        r101.setImageDrawable(r105);
        return;
    L16:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        Drawable r106 = ResourcesCompat.getDrawable(r100.getResources(), r102, r100.getTheme());
        r105 = r106;
        if (r106 == null) goto L11;
        DrawableCompat.setTint(r106, ResourcesCompat.getColor(r100.getResources(), r103, null));
        r105 = r106;
        goto L11
    }
}
