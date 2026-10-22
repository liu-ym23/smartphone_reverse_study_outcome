package com.ss.android.lark.bottomsheet;

import android.os.Build;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements com.ss.android.lark.bottomsheet.view.a.InterfaceC4773a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerActivity f410715a;

    @Override // com.ss.android.lark.bottomsheet.view.a.InterfaceC4773a
    public final void a() {
        BottomSheetContainerActivity r100 = this.f410715a;
        int r101 = BottomSheetContainerActivity.f410661n;
        r100.F1().updateState(2);
        this.f410715a.F1().updateExpandAnimStatus(1.0f);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f410715a.setTranslucent(false);
        return;
    }

    @Override // com.ss.android.lark.bottomsheet.view.a.InterfaceC4773a
    public final void b() {
        BottomSheetContainerActivity r100 = this.f410715a;
        int r101 = BottomSheetContainerActivity.f410661n;
        r100.F1().updateState(1);
        this.f410715a.F1().updateExpandAnimStatus(0.0f);
    }

    @Override // com.ss.android.lark.bottomsheet.view.a.InterfaceC4773a
    public final void c() {
        BottomSheetContainerActivity r100 = this.f410715a;
        int r101 = BottomSheetContainerActivity.f410661n;
        r100.F1().updateExpandAnimStatus(0.0f);
    }

    public h(BottomSheetContainerActivity r100) {
        this.f410715a = r100;
    }

    @Override // com.ss.android.lark.bottomsheet.view.a.InterfaceC4773a
    public final void d(float r100) {
        BottomSheetContainerActivity r101 = this.f410715a;
        int r102 = BottomSheetContainerActivity.f410661n;
        r101.F1().updateExpandAnimStatus(r100);
    }
}
