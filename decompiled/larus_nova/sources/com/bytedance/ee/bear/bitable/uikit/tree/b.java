package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TreeAdapter<Object, RecyclerView.ViewHolder> f216257a;

    public b(TreeAdapter<Object, RecyclerView.ViewHolder> r100) {
        this.f216257a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TreeAdapter<Object, RecyclerView.ViewHolder> r100 = this.f216257a;     // Catch: Throwable -> L6
        int r101 = TreeAdapter.f216230p;     // Catch: Throwable -> L6
        if (r100.f216236f == false) goto L9;
        r100.f216236f = false;     // Catch: Throwable -> L6
        TreeAdapter.L2(r100, true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
