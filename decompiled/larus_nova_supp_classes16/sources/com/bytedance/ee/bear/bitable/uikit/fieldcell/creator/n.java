package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.LinkModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.LinkTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n extends m {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    public n(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r5 = ht4.b.a;
        getType();
        return new LinkTagView(r3, null, null, 6);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        h(r1, (LinkModel) r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m
    public final void h(View r2, LinkModel r3) {
        Intrinsics.checkNotNullParameter(r2, "kitView");
        Intrinsics.checkNotNullParameter(r3, "model");
        super.h(r2, r3);
        if ((r2 instanceof TextView) == false) goto L6;
        ((TextView) r2).setTextSize(BaseTagSize.MEDIUM.getTextSizeSp());
        return;
    }
}
