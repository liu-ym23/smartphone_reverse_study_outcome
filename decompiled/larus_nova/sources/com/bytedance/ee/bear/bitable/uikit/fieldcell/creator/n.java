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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n extends m {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final iv4.a d() {
        return BaseTagSize.MEDIUM.buildMutilCellLabelSpec();
    }

    public n(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return BaseTagSize.MEDIUM.buildNeutralCapsuleBackground(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return new LinkTagView(r100, null, null, 6);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (LinkModel) r101);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m
    public final void h(View r100, LinkModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super.h(r100, r101);
        if ((r100 instanceof TextView) == false) goto L6;
        ((TextView) r100).setTextSize(BaseTagSize.MEDIUM.getTextSizeSp());
        return;
    }
}
