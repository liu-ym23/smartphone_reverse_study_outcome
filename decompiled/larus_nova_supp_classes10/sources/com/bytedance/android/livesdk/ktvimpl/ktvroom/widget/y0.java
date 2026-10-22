package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y0 implements Runnable {
    public final /* synthetic */ View a;

    public y0(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setVisibility(8);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
