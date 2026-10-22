package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements LoadMoreFrameLayout.f {
    public final /* synthetic */ AosPagerListLayout<Object, AosPagerListViewModel<Object>> a;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onHide() {
        this.a.G();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout.f
    public final void onShow() {
        AosPagerListLayout<Object, AosPagerListViewModel<Object>> r0 = this.a;
        r0.i = true;
        r0.H();
    }

    public k(AosPagerListLayout<Object, AosPagerListViewModel<Object>> r1) {
        this.a = r1;
    }
}
