package com.bytedance.ee.bear.middleground.comment.detail;

import android.view.View;
import com.bytedance.ee.util.ui.k;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.i;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        int[] r1 = new int[2];     // Catch: Throwable -> L10
        r0.getLocationOnScreen(r1);     // Catch: Throwable -> L10
        if (r1[1] != 0) goto L7;
        int r2 = k.e(r0.getContext());     // Catch: Throwable -> L10
    L8:
        r0.setPadding(0, r2, 0, this.a.p);     // Catch: Throwable -> L10
        return;
    L7:
        r2 = 0;
        goto L8
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
