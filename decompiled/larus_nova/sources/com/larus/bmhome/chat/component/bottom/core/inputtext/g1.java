package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g1 extends ViewOutlineProvider {
    public g1() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = l1.a(r100.getContext());
        r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight() + r102, r102);
    }
}
