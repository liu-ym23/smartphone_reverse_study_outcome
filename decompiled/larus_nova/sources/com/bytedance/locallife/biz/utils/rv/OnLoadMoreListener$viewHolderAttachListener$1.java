package com.bytedance.locallife.biz.utils.rv;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/locallife/biz/utils/rv/OnLoadMoreListener$viewHolderAttachListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class OnLoadMoreListener$viewHolderAttachListener$1 implements RecyclerView.OnChildAttachStateChangeListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof RecyclerView.LayoutParams) == false) goto L5;
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getViewAdapterPosition() != 0) goto L10;
        throw null;
    L10:
        throw null;
    L5:
        r102 = null;
        goto L6
    }
}
