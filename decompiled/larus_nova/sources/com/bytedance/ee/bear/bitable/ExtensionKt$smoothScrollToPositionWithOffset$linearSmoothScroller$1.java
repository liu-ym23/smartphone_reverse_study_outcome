package com.bytedance.ee.bear.bitable;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"com/bytedance/ee/bear/bitable/ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1 extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f206703a;

    public ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1(int r100, Context r101) {
        this.f206703a = r100;
        super(r101);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "action");
        super.onTargetFound(r100, r101, r102);
        int r103 = calculateDxToMakeVisible(r100, getHorizontalSnapPreference());
        int r104 = calculateDyToMakeVisible(r100, -1);
        int r105 = calculateTimeForDeceleration((int) Math.sqrt((r103 * r103) + (r104 * r104)));
        if (r105 <= 0) goto L5;
        r102.update(-r103, (-r104) - this.f206703a, r105, this.mDecelerateInterpolator);
        return;
    L5:
        if (r105 != 0) goto L9;
        r102.update(-r103, (-r104) - this.f206703a, calculateTimeForDeceleration(this.f206703a), this.mDecelerateInterpolator);
        return;
    }
}
