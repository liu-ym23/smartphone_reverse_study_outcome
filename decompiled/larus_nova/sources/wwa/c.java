package wwa;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f561751a;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) b.f561740i).iterator();     // Catch: Throwable -> L13
    L3:
        if (r100.hasNext() == false) goto L29;
        xwa.b.a r101 = (xwa.b.a) r100.next();     // Catch: Throwable -> L13
        if (r101 == null) goto L3;
        if (this.f561751a.booleanValue() == true) goto L10;
        r101.a();     // Catch: Throwable -> L13
        goto L3
    L10:
        r101.b();     // Catch: Throwable -> L13
        goto L3
    L29:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L17;
        return;
    L17:
        throw th;
    }

    public c(Boolean r100) {
        this.f561751a = r100;
    }
}
