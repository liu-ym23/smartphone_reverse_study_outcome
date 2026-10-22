package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Map b;

    public f(b r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gi2.a r0 = this.a.t;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        sg2.v r1 = new sg2.v("livesdk_show_shop_popup", r0);     // Catch: Throwable -> L6
        r1.d(this.b);     // Catch: Throwable -> L6
        r1.i("a1.b0715.c96013.d303933");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
