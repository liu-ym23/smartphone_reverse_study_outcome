package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ TreeAdapter<Object, RecyclerView.ViewHolder> a;

    public b(TreeAdapter<Object, RecyclerView.ViewHolder> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TreeAdapter<Object, RecyclerView.ViewHolder> r0 = this.a;     // Catch: Throwable -> L6
        int r1 = TreeAdapter.p;     // Catch: Throwable -> L6
        if (r0.f == false) goto L9;
        r0.f = false;     // Catch: Throwable -> L6
        TreeAdapter.L2(r0, true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
