package com.ss.android.lark.bottomsheet;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerActivity f410717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f410718b;

    public j(BottomSheetContainerActivity r100, Integer r101) {
        this.f410717a = r100;
        this.f410718b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        BottomSheetContainerActivity r109 = this.f410717a;
        int r110 = BottomSheetContainerActivity.f410661n;
        r109.getClass();
        BottomSheetContainerActivity r111 = this.f410717a;
        Intrinsics.checkNotNull(this.f410718b);
        int r112 = (int) BottomSheetContainerActivity.A1(r111, this.f410718b.intValue());
        this.f410717a.G1(r112);
    }
}
