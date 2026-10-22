package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import eu5.c;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class LinearLayoutManagerWrapper extends LinearLayoutManager {
    public LinearLayoutManagerWrapper(Context r100) {
        super(r100);
    }

    public LinearLayoutManagerWrapper(Context r100, int r101) {
        super(r100, 0, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if (c.a() == true) goto L9;
        a.f("LinearLayoutManagerWrapper", e, false);
        return;
    L9:
        throw e;
    }

    public LinearLayoutManagerWrapper(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
