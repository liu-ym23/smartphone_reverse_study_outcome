package com.bytedance.bdturing.senseless;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2912a f202026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f202027b;

    /* JADX INFO: renamed from: com.bytedance.bdturing.senseless.a$a, reason: collision with other inner class name */
    public interface InterfaceC2912a {
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
        if (this.f202027b == false) goto L7;
        InterfaceC2912a r100 = this.f202026a;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.T0();     // Catch: Throwable -> L9
    L7:
        this.f202027b = false;     // Catch: Throwable -> L9
    }

    public a(InterfaceC2912a r100) {
        this.f202027b = false;
        this.f202026a = r100;
    }
}
