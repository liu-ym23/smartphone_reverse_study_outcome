package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.view.cell.stage.StageTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.StageModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class w extends v {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    public w(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        AttributeSet r103 = null;
        StageTagView r104 = new StageTagView(r100, r103, 6, 0);
        iv4.b r105 = this.f216158a;
        if (r105 == null) goto L5;
        r105.a((TextView) r104.findViewById(R.id.tv_name));
    L5:
        return r104;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        i(r100, (StageModel) r101);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v
    public final void i(View r100, StageModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof StageTagView) == false) goto L5;
        StageTagView r102 = (StageTagView) r100;
    L6:
        if (r102 == null) goto L9;
        r102.setData(r101);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
