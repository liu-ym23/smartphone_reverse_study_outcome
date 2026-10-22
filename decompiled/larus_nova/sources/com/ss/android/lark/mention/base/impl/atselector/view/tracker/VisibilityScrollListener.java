package com.ss.android.lark.mention.base.impl.atselector.view.tracker;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/view/tracker/VisibilityScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", a.KEY_TRACKER, "Lcom/ss/android/lark/mention/base/impl/atselector/view/tracker/ItemVisibilityTracker;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/view/tracker/ItemVisibilityTracker;)V", GXScroll.TYPE_ON_SCROLLED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "newState", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibilityScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final frb.a f431857a;

    public VisibilityScrollListener(frb.a r100) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_TRACKER);
        this.f431857a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L6;
        this.f431857a.a(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f431857a.a(r100);
    }
}
