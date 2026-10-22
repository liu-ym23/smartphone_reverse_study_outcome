package com.ss.android.lark.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public class StableLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103, boolean r104) {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        Log.e("StableLayoutManager", "onLayoutChildren failed: throw IndexOutOfBoundsException");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        super.scrollHorizontallyBy(r100, r101, r102);     // Catch: IndexOutOfBoundsException -> L4
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public StableLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
