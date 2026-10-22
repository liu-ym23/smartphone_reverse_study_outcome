package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ FullBottomSheetFragment a;

    public final void onSlide(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "p0");
    }

    public c(FullBottomSheetFragment r1) {
        this.a = r1;
    }

    public final void onStateChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 != 1) goto L8;
        BottomSheetBehavior<FrameLayout> r4 = this.a.i;
        if (r4 == null) goto L9;
        r4.setState(4);
        return;
    L9:
        return;
    }
}
