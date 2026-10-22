package w6a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f558443a;

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f558443a;     // Catch: Throwable -> L6
        r100.f558448a.setAnimation(r100.f558452e);     // Catch: Throwable -> L6
        if (this.f558443a.f558448a.getKeyframeManager() == null) goto L9;
        this.f558443a.f558448a.getKeyframeManager().c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(e r100) {
        this.f558443a = r100;
    }
}
