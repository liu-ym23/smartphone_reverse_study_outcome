package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d c;

    public b(IntroCardEventCenter r1, String r2, com.bytedance.android.btm.api.model.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        IntroCardEventCenter r1 = this.a;     // Catch: Throwable -> L6
        v r2 = new v("livesdk_show_auction_hot_sale", r0);     // Catch: Throwable -> L6
        r2.c("atmosphere_type", this.b);     // Catch: Throwable -> L6
        r1.d(r2, this.c.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
