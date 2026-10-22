package com.bytedance.android.shopping.new_cart.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ RecyclerView a;

    public h(RecyclerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.Adapter r0 = this.a.getAdapter();     // Catch: Throwable -> L14
        if (r0 == null) goto L17;
        Integer r1 = Integer.valueOf(r0.getItemCount());     // Catch: Throwable -> L14
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L21;
        r1.intValue();     // Catch: Throwable -> L14
        this.a.scrollToPosition(0);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L7:
        r2 = false;
        goto L8
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
