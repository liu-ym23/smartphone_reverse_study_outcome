package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o2 implements Runnable {
    public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

    public o2(ECShopTopBarBackPresenterV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r0 = this.a.F;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.setVisibility(8);     // Catch: Throwable -> L9
    L5:
        ViewGroup r1 = this.a.A;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setVisibility(0);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
