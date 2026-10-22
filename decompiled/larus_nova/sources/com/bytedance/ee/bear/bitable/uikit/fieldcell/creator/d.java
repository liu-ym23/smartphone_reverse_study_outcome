package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.DateModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<DateModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IconTextUIKit f216174e;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.DATE_TIME.getValue();
    }

    public d(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<DateModel> r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        IconTextUIKit r102 = this.f216174e;
        if (r102 == null) goto L15;
        h(r102, (DateModel) ListProtector.get(r100, 0));
        return;
    L15:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.IconTextUIKit");
        this.f216174e = (IconTextUIKit) r102;
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return new IconTextUIKit(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (DateModel) r101);
    }

    public final void h(View r100, DateModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof IconTextUIKit) == false) goto L12;
        IconTextUIKit r102 = (IconTextUIKit) r100;
        r102.setContent(r101.getText());
        a(r102.getContentTv(), false);
        if (r101.getRemind() == false) goto L10;
        r102.setContentColor(ResourcesCompat.getColor(r102.getContext().getResources(), R.color.primary_fill_default, r102.getContext().getTheme()));
        r102.setRightIconVisible(true);
        Integer r103 = Integer.valueOf(R.color.primary_fill_default);
        if (r103 != null) goto L9;
        r102.f216145b.setImageResource(R.drawable.ud_icon_alarm_clock_filled);
        return;
    L9:
        r102.f216145b.setImageDrawable(com.bytedance.ee.util.ui.l.a(r102.getContext(), R.drawable.ud_icon_alarm_clock_filled, r103.intValue()));
        return;
    L10:
        r102.setContentColor(ResourcesCompat.getColor(r102.getContext().getResources(), R.color.ud_title_color, r102.getContext().getTheme()));
        r102.setRightIconVisible(false);
        return;
    }
}
