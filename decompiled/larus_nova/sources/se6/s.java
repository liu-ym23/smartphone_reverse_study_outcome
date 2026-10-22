package se6;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lark.sdk.e f541603a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f541603a.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public s(com.bytedance.lark.sdk.e r100) {
        this.f541603a = r100;
    }
}
