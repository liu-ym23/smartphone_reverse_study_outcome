package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class WrapLinearLayoutManager extends LinearLayoutManager {
    public RecyclerView.Adapter a;

    public WrapLinearLayoutManager(Context r1) {
        super(r1);
    }

    public final IndexOutOfBoundsException p(IndexOutOfBoundsException r3) {
        if (this.a == null) goto L6;
        IndexOutOfBoundsException r0 = new IndexOutOfBoundsException(this.a.getClass().getName());
        r0.initCause(r3);
        return r0;
    L6:
        return r3;
    }

    public final void onAdapterChanged(RecyclerView.Adapter r1, RecyclerView.Adapter r2) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onAdapterChanged(r1, r2);
        this.a = r2;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r6) {
        super.onLayoutChildren(r5, r6);     // Catch: IllegalArgumentException -> L5 IndexOutOfBoundsException -> L12
    L22:
        return;
    L5:
        e = e;
        if (this.a == null) goto L19;
        String r7 = this.a.getClass().getName();
        Object[] r1 = new Object[1];
        if (this.a == null) goto L11;
        e = new IllegalArgumentException(this.a.getClass().getName(), e);
    L11:
        r1[0] = e;
        AoLogger.h(r7, r1);
        return;
    L19:
        return;
    L12:
        e = move-exception;
        if (this.a == null) goto L21;
        AoLogger.h(this.a.getClass().getName(), new Object[]{p(e)});
        return;
    }

    public final int scrollHorizontallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        return super.scrollHorizontallyBy(r2, r3, r4);
    L4:
        e = move-exception;
        if (this.a == null) goto L8;
        AoLogger.h(this.a.getClass().getName(), new Object[]{p(e)});
    L8:
        return 0;
    }

    public final int scrollVerticallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        return super.scrollVerticallyBy(r2, r3, r4);
    L4:
        e = move-exception;
        if (this.a == null) goto L8;
        AoLogger.h(this.a.getClass().getName(), new Object[]{p(e)});
    L8:
        return 0;
    }

    public WrapLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
