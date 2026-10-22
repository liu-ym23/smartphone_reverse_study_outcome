package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k extends v {
    public k(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v
    public final void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.ee.util.ui.n.d(24)));
    }
}
