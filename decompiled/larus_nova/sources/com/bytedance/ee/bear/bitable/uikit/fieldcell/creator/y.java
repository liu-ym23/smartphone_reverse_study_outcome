package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconCapsuleModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.UserItemView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class y extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<IconCapsuleModel> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.User.getValue();
    }

    public y(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return new UserItemView(r100, null, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r100, h0 r101) {
        IconCapsuleModel r102 = (IconCapsuleModel) r101;
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof UserItemView) == false) goto L8;
        UserItemView r103 = (UserItemView) r100;
        a(r103.getContentView(), true);
        r103.f216203a = r102;
        if (r102 == null) goto L9;
        r103.f216204b.f211065c.setText(r102.getText());
        com.bytedance.ee.bear.bitable.common.h.a(r103.getContext(), r102.getAvatarUrl(), null, r103.f216204b.f211064b);
        return;
    L9:
        return;
    }
}
