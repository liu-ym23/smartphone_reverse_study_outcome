package com.bytedance.ee.bear.bitable.filtersortviewsetting;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFilterSortViewSettingPanel f212134a;

    public c(BitableFilterSortViewSettingPanel r100) {
        this.f212134a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PanelData.TopBarButton r101 = (PanelData.TopBarButton) r100;
        BitableFilterSortViewSettingPanel r102 = this.f212134a;
        Intrinsics.checkNotNull(r101);
        int r103 = BitableFilterSortViewSettingPanel.P;
        r102.Ca0(r101);
    }
}
