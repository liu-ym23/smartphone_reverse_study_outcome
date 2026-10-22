package v15;

import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentManager f552440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f552441b;

    public c(FragmentManager r100, Runnable r101) {
        this.f552440a = r100;
        this.f552441b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f552440a.isDestroyed() == true) goto L9;
        this.f552441b.run();     // Catch: Throwable -> L6
        return;
    }
}
