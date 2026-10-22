package com.larus.bmhome.bigimg;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/bigimg/RecyclerViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "targetPos", "", "onComplete", "Lkotlin/Function0;", "", "<init>", "(ILkotlin/jvm/functions/Function0;)V", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (r101 != 0) goto L12;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = r103.findLastVisibleItemPosition();
        boolean r106 = false;
        if (r104 > 0) goto L8;
        if (r105 < 0) goto L8;
        r106 = true;
    L8:
        if (r106 == false) goto L13;
        r100.removeOnScrollListener(this);
        throw null;
    L13:
        return;
    }
}
