package com.bytedance.ee.bear.bitable.toast;

import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ BitableToastPlugin a;

    public d(BitableToastPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (BitableToastPlugin.access$getPendingToastQueue$p(this.a).isEmpty() == true) goto L7;
        BitableToastPlugin r0 = this.a;     // Catch: Throwable -> L9
        BitableToastPlugin.access$setCurrentToast$p(r0, (b) BitableToastPlugin.access$getPendingToastQueue$p(r0).poll());     // Catch: Throwable -> L9
        b r1 = BitableToastPlugin.access$getCurrentToast$p(this.a);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        j.f(new fv4.d(r1));     // Catch: Throwable -> L9
    L14:
        return;
    L7:
        BitableToastPlugin.access$setCurrentToast$p(this.a, null);     // Catch: Throwable -> L9
        goto L14
    }
}
