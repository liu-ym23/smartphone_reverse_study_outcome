package fv4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b a;

    public d(com.bytedance.ee.bear.bitable.toast.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a.g;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.run();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
