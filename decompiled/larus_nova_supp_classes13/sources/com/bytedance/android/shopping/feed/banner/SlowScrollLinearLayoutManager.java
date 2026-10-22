package com.bytedance.android.shopping.feed.banner;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/feed/banner/SlowScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlowScrollLinearLayoutManager extends LinearLayoutManager {
    public float a;
    public final Context b;

    public final Context getContext() {
        return this.b;
    }

    public SlowScrollLinearLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 0, false);
        this.b = r2;
        this.a = 25.0f;
    }

    public final void smoothScrollToPosition(RecyclerView r2, RecyclerView.State r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        SlowScrollLinearSmoothScroller r5 = new SlowScrollLinearSmoothScroller(r2.getContext(), this.a);
        r5.setTargetPosition(r4);
        startSmoothScroll(r5);
    }
}
