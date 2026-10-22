package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.o;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements DoubleBallSwipeRefreshLayout.h {
    public final /* synthetic */ AosPagerListLayout<Object, AosPagerListViewModel<Object>> a;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshStartManually() {
        o r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onRefreshStartManually();
        b54.a r1 = this.a.getSwipeChangeListener();
        if (r1 == null) goto L9;
        r1.onRefreshStartManually();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndRefresh() {
        o r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onReleaseAndRefresh();
        b54.a r1 = this.a.getSwipeChangeListener();
        if (r1 == null) goto L9;
        r1.onReleaseAndRefresh();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshFinish() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        o r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onRefreshFinish();
        b54.a r1 = this.a.getSwipeChangeListener();
        if (r1 == null) goto L9;
        r1.onRefreshFinish();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndScrollBack() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        o r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onReleaseAndScrollBack();
        b54.a r1 = this.a.getSwipeChangeListener();
        if (r1 == null) goto L9;
        r1.onReleaseAndScrollBack();
        return;
    }

    public l(AosPagerListLayout<Object, AosPagerListViewModel<Object>> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onOverScroll(float r2, float r3) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        o r0 = this.a.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onOverScroll(r2, r3);
        b54.a r1 = this.a.getSwipeChangeListener();
        if (r1 == null) goto L9;
        r1.onOverScroll(r2, r3);
        return;
    }
}
