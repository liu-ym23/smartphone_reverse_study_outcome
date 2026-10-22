package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends com.bytedance.awemeopen.apps.framework.utils.o {
    public final /* synthetic */ AosFeedPagerListFragment<FeedPagerListViewModel> d;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        FragmentActivity r0 = this.d.getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    public e(AosFeedPagerListFragment<FeedPagerListViewModel> r1) {
        this.d = r1;
    }
}
