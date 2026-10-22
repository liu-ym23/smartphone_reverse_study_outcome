package com.ss.android.lark.bottomsheet;

import android.view.View;
import com.ss.android.lark.bottomsheet.view.OverClapBottomSheetBehavior;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerActivity f410692a;

    public a(BottomSheetContainerActivity r100) {
        this.f410692a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        OverClapBottomSheetBehavior<View> r109 = this.f410692a.f410666i;
        if (r109 == null) goto L5;
        r109.setState(3);
    L5:
        this.f410692a.F1().updateState(1);
    }
}
