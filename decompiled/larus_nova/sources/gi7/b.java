package gi7;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f481457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f481458b;

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f481458b.f481464b, this.f481457a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c.a r100, Activity r101) {
        this.f481458b = r100;
        this.f481457a = r101;
    }
}
