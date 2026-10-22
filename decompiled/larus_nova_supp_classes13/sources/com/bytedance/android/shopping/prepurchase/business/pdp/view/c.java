package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.a.m.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerBlock r0 = this.a.a.f;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        PlayerBlock.l(r0, null, 3);     // Catch: Throwable -> L7
    L5:
        this.a.a.postDelayed(new a(this), 500);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
