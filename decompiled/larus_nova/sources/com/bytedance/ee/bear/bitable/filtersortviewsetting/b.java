package com.bytedance.ee.bear.bitable.filtersortviewsetting;

import android.view.View;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFilterSortViewSettingPanel f212133c;

    public b(BitableFilterSortViewSettingPanel r100) {
        this.f212133c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BitableFilterSortViewSettingPanel r101 = this.f212133c;
        int r102 = BitableFilterSortViewSettingPanel.P;
        PanelData.TopBarButton r103 = r101.za0().getTopBarButton().getValue();
        if (r103 == null) goto L5;
        String r104 = r103.getBtnAction();
    L6:
        f r105 = this.f212133c.za0().getDelegate();
        if (r105 == null) goto L10;
        r105.a(r104);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
