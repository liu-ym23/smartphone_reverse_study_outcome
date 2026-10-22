package com.ss.android.ugc.aweme.discover.commodity.holder.optimize;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.handler.StickyHeaderHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/discover/commodity/holder/optimize/BaseStickyViewHolder$mOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseStickyViewHolder$mOnScrollListener$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f450244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseStickyViewHolder f450245b;

    public BaseStickyViewHolder$mOnScrollListener$1(BaseStickyViewHolder r100) {
        this.f450245b = r100;
        this.f450244a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        View r103 = this.f450245b.g4();
        if (r103 != null) goto L5;
        return;
    L5:
        ViewGroup r104 = StickyHeaderHandler.b(r100);
        if (r104 != null) goto L9;
        return;
    L9:
        if (this.f450244a == false) goto L13;
        BaseStickyViewHolder r105 = this.f450245b;
        r105.f450238j = false;
        this.f450244a = false;
        if (BaseStickyViewHolder.b4(r105, r100) == false) goto L13;
        return;
    L13:
        float r106 = r104.getTranslationY() - r102;
        if (r102 <= 0) goto L23;
        if (r106 >= 0) goto L21;
        BaseStickyViewHolder r107 = this.f450245b;
        if (r107.f450238j == true) goto L20;
        r107.f450238j = true;
    L20:
        r104.setTranslationY(0.0f);
        return;
    L21:
        r104.setTranslationY(r106);
        return;
    L23:
        if (r106 > 0) goto L25;
        return;
    L25:
        if (this.f450245b.f450238j == true) goto L27;
        return;
    L27:
        if (r103.getTop() > (this.f450245b.f450237i + r102)) goto L34;
        r104.setTranslationY(r106);
        return;
    }
}
