package com.larus.camera.impl.ui.component.result.general.edu;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends ViewOutlineProvider {
    public f() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == null) goto L6;
        r101.setAlpha(1.0f);
    L6:
        if (r101 == null) goto L9;
        r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), c7.c(28));
        return;
    }
}
