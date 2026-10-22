package com.ss.android.lark.bottomsheet;

import com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti;

/* JADX INFO: loaded from: classes34.dex */
public final class q implements ExpandValueAnimatorInForseti.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerFragment f410724a;

    @Override // com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti.a
    public final void a() {
        BottomSheetContainerFragment r100 = this.f410724a;
        int r101 = BottomSheetContainerFragment.f410674u;
        r100.Z90().updateState(2);
        this.f410724a.Z90().updateExpandAnimStatus(1.0f);
    }

    @Override // com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti.a
    public final void b() {
        BottomSheetContainerFragment r100 = this.f410724a;
        int r101 = BottomSheetContainerFragment.f410674u;
        r100.Z90().updateState(1);
        this.f410724a.Z90().updateExpandAnimStatus(0.0f);
    }

    @Override // com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti.a
    public final void c() {
        BottomSheetContainerFragment r100 = this.f410724a;
        int r101 = BottomSheetContainerFragment.f410674u;
        r100.Z90().updateExpandAnimStatus(0.0f);
    }

    public q(BottomSheetContainerFragment r100) {
        this.f410724a = r100;
    }

    @Override // com.ss.android.lark.bottomsheet.view.ExpandValueAnimatorInForseti.a
    public final void d(float r100) {
        BottomSheetContainerFragment r101 = this.f410724a;
        int r102 = BottomSheetContainerFragment.f410674u;
        r101.Z90().updateExpandAnimStatus(r100);
    }
}
