package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ TreeAdapter<Object, RecyclerView.ViewHolder> a;

    public a(TreeAdapter<Object, RecyclerView.ViewHolder> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TreeAdapter<Object, RecyclerView.ViewHolder> r0 = this.a;     // Catch: Throwable -> L6
        String r1 = r0.b.getCacheKey();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        ay4.b.d("bitable", 4).putStringSet(r1, r0.d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
