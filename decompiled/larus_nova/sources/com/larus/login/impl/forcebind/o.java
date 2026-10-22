package com.larus.login.impl.forcebind;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior<View> f357716a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public o(BottomSheetBehavior<View> r100) {
        this.f357716a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 1) goto L6;
        this.f357716a.setState(3);
        return;
    }
}
