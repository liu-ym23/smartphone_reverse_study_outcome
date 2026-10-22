package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements i {
    public final View a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int[] getLocationOnScreen() {
        int[] r0 = {0, 0};
        this.a.getLocationOnScreen(r0);
        return r0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int getHeight() {
        return this.a.getHeight();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.i
    public final int getWidth() {
        return this.a.getWidth();
    }

    public n(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        this.a = r2;
    }
}
