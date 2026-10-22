package xf7;

import com.bytedance.sync.SyncSDK;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f563444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sync.a f563445b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f563444a.f563447a == false) goto L9;
        this.f563444a.f563448b = SyncSDK.registerBusiness(this.f563445b);     // Catch: Throwable -> L6
        return;
    }

    public b(c.a r100, com.bytedance.sync.a r101) {
        this.f563444a = r100;
        this.f563445b = r101;
    }
}
