package vg1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f554670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f554671b;

    public b(a r100, String r101) {
        this.f554670a = r100;
        this.f554671b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f554670a.a(this.f554671b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
