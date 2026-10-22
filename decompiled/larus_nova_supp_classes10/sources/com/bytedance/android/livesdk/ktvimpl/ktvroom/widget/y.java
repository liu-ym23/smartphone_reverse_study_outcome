package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements Runnable {
    public final /* synthetic */ KtvInteractElementWidget a;

    public y(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Integer r0 = this.a.p;     // Catch: Throwable -> L13
        boolean r1 = true;
        if (r0 != null) goto L6;
    L9:
        Function2<? super Boolean, ? super Long, Unit> r2 = this.a.v.a;     // Catch: Throwable -> L13
        if (r2 == null) goto L16;
        Unit r3 = (Unit) r2.invoke(Boolean.valueOf(r1), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L6:
        if (r0.intValue() != 1) goto L9;
        r1 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
