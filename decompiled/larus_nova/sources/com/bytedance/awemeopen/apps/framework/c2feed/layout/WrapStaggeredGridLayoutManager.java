package com.bytedance.awemeopen.apps.framework.c2feed.layout;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import by3.a;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.Adapter f193813a;

    public final IndexOutOfBoundsException p(IndexOutOfBoundsException r100) {
        if (this.f193813a == null) goto L6;
        IndexOutOfBoundsException r101 = new IndexOutOfBoundsException(this.f193813a.getClass().getName());
        r101.initCause(r100);
        return r101;
    L6:
        return r100;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        super.onAdapterChanged(r100, r101);
        this.f193813a = r101;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: NullPointerException -> L5 IllegalArgumentException -> L12 IndexOutOfBoundsException -> L19
    L31:
        return;
    L12:
        e = e;
        if (this.f193813a == null) goto L28;
        Object[] r102 = new Object[2];
        r102[0] = this.f193813a.getClass().getName();
        if (this.f193813a == null) goto L18;
        e = new IllegalArgumentException(this.f193813a.getClass().getName(), e);
    L18:
        r102[1] = e;
        AoLogger.c("CrashlyticsWrapper", r102);
        return;
    L28:
        return;
    L19:
        e = move-exception;
        if (this.f193813a == null) goto L30;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), p(e)});
        return;
    L30:
        return;
    L5:
        e = move-exception;
        if (this.f193813a == null) goto L26;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), e});
        RecyclerView.Adapter r103 = this.f193813a;
        if (r103 == null) goto L32;
        a r104 = new a(r103);
        AoPool r105 = AoPool.f198803a;
        Intrinsics.checkNotNullParameter(r104, "task");
        AoPool.f198803a.getClass();
        AoPool.c().c(r104);
        return;
    L32:
        return;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollHorizontallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        if (this.f193813a == null) goto L8;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), p(e)});
    L8:
        return 0;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L13:
        e = move-exception;
        if (this.f193813a == null) goto L17;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), p(e)});
    L17:
        return 0;
    L5:
        e = move-exception;
        if (this.f193813a == null) goto L12;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), e});
        RecyclerView.Adapter r103 = this.f193813a;
        if (r103 == null) goto L12;
        a r104 = new a(r103);
        AoPool r105 = AoPool.f198803a;
        Intrinsics.checkNotNullParameter(r104, "task");
        AoPool.f198803a.getClass();
        AoPool.c().c(r104);
    L12:
        return 0;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View onFocusSearchFailed(View r100, int r101, RecyclerView.Recycler r102, RecyclerView.State r103) {
        return super.onFocusSearchFailed(r100, r101, r102, r103);
    L4:
        e = move-exception;
        if (this.f193813a == null) goto L12;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.f193813a.getClass().getName(), p(e)});
        return null;
    L12:
        return null;
    }
}
