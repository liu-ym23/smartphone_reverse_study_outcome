package com.bytedance.ee.bear.document.print;

import android.view.View;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ CommonActionPanelLayout c;

    public e(View r1, float r2, CommonActionPanelLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L3:
        if (this.a.isAttachedToWindow() == false) goto L16;
        float r0 = this.a.getMeasuredHeight();     // Catch: Throwable -> L13
        if (r0 != 0.0f) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r0 = this.b;     // Catch: Throwable -> L13
    L11:
        this.c.l(0.0f, r0, r0);     // Catch: Throwable -> L13
        return;
    L8:
        r2 = false;
        goto L9
    }
}
