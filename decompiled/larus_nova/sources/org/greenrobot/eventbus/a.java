package org.greenrobot.eventbus;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f525798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventBus f525799b;

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f525798a.b();     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        this.f525799b.invokeSubscriber(r100);     // Catch: Throwable -> L7
        return;
    L6:
        throw new IllegalStateException("No pending post available");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(EventBus r100) {
        this.f525799b = r100;
        this.f525798a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public final void a(o r100, Object r101) {
        j r102 = j.a(r100, r101);
        this.f525798a.a(r102);
        this.f525799b.getExecutorService().execute(this);
    }
}
