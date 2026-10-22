package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.app.Activity;
import android.content.Context;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends o {
    public final /* synthetic */ AosFeedPagerListLayout<FeedPagerListViewModel> d;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        if ((this.d.getContext() instanceof Activity) == false) goto L6;
        Context r0 = this.d.getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r0).finish();
        return;
    }

    public a(AosFeedPagerListLayout<FeedPagerListViewModel> r1) {
        this.d = r1;
    }
}
