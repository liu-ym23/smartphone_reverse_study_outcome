package com.bytedance.locallife.poi.dito.poi.component;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CenterLayoutManager extends LinearLayoutManager {
    public CenterLayoutManager(Context r100) {
        super(r100, 0, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "state");
        CenterSmoothScroller r103 = new CenterSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
