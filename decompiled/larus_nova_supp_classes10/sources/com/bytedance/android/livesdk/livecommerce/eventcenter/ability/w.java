package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements Runnable {
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ String d;

    public w(com.bytedance.android.ec.common.api.jump.model.a r1, String r2, Map r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r0 = new sg2.v(this.b, this.a);     // Catch: Throwable -> L4
        r0.d(this.c);     // Catch: Throwable -> L4
        r0.i(this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
