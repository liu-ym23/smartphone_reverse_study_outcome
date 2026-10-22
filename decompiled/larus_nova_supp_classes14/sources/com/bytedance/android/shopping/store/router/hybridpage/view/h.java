package com.bytedance.android.shopping.store.router.hybridpage.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Runnable {
    public final /* synthetic */ b a;

    public h(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a;     // Catch: Throwable -> L18
        ECHybridListEngine r1 = r0.I3;     // Catch: Throwable -> L18
        if (r1 == null) goto L21;
        ECHybridRecyclerView r2 = r1.b;     // Catch: Throwable -> L18
        if (r2 == null) goto L25;
        HybridProductListManager$attachGoTopListener$listener$1 r3 = r0.W3;     // Catch: Throwable -> L18
        if (r3 == null) goto L26;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();     // Catch: Throwable -> L18
        if ((r4 instanceof LinearLayoutManager) == true) goto L12;
        r4 = null;
    L12:
        LinearLayoutManager r5 = (LinearLayoutManager) r4;     // Catch: Throwable -> L18
        if (r5 == null) goto L15;
        int r6 = r5.findFirstCompletelyVisibleItemPosition();     // Catch: Throwable -> L18
    L16:
        r3.j(r6);     // Catch: Throwable -> L18
        return;
    L15:
        r6 = 0;
        goto L16
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    }
}
