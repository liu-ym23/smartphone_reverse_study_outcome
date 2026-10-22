package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ScreenMenuLayout b;

    public q(ScreenMenuLayout r1, ScreenMenuLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenMenuLayout.b(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
