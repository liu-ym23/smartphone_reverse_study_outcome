package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TreeAdapter<Object, RecyclerView.ViewHolder> f216256a;

    public a(TreeAdapter<Object, RecyclerView.ViewHolder> r100) {
        this.f216256a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TreeAdapter<Object, RecyclerView.ViewHolder> r100 = this.f216256a;     // Catch: Throwable -> L6
        String r101 = r100.f216232b.getCacheKey();     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        ay4.b.d(DocumentType.BITABLE_NAME, 4).putStringSet(r101, r100.f216234d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
