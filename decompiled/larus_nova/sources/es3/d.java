package es3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ et3.h f473701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f473702b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f473702b.f473704b.remove(this.f473701a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r100, et3.h r101) {
        this.f473702b = r100;
        this.f473701a = r101;
    }
}
