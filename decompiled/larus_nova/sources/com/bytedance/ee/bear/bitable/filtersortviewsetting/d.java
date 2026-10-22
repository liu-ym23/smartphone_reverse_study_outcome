package com.bytedance.ee.bear.bitable.filtersortviewsetting;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFilterSortViewSettingPanel f212135a;

    public d(BitableFilterSortViewSettingPanel r100) {
        this.f212135a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        tt5.a.b("FilterSortViewSettingPanel", "currentTab observe " + r101);
        BitableFilterSortViewSettingPanel r102 = this.f212135a;
        int r103 = BitableFilterSortViewSettingPanel.P;
        r102.Ba0(r101, r102.za0().getAllTabs().getValue());
    }
}
