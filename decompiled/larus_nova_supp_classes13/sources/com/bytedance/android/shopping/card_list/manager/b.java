package com.bytedance.android.shopping.card_list.manager;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ Boolean b;

    public b(c r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c r0 = this.a;     // Catch: Throwable -> L19
        View r1 = r0.a;     // Catch: Throwable -> L19
        if (r1 == null) goto L23;
        r0.c = r1.getHeight();     // Catch: Throwable -> L19
        View r2 = this.a.g;     // Catch: Throwable -> L19
        if (r2 == null) goto L10;
        List r3 = com.bytedance.commerce.base.view.b.a(r2);     // Catch: Throwable -> L19
        if (r3 == null) goto L10;
        if ((!r3.isEmpty()) != true) goto L10;
        return;
    L10:
        View r4 = this.a.f;     // Catch: Throwable -> L19
        if (r4 == null) goto L17;
        List r5 = com.bytedance.commerce.base.view.b.a(r4);     // Catch: Throwable -> L19
        if (r5 == null) goto L17;
        if ((!r5.isEmpty()) != true) goto L17;
        return;
    L17:
        c.a(this.a, this.b);     // Catch: Throwable -> L19
        return;
    L23:
        return;
    }
}
