package com.bytedance.android.shopping.feed.fragment;

import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ProductFeedContentFragment.h a;

    public e(ProductFeedContentFragment.h r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        InflowGuessFeedResponse r3 = (InflowGuessFeedResponse) r2;
        if (r3 == null) goto L6;
        this.a.a.U90().handleResourceCardResp(r3);
        return;
    }
}
