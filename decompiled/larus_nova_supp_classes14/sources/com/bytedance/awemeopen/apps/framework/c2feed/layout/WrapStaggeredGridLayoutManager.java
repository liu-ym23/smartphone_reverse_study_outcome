package com.bytedance.awemeopen.apps.framework.c2feed.layout;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import by3.a;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public RecyclerView.Adapter a;

    public final IndexOutOfBoundsException p(IndexOutOfBoundsException r3) {
        if (this.a == null) goto L6;
        IndexOutOfBoundsException r0 = new IndexOutOfBoundsException(this.a.getClass().getName());
        r0.initCause(r3);
        return r0;
    L6:
        return r3;
    }

    public final void onAdapterChanged(RecyclerView.Adapter r1, RecyclerView.Adapter r2) {
        super.onAdapterChanged(r1, r2);
        this.a = r2;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r6) {
        super.onLayoutChildren(r5, r6);     // Catch: NullPointerException -> L5 IllegalArgumentException -> L12 IndexOutOfBoundsException -> L19
    L31:
        return;
    L12:
        e = e;
        if (this.a == null) goto L28;
        Object[] r7 = new Object[2];
        r7[0] = this.a.getClass().getName();
        if (this.a == null) goto L18;
        e = new IllegalArgumentException(this.a.getClass().getName(), e);
    L18:
        r7[1] = e;
        AoLogger.c("CrashlyticsWrapper", r7);
        return;
    L28:
        return;
    L19:
        e = move-exception;
        if (this.a == null) goto L30;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), p(e)});
        return;
    L30:
        return;
    L5:
        e = move-exception;
        if (this.a == null) goto L26;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), e});
        RecyclerView.Adapter r8 = this.a;
        if (r8 == null) goto L32;
        a r9 = new a(r8);
        AoPool r10 = AoPool.a;
        Intrinsics.checkNotNullParameter(r9, "task");
        AoPool.a.getClass();
        AoPool.c().c(r9);
        return;
    L32:
        return;
    }

    public final int scrollHorizontallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        return super.scrollHorizontallyBy(r2, r3, r4);
    L4:
        e = move-exception;
        if (this.a == null) goto L8;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), p(e)});
    L8:
        return 0;
    }

    public final int scrollVerticallyBy(int r5, RecyclerView.Recycler r6, RecyclerView.State r7) {
        return super.scrollVerticallyBy(r5, r6, r7);
    L13:
        e = move-exception;
        if (this.a == null) goto L17;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), p(e)});
    L17:
        return 0;
    L5:
        e = move-exception;
        if (this.a == null) goto L12;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), e});
        RecyclerView.Adapter r8 = this.a;
        if (r8 == null) goto L12;
        a r9 = new a(r8);
        AoPool r10 = AoPool.a;
        Intrinsics.checkNotNullParameter(r9, "task");
        AoPool.a.getClass();
        AoPool.c().c(r9);
    L12:
        return 0;
    }

    public final View onFocusSearchFailed(View r1, int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        return super.onFocusSearchFailed(r1, r2, r3, r4);
    L4:
        e = move-exception;
        if (this.a == null) goto L12;
        AoLogger.c("CrashlyticsWrapper", new Object[]{this.a.getClass().getName(), p(e)});
        return null;
    L12:
        return null;
    }
}
