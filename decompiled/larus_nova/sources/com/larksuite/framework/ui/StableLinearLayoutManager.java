package com.larksuite.framework.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes24.dex */
public class StableLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f285829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f285830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f285831c;

    public void p(Throwable r100) {
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void requestLayout() {
        if (this.f285831c == false) goto L5;
        return;
    L5:
        super.requestLayout();
    }

    public StableLinearLayoutManager(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        b r101 = this.f285830b;
        if (r101 == null) goto L6;
        r101.onLayoutComplete();
        return;
    }

    public StableLinearLayoutManager(Context r100, Object r101) {
        super(r100, 1, false);
        this.f285829a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (r101 != null) goto L5;
        p(new NullPointerException("RecyclerView.State is null during layout"));
        return;
    L5:
        b r102 = this.f285830b;
        if (r102 == null) goto L15;
        r102.a();
    L15:
        super.onLayoutChildren(r100, r101);     // Catch: IndexOutOfBoundsException -> L10
    L12:
        if (r102 == null) goto L17;
        r102.b();
        return;
    L17:
        return;
    L10:
        e = move-exception;
        p(e);
        goto L12
    }

    public StableLinearLayoutManager(Context r100, int r101) {
        super(r100, 1, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        super.scrollHorizontallyBy(r100, r101, r102);     // Catch: IndexOutOfBoundsException -> L4
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        p(e);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        e.printStackTrace();
        p(e);
        return 0;
    }

    public StableLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103) {
        if (this.f285829a == true) goto L5;
        return false;
    L5:
        return super.requestChildRectangleOnScreen(r100, r101, r102, r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103, boolean r104) {
        if (this.f285829a == true) goto L5;
        return false;
    L5:
        return super.requestChildRectangleOnScreen(r100, r101, r102, r103, r104);
    }
}
