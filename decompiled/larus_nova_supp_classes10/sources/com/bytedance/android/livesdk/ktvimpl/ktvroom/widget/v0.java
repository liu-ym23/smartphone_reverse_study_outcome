package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v0 implements Runnable {
    public final /* synthetic */ com.bytedance.android.live.ktv.common.util.c a;

    public v0(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function2 r0 = this.a.getOneDrawCallback();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke(Boolean.TRUE, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
