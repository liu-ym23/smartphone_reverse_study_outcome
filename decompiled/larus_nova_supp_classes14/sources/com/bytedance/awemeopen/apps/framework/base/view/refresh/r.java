package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public static void a(Context r2, ImageView r3, int r4, int r5) {
        VectorDrawableCompat r0 = VectorDrawableCompat.create(r2.getResources(), r4, r2.getTheme());     // Catch: Exception -> L6
        if (r0 == null) goto L10;
        r0.setTint(r2.getResources().getColor(r5));     // Catch: Exception -> L6
    L10:
        if (r0 == null) goto L15;
        r3.setImageDrawable(r0);
        return;
    L15:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = ResourcesCompat.getDrawable(r2.getResources(), r4, r2.getTheme());
        if (r0 == null) goto L10;
        DrawableCompat.setTint(r0, r2.getResources().getColor(r5));
        goto L10
    }
}
