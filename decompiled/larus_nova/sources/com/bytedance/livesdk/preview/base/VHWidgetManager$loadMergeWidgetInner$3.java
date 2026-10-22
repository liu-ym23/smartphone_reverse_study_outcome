package com.bytedance.livesdk.preview.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/livesdk/preview/base/VHWidgetManager$loadMergeWidgetInner$3", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VHWidgetManager$loadMergeWidgetInner$3 implements AsyncLayoutInflater.OnInflateFinishedListener {
    public VHWidgetManager$loadMergeWidgetInner$3() {
        throw null;
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        VHWidgetManager.S90(null, null);
        throw null;
    }
}
