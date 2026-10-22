package ssa;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f543469a;

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f543469a;     // Catch: Throwable -> L4
        r100.f543435e.doUploadVideo(r100.f543442l, 3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(b r100) {
        this.f543469a = r100;
    }
}
