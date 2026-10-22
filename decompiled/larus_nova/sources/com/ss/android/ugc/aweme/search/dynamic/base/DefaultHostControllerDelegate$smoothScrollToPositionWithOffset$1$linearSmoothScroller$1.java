package com.ss.android.ugc.aweme.search.dynamic.base;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/dynamic/base/DefaultHostControllerDelegate$smoothScrollToPositionWithOffset$1$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultHostControllerDelegate$smoothScrollToPositionWithOffset$1$linearSmoothScroller$1 extends LinearSmoothScroller {
    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "action");
        super.onTargetFound(r100, r101, r102);
        int r103 = calculateDxToMakeVisible(r100, getHorizontalSnapPreference());
        int r104 = calculateDyToMakeVisible(r100, -1);
        int r105 = calculateTimeForDeceleration((int) Math.sqrt((r103 * r103) + (r104 * r104)));
        if (r105 <= 0) goto L6;
        r102.update(-r103, (-r104) + 0, r105, this.mDecelerateInterpolator);
        return;
    }
}
