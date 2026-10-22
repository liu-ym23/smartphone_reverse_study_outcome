package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f561684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f561685b;

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f561684a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onSuccess(this.f561685b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public n0(a r100, Object r101) {
        this.f561684a = r100;
        this.f561685b = r101;
    }
}
