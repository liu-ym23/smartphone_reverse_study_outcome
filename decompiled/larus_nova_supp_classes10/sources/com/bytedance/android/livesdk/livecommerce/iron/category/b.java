package com.bytedance.android.livesdk.livecommerce.iron.category;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ CategoryRecyclerView a;
    public final /* synthetic */ int b;

    public b(CategoryRecyclerView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CategoryListAdapter r0 = this.a.a;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        int r1 = this.b;     // Catch: Throwable -> L8
        if (r0.e == r1) goto L15;
        r0.e = r1;     // Catch: Throwable -> L8
        r0.notifyItemRangeChanged(0, r0.getItemCount(), new CategoryListAdapter.a(r1));     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
