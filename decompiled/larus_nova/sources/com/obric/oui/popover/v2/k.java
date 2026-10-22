package com.obric.oui.popover.v2;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OPopoverLayout f402435a;

    public k(OPopoverLayout r100) {
        this.f402435a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        if (r100 == null) goto L9;
        OPopoverLayout r102 = this.f402435a;
        int r103 = (int) (r102.f402337i / 2.0f);
        r102.f402332d.set(r103, r103, r100.getWidth() - r103, r100.getHeight() - r103);
        r102.f402333e.set(r102.f402332d);
        if (r101 == null) goto L10;
        r101.setRoundRect(r102.f402332d, r102.f402329a);
        return;
    L10:
        return;
    }
}
