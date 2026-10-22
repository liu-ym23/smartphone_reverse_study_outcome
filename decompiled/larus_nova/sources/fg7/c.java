package fg7;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f476886a;

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.f476886a);     // Catch: Throwable -> L4 Exception -> L6
    L15:
        return;
    L6:
        zf7.b.b("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c(a r100) {
        this.f476886a = r100;
    }
}
