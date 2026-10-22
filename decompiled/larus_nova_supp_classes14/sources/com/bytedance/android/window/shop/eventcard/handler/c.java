package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ LynxCallEventHandler a;
    public final /* synthetic */ ECLynxCard b;
    public final /* synthetic */ cp3.a c;
    public final /* synthetic */ Function1 d;

    public c(LynxCallEventHandler r1, ECLynxCard r2, cp3.a r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
