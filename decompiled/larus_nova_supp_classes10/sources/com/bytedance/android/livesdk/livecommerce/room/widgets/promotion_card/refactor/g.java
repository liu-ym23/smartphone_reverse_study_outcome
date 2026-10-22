package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g a;
    public final /* synthetic */ ECAtmosphereItem b;

    public g(com.bytedance.android.ec.common.api.jump.model.g r1, ECAtmosphereItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r0 = new v("livesdk_show_atmosphere", this.a);     // Catch: Throwable -> L4
        r0.d(this.b.getEventParam());     // Catch: Throwable -> L4
        r0.i("c2627.d945454");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
