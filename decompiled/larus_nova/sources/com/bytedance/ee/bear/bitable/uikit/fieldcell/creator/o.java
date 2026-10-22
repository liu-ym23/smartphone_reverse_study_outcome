package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class o extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<ProgressModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDProgress f216183e;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.PROGRESS.getValue();
    }

    public o(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public void g(List<ProgressModel> r100) {
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
        UDProgress r103 = this.f216183e;
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

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larksuite.component.universe_design.progress.UDProgress");
        this.f216183e = (UDProgress) r102;
        Intrinsics.checkNotNullParameter(r102, "view");
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        UDProgress r103 = new UDProgress(r100);
        r103.setIndicatorCornerRadius(com.bytedance.ee.util.ui.n.d(4));
        r103.setThickness(com.bytedance.ee.util.ui.n.d(8));
        r103.setTrackColor(r100.getResources().getColor(R.color.bg_body_overlay));
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (ProgressModel) r101);
    }

    public void h(View r100, ProgressModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        UDProgress r102 = this.f216183e;
        if (r102 == null) goto L6;
        r102.setProgress((int) r101.getProgress());
        r102.setIndicatorColor(ColorUtils.h(r101.getColor()));
        return;
    }
}
