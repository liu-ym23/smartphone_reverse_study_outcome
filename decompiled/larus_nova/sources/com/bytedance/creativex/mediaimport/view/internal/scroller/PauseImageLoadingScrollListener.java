package com.bytedance.creativex.mediaimport.view.internal.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/scroller/PauseImageLoadingScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "imageLoadingSwitcher", "Lcom/bytedance/creativex/mediaimport/view/internal/scroller/ImageLoadingSwitcher;", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/scroller/ImageLoadingSwitcher;)V", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PauseImageLoadingScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi4.b f204033a;

    public PauseImageLoadingScrollListener(xi4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "imageLoadingSwitcher");
        this.f204033a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r101 != 0) goto L5;
    L10:
        this.f204033a.a();
        return;
    L5:
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L13;
        this.f204033a.b();
        return;
    }
}
