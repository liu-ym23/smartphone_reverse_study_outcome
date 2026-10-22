package com.obric.oui.lisitem;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCardListItem f401389a;

    public c(OCardListItem r100) {
        this.f401389a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        OCardListItem r104 = this.f401389a;
        if (r104.D != 0) goto L5;
        int r105 = 8;
    L6:
        r101.setRoundRect(0, 0, r102, r103, pla.d.n(r104, r105));
        return;
    L5:
        r105 = 10;
        goto L6
    }
}
