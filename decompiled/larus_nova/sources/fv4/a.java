package fv4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b f478955a;

    public a(com.bytedance.ee.bear.bitable.toast.b r100) {
        this.f478955a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.bitable.toast.c r100 = this.f478955a.f215987h;     // Catch: Throwable -> L6
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
