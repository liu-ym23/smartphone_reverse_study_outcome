package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: classes14.dex */
public class WrapLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.Adapter f197000a;

    public WrapLinearLayoutManager(Context r100) {
        super(r100);
    }

    public final IndexOutOfBoundsException p(IndexOutOfBoundsException r100) {
        if (this.f197000a == null) goto L6;
        IndexOutOfBoundsException r101 = new IndexOutOfBoundsException(this.f197000a.getClass().getName());
        r101.initCause(r100);
        return r101;
    L6:
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        super.onAdapterChanged(r100, r101);
        this.f197000a = r101;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: IllegalArgumentException -> L5 IndexOutOfBoundsException -> L12
    L22:
        return;
    L5:
        e = e;
        if (this.f197000a == null) goto L19;
        String r102 = this.f197000a.getClass().getName();
        Object[] r103 = new Object[1];
        if (this.f197000a == null) goto L11;
        e = new IllegalArgumentException(this.f197000a.getClass().getName(), e);
    L11:
        r103[0] = e;
        AoLogger.h(r102, r103);
        return;
    L19:
        return;
    L12:
        e = move-exception;
        if (this.f197000a == null) goto L21;
        AoLogger.h(this.f197000a.getClass().getName(), new Object[]{p(e)});
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollHorizontallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        if (this.f197000a == null) goto L8;
        AoLogger.h(this.f197000a.getClass().getName(), new Object[]{p(e)});
    L8:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        if (this.f197000a == null) goto L8;
        AoLogger.h(this.f197000a.getClass().getName(), new Object[]{p(e)});
    L8:
        return 0;
    }

    public WrapLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
