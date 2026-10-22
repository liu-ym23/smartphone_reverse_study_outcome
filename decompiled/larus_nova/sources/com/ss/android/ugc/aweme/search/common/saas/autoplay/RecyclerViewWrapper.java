package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/RecyclerViewWrapper;", "Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/RecyclerViewAbstract;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewWrapper implements RecyclerViewAbstract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f452014a;

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewAbstract
    public final int getOrientation() {
        RecyclerView.LayoutManager r100 = this.f452014a.getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == true) goto L5;
    L7:
        return 0;
    L5:
        if (((LinearLayoutManager) r100).getOrientation() != 0) goto L7;
        return 1;
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewAbstract
    public Context getContext() {
        return RecyclerViewAbstract.DefaultImpls.getContext(this);
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.RecyclerViewAbstract
    public final RecyclerView getRecyclerView() {
        return this.f452014a;
    }

    public RecyclerViewWrapper(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f452014a = r100;
    }

    public final void a(final OnScrollListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f452014a.addOnScrollListener(new RecyclerViewWrapper$addOnScrollListener$1(r100));
    }
}
