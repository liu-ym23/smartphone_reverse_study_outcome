package com.bytedance.android.shopping.new_cart.container;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ NewCartActivity a;

    public a0(NewCartActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Activity, com.bytedance.android.shopping.new_cart.container.NewCartActivity] */
    public final void a() {
        eh.b.c(this.a);
        if (OSUtils.isEMUI3_0() == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_1() == true) goto L16;
        int r0 = com.bytedance.android.shopping.anchorv3.utils.b0.a;
        com.bytedance.android.shopping.anchorv3.utils.b0.a(this.a.getWindow());
        ?? r1 = this.a;
        r1.q = ImmersionBar.with(r1);
        ImmersionBar r2 = this.a.q;
        if (r2 == null) goto L14;
        ImmersionBar r3 = r2.statusBarDarkFont(true);
        if (r3 == null) goto L15;
        r3.init();
        return;
    L15:
        return;
    L14:
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
