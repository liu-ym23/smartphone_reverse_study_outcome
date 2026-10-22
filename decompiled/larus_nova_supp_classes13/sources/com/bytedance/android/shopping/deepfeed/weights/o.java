package com.bytedance.android.shopping.deepfeed.weights;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public static final void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateLayoutParamsHeight");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.deepfeed.ui.view.a r1 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r0.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r2.getContext(), r3);
        r2.setLayoutParams(r0);
    }
}
