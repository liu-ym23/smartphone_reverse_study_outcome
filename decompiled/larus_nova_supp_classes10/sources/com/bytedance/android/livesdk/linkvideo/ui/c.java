package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ LinkVideoDialog b;

    public c(View r1, LinkVideoDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkVideoDialog r0 = this.b;     // Catch: Throwable -> L4
        r0.M = this.a.getHeight();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
