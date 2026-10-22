package w78;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.t0;

/* JADX INFO: loaded from: classes24.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j<Object> f558583a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f558583a.a(false);     // Catch: Throwable -> L4
        t0.f375468a.postDelayed(this, this.f558583a.f558585b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(j<Object> r100) {
        this.f558583a = r100;
    }
}
