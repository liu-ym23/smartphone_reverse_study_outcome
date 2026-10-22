package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 extends ViewOutlineProvider {
    public d0() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setOval(0, 0, r100.getWidth(), r100.getHeight());
    }
}
