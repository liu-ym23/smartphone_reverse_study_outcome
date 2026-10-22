package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends v {
    public k(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v
    public final void h(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.d(24)));
    }
}
