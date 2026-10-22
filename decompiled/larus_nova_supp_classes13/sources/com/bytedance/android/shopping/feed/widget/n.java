package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.view.InflowSkuThumbnail;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ InflowSkuThumbnail a;
    public final /* synthetic */ InflowSkuWidget b;
    public final /* synthetic */ rd3.a c;

    public n(InflowSkuThumbnail r1, InflowSkuWidget r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Context r4 = this.a.getContext();
        rd3.a r0 = this.c;
        if (r4 == null) goto L6;
        if (r0 == null) goto L6;
        FeedProductEventTracker.a.getClass();
        FeedProductEventTracker.B(r4, r0);
    L6:
        this.b.a("main_pic");
        VideoProductFeedBanner r5 = this.b.c;
        if (r5 == null) goto L16;
        List<? extends ECUrlModel> r1 = r5.h;
        if (r1 == null) goto L11;
        int r2 = r1.size();
    L12:
        if (r2 <= 0) goto L17;
        r5.a.scrollToPosition(0);
        return;
    L17:
        return;
    L11:
        r2 = 0;
        goto L12
    }
}
