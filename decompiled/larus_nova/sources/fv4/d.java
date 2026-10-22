package fv4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b f478958a;

    public d(com.bytedance.ee.bear.bitable.toast.b r100) {
        this.f478958a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f478958a.f215986g;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.run();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
