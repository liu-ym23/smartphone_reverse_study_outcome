package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils {
    public ViewUtils() {
    }

    public static boolean isLayoutRtl(View r100) {
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static PorterDuff.Mode parseTintMode(int r100, PorterDuff.Mode r101) {
        if (r100 == 3) goto L21;
        if (r100 == 5) goto L19;
        if (r100 == 9) goto L17;
        switch(r100) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r101;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
