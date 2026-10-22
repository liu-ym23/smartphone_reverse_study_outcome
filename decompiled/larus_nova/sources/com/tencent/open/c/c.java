package com.tencent.open.c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public class c extends FrameLayout {
    public c(Context r100) {
        super(r100);
    }

    private void a(WindowInsets r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        DisplayCutout r101 = r100.getDisplayCutout();
        if (r101 != null) goto L10;
        return;
    L10:
        List<Rect> r102 = r101.getBoundingRects();
        if (r102 != null) goto L13;
        return;
    L13:
        if (r102.isEmpty() == true) goto L18;
        setPadding(Math.max(r101.getSafeInsetLeft(), 0), Math.max(r101.getSafeInsetTop(), 0), Math.max(r101.getSafeInsetRight(), 0), Math.max(r101.getSafeInsetBottom(), 0));
        return;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r100) {
        a(r100);
        return super.onApplyWindowInsets(r100);
    }
}
