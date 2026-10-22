package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ TabIndicatorScrollView a;
    public final /* synthetic */ View b;

    public n(TabIndicatorScrollView r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        TabIndicatorScrollView r0 = this.a;
        int r1 = TabIndicatorScrollView.f;
        r0.a();
        View r2 = this.a.a;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
    L12:
        this.a.b();
        return;
    L8:
        if (r2.getMeasuredWidth() <= this.a.getWidth()) goto L12;
        int r3 = (this.b.getLeft() + (this.b.getWidth() / 2)) - (this.a.getWidth() / 2);
        TabIndicatorScrollView r4 = this.a;
        r4.getClass();
        r4.smoothScrollTo(RangesKt.coerceIn(r3, 0, RangesKt.coerceAtLeast(r2.getMeasuredWidth() - r4.getWidth(), 0)), 0);
        this.a.b();
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
