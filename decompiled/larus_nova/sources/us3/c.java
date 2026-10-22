package us3;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vs3.b f551469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f551470b;

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f551470b;     // Catch: Throwable -> L4
        vs3.b r101 = this.f551469a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        Looper.myQueue().addIdleHandler(new d(r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(e r100, vs3.b r101) {
        this.f551470b = r100;
        this.f551469a = r101;
    }
}
