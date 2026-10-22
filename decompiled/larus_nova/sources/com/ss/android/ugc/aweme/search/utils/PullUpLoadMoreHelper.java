package com.ss.android.ugc.aweme.search.utils;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/PullUpLoadMoreHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "motionEvent");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.getAction() != 0) goto L7;
        r101.getY();
        return false;
    L7:
        return false;
    }
}
