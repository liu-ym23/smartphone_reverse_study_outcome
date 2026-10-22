package es3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ et3.h f473699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f473700b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f473700b.f473704b.add(this.f473699a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(e r100, et3.h r101) {
        this.f473700b = r100;
        this.f473699a = r101;
    }
}
