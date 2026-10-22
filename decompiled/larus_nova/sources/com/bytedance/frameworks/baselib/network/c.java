package com.bytedance.frameworks.baselib.network;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends ThreadPlus {
    @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
    public final void run() {
        Iterator<TTNetInitMetrics.a> r100 = TTNetInitMetrics.f244601d0.iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        r100.next().a();     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c() {
        super("ttnet-init");
    }
}
