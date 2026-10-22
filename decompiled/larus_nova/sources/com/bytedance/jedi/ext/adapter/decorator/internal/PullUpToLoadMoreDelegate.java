package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/decorator/internal/PullUpToLoadMoreDelegate;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "getMyRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "myRecyclerView", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class PullUpToLoadMoreDelegate implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f250982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f250984c;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L6;
        this.f250982a = r101.getY();
        this.f250983b = true;
    L6:
        throw null;
    }
}
