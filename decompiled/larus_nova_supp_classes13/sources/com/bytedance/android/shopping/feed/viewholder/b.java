package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.widget.InflowSkuWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ InflowSkuThumbnailVH a;
    public final /* synthetic */ rd3.a b;
    public final /* synthetic */ InflowSkuWidget c;

    public b(InflowSkuThumbnailVH r1, rd3.a r2, InflowSkuWidget r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Context r0 = ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        rd3.a r1 = this.b;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        FeedProductEventTracker.a.getClass();
        FeedProductEventTracker.B(r0, r1);
    L6:
        InflowSkuWidget r2 = this.c;
        if (r2 == null) goto L10;
        r2.a(r4.getTag().toString());
        return;
    }
}
