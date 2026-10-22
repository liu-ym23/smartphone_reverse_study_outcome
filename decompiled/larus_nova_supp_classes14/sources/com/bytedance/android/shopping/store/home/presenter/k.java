package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements Runnable {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public k(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void a() {
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r1 = ECShopBackgroundPresenterBrand.G;
        View r2 = (View) r0.z.getValue();
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.getMeasuredHeight();
    L6:
        r0.D = r4;
        ECShopBackgroundPresenterBrand r5 = this.a.a;
        ViewGroup r6 = r5.v0();
        if (r6 == null) goto L9;
        int r7 = r6.getMeasuredHeight();
    L10:
        r5.E = r7;
        ECShopBackgroundPresenterBrand r8 = this.a.a;
        ViewGroup r9 = r8.v0();
        if (r9 == null) goto L13;
        r3 = r9.getMeasuredWidth();
    L13:
        r8.F = r3;
        ECShopBackgroundPresenterBrand.q0(this.a.a);
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
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
