package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y extends AosBottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ AosBSViewInfoManager a;
    public final /* synthetic */ c0 b;

    public y(AosBSViewInfoManager r1, c0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSlide(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        AosBSViewInfoManager r5 = this.a;
        float r1 = 0.0f;
        if (r5.j > 0.0f) goto L9;
        FrameLayout r0 = r5.b;
        if (r0 == null) goto L7;
        r1 = r0.getMeasuredHeight();
    L7:
        r5.j = r1;
    L9:
        if (((Boolean) this.a.k.getValue()).booleanValue() == false) goto L14;
        AosBSViewInfoManager r6 = this.a;
        s24.b r2 = r6.h;
        if (r2 == null) goto L15;
        r2.a(r6.j - r3.getY(), this.a.i);
        return;
    L15:
        return;
    }

    public final void onStateChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (r3 != 5) goto L8;
        AosBSViewInfoManager r4 = this.a;
        c0 r5 = this.b;
        r4.e = 3;
        r5.a();
        a0 r6 = r4.d;
        if (r6 == null) goto L9;
        r6.onClose();
        return;
    L9:
        return;
    }
}
