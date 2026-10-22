package com.bytedance.awemeopen.apps.framework.feed.home.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerAdapter;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import f04.a;
import hz3.b;
import hz3.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedHomePresenter extends a<Unit> {
    public final AosFeedsHomeFragment d;
    public final FeedHomeContainerViewModel e;
    public final String f;
    public final RtlViewPager g;

    @Override // f04.a
    public final void k() {
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.e.getScrollable().observe(this.d, new hz3.a(this));
        this.e.getEnableSwipeRight().observe(this.d, new b(this));
        this.e.getEnableSwipeLeft().observe(this.d, new c(this));
    }

    public FeedHomePresenter(View r2, AosFeedsHomeFragment r3, FeedHomeContainerViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentView");
        Intrinsics.checkNotNullParameter(r3, "homeFragment");
        Intrinsics.checkNotNullParameter(r4, "homeContainerViewModel");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = "FeedHomePresenter";
        RtlViewPager r5 = (RtlViewPager) i(2131363039);
        this.g = r5;
        r5.setAdapter(new FeedHomeContainerAdapter(r3, r4));
        r5.b(new AnonymousClass1(this));
    }
}
