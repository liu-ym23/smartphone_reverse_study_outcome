package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GridProgress f216182f;

    public i(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<ProgressModel> r100) {
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isEmpty() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        if (r100 == null) goto L17;
        ProgressModel r102 = (ProgressModel) ListProtector.get(r100, 0);
        if (r102 == null) goto L18;
        GridProgress r103 = this.f216182f;
        if (r103 == null) goto L19;
        h(r103, r102);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.GridProgress");
        this.f216182f = (GridProgress) r102;
        Intrinsics.checkNotNullParameter(r102, "view");
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return new GridProgress(r100, null, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o, com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (ProgressModel) r101);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o
    public final void h(View r100, ProgressModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        GridProgress r102 = this.f216182f;
        if (r102 == null) goto L11;
        a(r102.getContentView(), false);
        if (r101 == null) goto L12;
        UDProgress r103 = r102.f216169a;
        if (r103 == null) goto L9;
        r103.setProgress((int) r101.getProgress());
        r103.setIndicatorColor(ColorUtils.h(r101.getColor()));
    L9:
        r102.f216170b.setText(r101.getText());
        return;
    L12:
        return;
    }
}
