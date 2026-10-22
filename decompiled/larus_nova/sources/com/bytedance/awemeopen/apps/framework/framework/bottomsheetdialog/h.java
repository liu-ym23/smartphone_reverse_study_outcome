package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends AosBottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AosBSDialogInfoManager f196892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f196893b;

    public h(AosBSDialogInfoManager r100, b0 r101) {
        this.f196892a = r100;
        this.f196893b = r101;
    }

    @Override // com.google.android.material.internal.AosBottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (((Boolean) this.f196892a.f196856j.getValue()).booleanValue() == false) goto L14;
        AosBSDialogInfoManager r102 = this.f196892a;
        float r103 = 0.0f;
        if (r102.f196855i > 0.0f) goto L10;
        FrameLayout r104 = r102.f196848b;
        if (r104 == null) goto L9;
        r103 = r104.getMeasuredHeight();
    L9:
        r102.f196855i = r103;
    L10:
        AosBSDialogInfoManager r105 = this.f196892a;
        s24.b r106 = r105.f196853g;
        if (r106 == null) goto L15;
        r106.a(r105.f196855i - r100.getY(), this.f196892a.f196854h);
        return;
    L15:
        return;
    }

    @Override // com.google.android.material.internal.AosBottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 5) goto L6;
        AosBSDialogInfoManager.a(this.f196892a, this.f196893b);
        return;
    }
}
