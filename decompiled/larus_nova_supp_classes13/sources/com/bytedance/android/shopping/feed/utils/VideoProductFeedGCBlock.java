package com.bytedance.android.shopping.feed.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/utils/VideoProductFeedGCBlock;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedGCBlock extends RecyclerView.OnScrollListener {
    public boolean a;

    public VideoProductFeedGCBlock() {
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        int r4 = ph.a.a;
        this.a = false;
        return;
    L9:
        if (this.a == true) goto L13;
        int r5 = ph.a.a;
        this.a = true;
        return;
    }
}
