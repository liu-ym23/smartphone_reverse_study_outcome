package com.bytedance.android.shopping.orderlist.search.widget.linkedlist;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;

    public c(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.getHeight() != 0) goto L9;
        wg.a.d(this.a, 1);     // Catch: Throwable -> L6
        return;
    }
}
