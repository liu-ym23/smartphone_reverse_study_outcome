package com.obric.assistant.interaction.impl.toast;

import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.toast.ToastBackgroundView;

/* JADX INFO: loaded from: classes33.dex */
final class WindowOuiToastCompat {
    private WindowOuiToastCompat() {
    }

    public static void setupBackground(View r100) {
        if ((r100 instanceof ToastBackgroundView) == true) goto L5;
        return;
    L5:
        r100.measure(0, 0);
        ((ToastBackgroundView) r100).setupBackground(r100.getMeasuredHeight());
    }

    public static int getCornerRadius(View r100, int r101) {
        if ((r100 instanceof ToastBackgroundView) == true) goto L5;
        return r101;
    L5:
        return ((ToastBackgroundView) r100).getCornerRadius();
    }

    public static void setShadowCornerRadius(View r100, int r101) {
        if ((r100 instanceof OUIFrameLayout) == false) goto L6;
        ((OUIFrameLayout) r100).setShadowCornerRadius(r101);
        return;
    }
}
