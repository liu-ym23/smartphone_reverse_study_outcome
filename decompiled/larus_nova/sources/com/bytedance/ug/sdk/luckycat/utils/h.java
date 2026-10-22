package com.bytedance.ug.sdk.luckycat.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes22.dex */
public final class h {
    public static final int a(Context r100) {
        if (r100 == null) goto L6;
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 == null) goto L6;
        return r102.heightPixels;
    L6:
        return 0;
    }

    public static final int b(Context r100) {
        if (r100 == null) goto L6;
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 == null) goto L6;
        return r102.widthPixels;
    L6:
        return 0;
    }

    public static final int c(Context r100) {
        if (r100 == null) goto L10;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return r100.getResources().getDimensionPixelSize(r101);
    L10:
        return 0;
    }

    public static float d(Context r100, float r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        Resources r102 = r100.getResources();
        if (r102 != null) goto L7;
        return r101;
    L7:
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        if (r103 != null) goto L10;
        return r101;
    L10:
        float r104 = r103.density;
        if (r104 > 0.0f) goto L14;
        return r101;
    L14:
        return (r101 + 0.5f) / r104;
    }

    public static final void e(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() == r101) goto L18;
        if (r101 != 0) goto L7;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L19;
        r100.setVisibility(r101);
        return;
    L19:
        return;
    L7:
        if (r101 == 8) goto L12;
        if (r101 == 4) goto L12;
        r102 = false;
        goto L13
    }
}
