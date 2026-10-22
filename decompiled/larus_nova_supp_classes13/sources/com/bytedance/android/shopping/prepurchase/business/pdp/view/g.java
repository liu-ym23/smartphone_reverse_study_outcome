package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    public g(View r1, int r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Rect r0 = new Rect();
        this.a.getHitRect(r0);
        int r1 = r0.top;
        int r2 = this.b;
        r0.top = r1 - r2;
        r0.bottom += r2;
        this.c.setTouchDelegate(new TouchDelegate(r0, this.a));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
