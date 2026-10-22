package w6a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f558442a;

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f558442a;     // Catch: Throwable -> L4
        r100.f558448a.setAnimation(r100.f558452e);     // Catch: Throwable -> L4
        this.f558442a.f558448a.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(e r100) {
        this.f558442a = r100;
    }
}
