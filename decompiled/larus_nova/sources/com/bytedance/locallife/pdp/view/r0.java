package com.bytedance.locallife.pdp.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes21.dex */
public final class r0 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f261943a;

    public r0(int r100) {
        this.f261943a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        int r104 = this.f261943a;
        r101.setRoundRect(0, 0, r102, r103 + r104, r104);
    }
}
