package com.ss.android.ugc.live.async_pre_layout_view;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.collection.SparseArrayCompat;
import dhc.a;
import java.util.Queue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/live/async_pre_layout_view/AsyncPreLayoutManager$asyncLayoutInflate$1", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "async_pre_layout_view_release"}, k = 1, mv = {1, 4, 0})
public final class AsyncPreLayoutManager$asyncLayoutInflate$1 implements AsyncLayoutInflater.OnInflateFinishedListener {
    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        SparseArrayCompat<Integer> r103 = a.f468668a;
        Integer r104 = a.f468668a.get(0);
        if (r104 == null) goto L5;
        r104.intValue();
    L5:
        Queue<View> r105 = a.f468669b.get(0);
        if (r105 == null) goto L9;
        r105.offer(r100);
        return;
    }
}
