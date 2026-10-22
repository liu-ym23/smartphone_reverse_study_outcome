package com.larus.search.impl;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior<View> f367478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f367479b;

    public c(BottomSheetBehavior<View> r100, int r101) {
        this.f367478a = r100;
        this.f367479b = r101;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 == 1) goto L7;
        if (r101 != 3) goto L10;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.height = this.f367479b;
        r100.setLayoutParams(r102);
        return;
    L10:
        return;
    L7:
        this.f367478a.setState(3);
    }
}
