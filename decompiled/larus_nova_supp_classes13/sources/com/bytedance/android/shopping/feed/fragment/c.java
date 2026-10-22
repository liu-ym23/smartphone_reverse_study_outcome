package com.bytedance.android.shopping.feed.fragment;

import android.content.Context;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ProductFeedContentFragment a;

    public c(ProductFeedContentFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        TrackerProvider.a r0 = TrackerProvider.Companion;
        Context r1 = this.a.requireContext();
        int r2 = o1.b;
        o1 r6 = o1.a.a((AnchorV3Param) r5, BtmSDK.INSTANCE.getPageId(PageFinder.via(this.a)));
        r0.getClass();
        TrackerProvider.a.a(r1, r6);
    }
}
