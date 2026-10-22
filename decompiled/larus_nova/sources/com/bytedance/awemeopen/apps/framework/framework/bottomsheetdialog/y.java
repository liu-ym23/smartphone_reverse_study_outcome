package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class y extends AosBottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AosBSViewInfoManager f196925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f196926b;

    public y(AosBSViewInfoManager r100, c0 r101) {
        this.f196925a = r100;
        this.f196926b = r101;
    }

    @Override // com.google.android.material.internal.AosBottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        AosBSViewInfoManager r102 = this.f196925a;
        float r103 = 0.0f;
        if (r102.f196871j > 0.0f) goto L9;
        FrameLayout r104 = r102.f196863b;
        if (r104 == null) goto L7;
        r103 = r104.getMeasuredHeight();
    L7:
        r102.f196871j = r103;
    L9:
        if (((Boolean) this.f196925a.f196872k.getValue()).booleanValue() == false) goto L14;
        AosBSViewInfoManager r105 = this.f196925a;
        s24.b r106 = r105.f196869h;
        if (r106 == null) goto L15;
        r106.a(r105.f196871j - r100.getY(), this.f196925a.f196870i);
        return;
    L15:
        return;
    }

    @Override // com.google.android.material.internal.AosBottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 5) goto L8;
        AosBSViewInfoManager r102 = this.f196925a;
        c0 r103 = this.f196926b;
        r102.f196866e = 3;
        r103.a();
        a0 r104 = r102.f196865d;
        if (r104 == null) goto L9;
        r104.onClose();
        return;
    L9:
        return;
    }
}
