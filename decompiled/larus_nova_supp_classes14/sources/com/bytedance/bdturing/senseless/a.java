package com.bytedance.bdturing.senseless;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final InterfaceC0114a a;
    public boolean b;

    /* JADX INFO: renamed from: com.bytedance.bdturing.senseless.a$a, reason: collision with other inner class name */
    public interface InterfaceC0114a {
        void T0();
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    L3:
        if (this.b == false) goto L7;
        InterfaceC0114a r0 = this.a;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.T0();     // Catch: Throwable -> L9
    L7:
        this.b = false;     // Catch: Throwable -> L9
    }

    public a(InterfaceC0114a r2) {
        this.b = false;
        this.a = r2;
    }
}
