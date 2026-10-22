package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y0 implements ECMallFeed.m {
    public final /* synthetic */ ECMallFeedComponent a;

    public y0(ECMallFeedComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.mall.feed.ECMallFeed.m
    public final void a(com.bytedance.android.ec.hybrid.list.util.d r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxLoadResult");
        this.a.n.a(ECMallFeedState.FIRST_SCREEN_LYNX_END);
    }
}
