package com.bytedance.ee.bear.document.pageedit;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f220810a;

    public a(float r100) {
        this.f220810a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = this.f220810a;
        r101.setRoundRect(0, 0, r102, r103 + ((int) r104), r104);
    }
}
