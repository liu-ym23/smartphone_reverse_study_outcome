package com.bytedance.android.shopping.store.hybridproduct.extension;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.store.home.c0;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            s0.a(new c0());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] r0 = new int[2];
        ((View) this.a.k.getValue()).getLocationOnScreen(r0);
        int r2 = r0[1];
        Integer r3 = this.a.u;
        if (r3 != null) goto L6;
    L7:
        ECShopHybridProductListPresenter r4 = this.a;
        r4.u = Integer.valueOf(r0[1]);
        ((View) this.a.k.getValue()).post(a.a);
        return;
    L6:
        if (r2 != r3.intValue()) goto L7;
    }
}
