package xg4;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f563713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.crash.monitor.a f563714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f563715c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = this.f563713a.iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        w r101 = (w) r100.next();     // Catch: Throwable -> L7
        p r102 = this.f563715c;     // Catch: Throwable -> L7
        com.bytedance.crash.monitor.a r103 = this.f563714b;     // Catch: Throwable -> L7
        r102.getClass();     // Catch: Throwable -> L7
        r101.upload(r103, null);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public o(p r100, List r101, com.bytedance.crash.monitor.a r102) {
        this.f563715c = r100;
        this.f563713a = r101;
        this.f563714b = r102;
    }
}
