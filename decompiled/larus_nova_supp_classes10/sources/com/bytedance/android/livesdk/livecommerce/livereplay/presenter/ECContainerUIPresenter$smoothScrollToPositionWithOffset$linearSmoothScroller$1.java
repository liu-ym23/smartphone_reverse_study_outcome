package com.bytedance.android.livesdk.livecommerce.livereplay.presenter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/livecommerce/livereplay/presenter/ECContainerUIPresenter$smoothScrollToPositionWithOffset$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECContainerUIPresenter$smoothScrollToPositionWithOffset$linearSmoothScroller$1 extends LinearSmoothScroller {
    public final /* synthetic */ int a;

    public ECContainerUIPresenter$smoothScrollToPositionWithOffset$linearSmoothScroller$1(int r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    public final void onTargetFound(View r3, RecyclerView.State r4, RecyclerView.SmoothScroller.Action r5) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r5, "action");
        super.onTargetFound(r3, r4, r5);
        int r6 = calculateDxToMakeVisible(r3, -1);
        int r7 = calculateDyToMakeVisible(r3, getVerticalSnapPreference());
        int r0 = calculateTimeForDeceleration((int) Math.sqrt((r6 * r6) + (r7 * r7)));
        if (r0 <= 0) goto L6;
        r5.update((-r6) - this.a, -r7, r0, ((LinearSmoothScroller) this).mDecelerateInterpolator);
        return;
    }
}
