package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s extends r {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r
    public final float i() {
        return BaseTagSize.MEDIUM.getRadiusPx();
    }

    public s(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r
    public final View h(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        SelectTagView r0 = new SelectTagView(r2);
        r0.U(BaseTagSize.MEDIUM);
        r0.setTextIsSelectable(false);
        com.bytedance.ee.bear.bitable.m.t(r0, com.bytedance.ee.util.ui.n.d(4));
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void a(TextView r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "textView");
        iv4.b r3 = this.a;
        if (r3 == null) goto L6;
        r3.a(r1);
        return;
    }
}
