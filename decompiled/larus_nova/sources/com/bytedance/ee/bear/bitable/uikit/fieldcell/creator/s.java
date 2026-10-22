package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s extends r {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r
    public final float i() {
        return BaseTagSize.MEDIUM.getRadiusPx();
    }

    public s(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r
    public final View h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SelectTagView r101 = new SelectTagView(r100);
        r101.U(BaseTagSize.MEDIUM);
        r101.setTextIsSelectable(false);
        com.bytedance.ee.bear.bitable.m.t(r101, com.bytedance.ee.util.ui.n.d(4));
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void a(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        iv4.b r102 = this.f216158a;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }
}
