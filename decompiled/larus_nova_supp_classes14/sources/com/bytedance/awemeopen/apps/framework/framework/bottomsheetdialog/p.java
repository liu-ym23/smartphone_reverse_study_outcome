package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.google.android.material.internal.AosBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p extends AosBottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ n a;
    public final /* synthetic */ AosBaseFragment<?> b;

    public final void onSlide(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public p(n r1, AosBaseFragment<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStateChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (r3 != 5) goto L6;
        n.a(this.a, this.b.getActivity(), this.b);
        return;
    }
}
