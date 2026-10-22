package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.view.View;
import com.bytedance.ee.bear.bitable.ddui.model.AddConditionModel;
import com.bytedance.ee.bear.bitable.ddui.model.FilterInfoModel;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFilterPanelFragmentV2 f212094c;

    public b(BitableFilterPanelFragmentV2 r100) {
        this.f212094c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        FilterInfoModel r101 = this.f212094c.M;
        if (r101 == null) goto L7;
        AddConditionModel r102 = r101.getAddCondition();
        if (r102 == null) goto L7;
        String r103 = r102.getOnClick();
    L8:
        BitableFilterPanelFragmentV2 r104 = this.f212094c;
        bs4.b r105 = r104.H;
        if (r105 == null) goto L12;
        r105.q(r104.getComponentType(), r103, null);
        return;
    L12:
        return;
    L7:
        r103 = null;
        goto L8
    }
}
