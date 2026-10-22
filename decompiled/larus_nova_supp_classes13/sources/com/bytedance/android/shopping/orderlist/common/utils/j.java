package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0 b;

    public j(String r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dm.a.b r1 = dm.a.a;     // Catch: Exception -> L5 Throwable -> L8
        dm.a.a("order_common_" + this.a).w((String) this.b.invoke(), null);     // Catch: Exception -> L5 Throwable -> L8
    L13:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L8
        goto L13
    }
}
