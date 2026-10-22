package com.bytedance.android.shopping.utils.gallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.k1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ e a;

    public c(e r1) {
        this.a = r1;
    }

    public final void a() {
        View r0 = this.a.a;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L15;
        Context r3 = this.a.i;
        if (r3 == null) goto L13;
        Rect r4 = new Rect();
        k1.b(((Activity) r3).getWindow()).getWindowVisibleDisplayFrame(r4);
        r2.topMargin = ((r4.height() + this.a.h) / 2) + com.bytedance.android.shopping.extensions.b.b(36);
        r0.setLayoutParams(r2);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L15:
        return;
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
