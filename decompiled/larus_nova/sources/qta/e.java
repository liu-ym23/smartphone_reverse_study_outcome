package qta;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.activity.f.i;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534820a;

    public e(i r100) {
        this.f534820a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rta.b r100 = this.f534820a.f408420i;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
