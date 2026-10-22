package v15;

import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ FragmentManager a;
    public final /* synthetic */ Runnable b;

    public c(FragmentManager r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
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
        if (this.a.isDestroyed() == true) goto L9;
        this.b.run();     // Catch: Throwable -> L6
        return;
    }
}
