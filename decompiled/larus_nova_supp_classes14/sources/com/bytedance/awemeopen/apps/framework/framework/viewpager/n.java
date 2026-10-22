package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements DoubleBallSwipeRefreshLayout.h {
    public final /* synthetic */ AosPagerListFragment<Object, AosPagerListViewModel<Object>> a;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshStartManually() {
        com.bytedance.awemeopen.apps.framework.base.view.refresh.o r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onRefreshStartManually();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndRefresh() {
        com.bytedance.awemeopen.apps.framework.base.view.refresh.o r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onReleaseAndRefresh();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onRefreshFinish() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.o r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onRefreshFinish();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onReleaseAndScrollBack() {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.o r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onReleaseAndScrollBack();
    }

    public n(AosPagerListFragment<Object, AosPagerListViewModel<Object>> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.h
    public final void onOverScroll(float r2, float r3) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.o r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingAnimationHelper");
        r0 = null;
    L5:
        r0.onOverScroll(r2, r3);
    }
}
