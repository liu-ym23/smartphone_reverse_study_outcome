package com.bytedance.android.shopping.slice.elements.shoprecommend;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;

    public b(a r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [android.widget.HorizontalScrollView, ki3.a] */
    public final void a() {
        if (this.a.getChildCount() > 0) goto L5;
        return;
    L5:
        if (com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.a), 0)).size() <= this.b) goto L14;
        Object r0 = ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.a), 0)), this.b)), 0);
        if ((r0 instanceof ki3.a) == true) goto L9;
        r0 = null;
    L9:
        ?? r1 = (ki3.a) r0;
        if (r1 == 0) goto L15;
        r1.scrollTo(r1.k, 0);
        return;
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
