package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lma.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2 extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        int r102 = a.f509903a;
        throw null;
    }
}
