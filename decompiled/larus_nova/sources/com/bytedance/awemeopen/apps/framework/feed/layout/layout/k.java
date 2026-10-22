package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements LoadMoreFrameLayout.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AosPagerListLayout<Object, AosPagerListViewModel<Object>> f194902a;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onHide() {
        this.f194902a.G();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onShow() {
        AosPagerListLayout<Object, AosPagerListViewModel<Object>> r100 = this.f194902a;
        r100.f194863i = true;
        r100.H();
    }

    public k(AosPagerListLayout<Object, AosPagerListViewModel<Object>> r100) {
        this.f194902a = r100;
    }
}
