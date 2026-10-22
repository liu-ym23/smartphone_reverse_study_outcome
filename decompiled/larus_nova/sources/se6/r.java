package se6;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lark.sdk.e f541602a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f541602a.f254172e.set(true);     // Catch: Throwable -> L4
        this.f541602a.f254173f.countDown();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r(com.bytedance.lark.sdk.e r100) {
        this.f541602a = r100;
    }
}
