package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedListSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedListSnapHelper extends PagerSnapHelper {
    public final Context a;

    public final Context getContext() {
        return this.a;
    }

    public ShopFeedListSnapHelper(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        int[] r0 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L5;
        OrientationHelper r1 = OrientationHelper.createHorizontalHelper(r5);
        r0[0] = r1.getDecoratedStart(r6) - r1.getStartAfterPadding();
    L7:
        if (r5.canScrollVertically() == false) goto L9;
        OrientationHelper r7 = OrientationHelper.createVerticalHelper(r5);
        r0[1] = r7.getDecoratedStart(r6) - r7.getStartAfterPadding();
    L10:
        return r0;
    L9:
        r0[1] = 0;
        goto L10
    L5:
        r0[0] = 0;
        goto L7
    }
}
