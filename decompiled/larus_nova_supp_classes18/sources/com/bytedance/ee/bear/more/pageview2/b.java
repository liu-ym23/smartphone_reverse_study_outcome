package com.bytedance.ee.bear.more.pageview2;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ PageViewFragment.b b;

    @Override // java.lang.Runnable
    public final void run() {
        PageViewFragment r0 = this.b.E;     // Catch: Throwable -> L4
        r0.y = x08.a.a(this.a, 2131887769);     // Catch: Throwable -> L4
        this.b.E.y.show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(PageViewFragment.b r1, FragmentActivity r2) {
        this.b = r1;
        this.a = r2;
    }
}
