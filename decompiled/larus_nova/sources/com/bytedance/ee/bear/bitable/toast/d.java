package com.bytedance.ee.bear.bitable.toast;

import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableToastPlugin f215990a;

    public d(BitableToastPlugin r100) {
        this.f215990a = r100;
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
        if (BitableToastPlugin.access$getPendingToastQueue$p(this.f215990a).isEmpty() == true) goto L7;
        BitableToastPlugin r100 = this.f215990a;     // Catch: Throwable -> L9
        BitableToastPlugin.access$setCurrentToast$p(r100, (b) BitableToastPlugin.access$getPendingToastQueue$p(r100).poll());     // Catch: Throwable -> L9
        b r101 = BitableToastPlugin.access$getCurrentToast$p(this.f215990a);     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        j.f(new fv4.d(r101));     // Catch: Throwable -> L9
    L14:
        return;
    L7:
        BitableToastPlugin.access$setCurrentToast$p(this.f215990a, null);     // Catch: Throwable -> L9
        goto L14
    }
}
