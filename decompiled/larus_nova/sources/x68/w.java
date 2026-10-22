package x68;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f562702a;

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.f562702a.f562685x.get() == false) goto L12;
        this.f562702a.b(false);     // Catch: Throwable -> L9
        if (this.f562702a.f562685x.get() == false) goto L16;
        this.f562702a.a().postDelayed(this, 10000);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    }

    public w(u r100) {
        this.f562702a = r100;
    }
}
