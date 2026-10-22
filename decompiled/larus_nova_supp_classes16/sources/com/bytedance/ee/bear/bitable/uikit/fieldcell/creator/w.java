package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.view.cell.stage.StageTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.StageModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class w extends v {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    public w(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r6 = ht4.b.a;
        getType();
        StageTagView r7 = new StageTagView(r4, null, 6, 0);
        iv4.b r8 = this.a;
        if (r8 == null) goto L5;
        r8.a((TextView) r7.findViewById(2131390975));
    L5:
        return r7;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        i(r1, (StageModel) r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v
    public final void i(View r2, StageModel r3) {
        Intrinsics.checkNotNullParameter(r2, "kitView");
        Intrinsics.checkNotNullParameter(r3, "model");
        if ((r2 instanceof StageTagView) == false) goto L5;
        StageTagView r4 = (StageTagView) r2;
    L6:
        if (r4 == null) goto L9;
        r4.setData(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
