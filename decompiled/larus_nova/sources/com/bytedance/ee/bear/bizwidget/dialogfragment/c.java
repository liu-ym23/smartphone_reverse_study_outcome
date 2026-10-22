package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullBottomSheetFragment f216414a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    public c(FullBottomSheetFragment r100) {
        this.f216414a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 1) goto L8;
        BottomSheetBehavior<FrameLayout> r102 = this.f216414a.f216397i;
        if (r102 == null) goto L9;
        r102.setState(4);
        return;
    L9:
        return;
    }
}
