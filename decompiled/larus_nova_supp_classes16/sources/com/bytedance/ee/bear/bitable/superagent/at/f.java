package com.bytedance.ee.bear.bitable.superagent.at;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements Runnable {
    public final /* synthetic */ BitableSuperAgentAtViewModel a;
    public final /* synthetic */ List<BitableSuperAgentAtViewModel.b> b;

    public f(BitableSuperAgentAtViewModel r1, List<BitableSuperAgentAtViewModel.b> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BitableSuperAgentAtViewModel r0 = this.a;     // Catch: Throwable -> L7
        if (r0.r == false) goto L10;
        r0.i.setValue(this.b);     // Catch: Throwable -> L7
        this.a.m.setValue(Boolean.FALSE);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
