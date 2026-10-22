package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l extends w {
    public l(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v
    public final void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.ee.util.ui.n.d(BaseTagSize.MEDIUM.getHeightDp())));
    }
}
