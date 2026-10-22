package com.bytedance.android.shopping.new_cart.viewmodel;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ CartViewModel.b b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.viewmodel.a$a, reason: collision with other inner class name */
    public static final class RunnableC0132a implements Runnable {
        public final /* synthetic */ a a;

        public RunnableC0132a(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            CartViewModel.b r1 = r0.b;     // Catch: Throwable -> L4
            CartViewModel.access$onGetQuery(r1.b, r0.a, r1.c, r1.a, r1.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartViewModel r0 = this.a.b.b;     // Catch: Throwable -> L4
            Throwable r1 = new Throwable("onGetQuery ERROR");     // Catch: Throwable -> L4
            CartViewModel.b r2 = this.a.b;     // Catch: Throwable -> L4
            CartViewModel.access$onGetQueryErr(r0, r1, r2.c, r2.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(e r1, CartViewModel.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;     // Catch: Throwable -> L4
        com.bytedance.android.shopping.new_cart.utils.a.c(this.b.b, "CartVM onNext ERROR", new RunnableC0132a(this), new b(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
