package v70;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f553413a;

    public b(Function0 r100) {
        this.f553413a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f553413a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
