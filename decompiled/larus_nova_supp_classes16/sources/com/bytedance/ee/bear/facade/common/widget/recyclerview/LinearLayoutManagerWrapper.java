package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import eu5.c;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LinearLayoutManagerWrapper extends LinearLayoutManager {
    public LinearLayoutManagerWrapper(Context r1) {
        super(r1);
    }

    public LinearLayoutManagerWrapper(Context r1, int r2) {
        super(r1, 0, false);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.onLayoutChildren(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if (c.a() == true) goto L9;
        a.f("LinearLayoutManagerWrapper", e, false);
        return;
    L9:
        throw e;
    }

    public LinearLayoutManagerWrapper(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
