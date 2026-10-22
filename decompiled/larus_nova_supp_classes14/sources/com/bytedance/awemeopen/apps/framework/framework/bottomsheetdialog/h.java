package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends AosBottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ AosBSDialogInfoManager a;
    public final /* synthetic */ b0 b;

    public h(AosBSDialogInfoManager r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSlide(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        if (((Boolean) this.a.j.getValue()).booleanValue() == false) goto L14;
        AosBSDialogInfoManager r5 = this.a;
        float r1 = 0.0f;
        if (r5.i > 0.0f) goto L10;
        FrameLayout r0 = r5.b;
        if (r0 == null) goto L9;
        r1 = r0.getMeasuredHeight();
    L9:
        r5.i = r1;
    L10:
        AosBSDialogInfoManager r6 = this.a;
        s24.b r2 = r6.g;
        if (r2 == null) goto L15;
        r2.a(r6.i - r3.getY(), this.a.h);
        return;
    L15:
        return;
    }

    public final void onStateChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (r3 != 5) goto L6;
        AosBSDialogInfoManager.a(this.a, this.b);
        return;
    }
}
