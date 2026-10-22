package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
    public final /* synthetic */ RecyclerView b;

    public c(SlcBgDecorProjectionOptimizedView r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    L24:
        return;
    L3:
        if (this.a.L == false) goto L5;
        return;
    L5:
        if (this.a.M == true) goto L23;
        RecyclerView.Adapter r0 = this.b.getAdapter();     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        int r1 = r0.getItemCount();     // Catch: Throwable -> L16
    L11:
        SlcBgDecorProjectionOptimizedView.b r2 = this.a.f;     // Catch: Throwable -> L16
        if (r2.a != 0) goto L14;
        r2.a = r1;     // Catch: Throwable -> L16
        r2.notifyDataSetChanged();     // Catch: Throwable -> L16
    L14:
        this.a.w();     // Catch: Throwable -> L16
        return;
    L10:
        r1 = 0;
        goto L11
    }
}
