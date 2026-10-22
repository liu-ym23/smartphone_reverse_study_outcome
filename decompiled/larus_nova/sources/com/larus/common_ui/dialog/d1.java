package com.larus.common_ui.dialog;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d1 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f327301a;

    public d1(int r100) {
        this.f327301a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        int r104 = this.f327301a;
        r101.setRoundRect(0, 0, r102, r103 + r104, r104);
    }
}
