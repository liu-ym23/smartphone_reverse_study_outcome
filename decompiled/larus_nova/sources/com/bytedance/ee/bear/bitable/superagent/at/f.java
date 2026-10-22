package com.bytedance.ee.bear.bitable.superagent.at;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtViewModel f215856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<BitableSuperAgentAtViewModel.b> f215857b;

    public f(BitableSuperAgentAtViewModel r100, List<BitableSuperAgentAtViewModel.b> r101) {
        this.f215856a = r100;
        this.f215857b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BitableSuperAgentAtViewModel r100 = this.f215856a;     // Catch: Throwable -> L7
        if (r100.f215838r == false) goto L10;
        r100.f215829i.setValue(this.f215857b);     // Catch: Throwable -> L7
        this.f215856a.f215833m.setValue(Boolean.FALSE);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
