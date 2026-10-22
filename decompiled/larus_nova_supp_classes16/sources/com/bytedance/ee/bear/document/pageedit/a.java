package com.bytedance.ee.bear.document.pageedit;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ViewOutlineProvider {
    public final /* synthetic */ float a;

    public a(float r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        int r4 = r8.getWidth();
        int r10 = r8.getHeight();
        float r6 = this.a;
        r9.setRoundRect(0, 0, r4, r10 + ((int) r6), r6);
    }
}
