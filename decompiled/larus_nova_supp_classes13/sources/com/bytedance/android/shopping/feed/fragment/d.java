package com.bytedance.android.shopping.feed.fragment;

import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ProductFeedContentFragment.h a;

    public d(ProductFeedContentFragment.h r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        InflowGuessFeedResponse r4 = (InflowGuessFeedResponse) r3;
        if (r4 == null) goto L5;
        this.a.a.U90().handleGuessULikeResp(r4, false);
        return;
    L5:
        this.a.a.U90().handleGuessULikeRespError("Preload error");
    }
}
