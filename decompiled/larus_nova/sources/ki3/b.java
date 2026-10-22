package ki3;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f503610a;

    public b(a r100) {
        this.f503610a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = a.c(this.f503610a);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.callOnClick();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
