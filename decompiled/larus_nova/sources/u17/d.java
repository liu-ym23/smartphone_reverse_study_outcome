package u17;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        PolarisFileWrapper r100 = s17.c.b().f540163e;     // Catch: Throwable -> L20
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.exists() == true) goto L7;
        return;
    L7:
        if (r100.isDirectory() == true) goto L9;
        return;
    L9:
        if (s17.b.f540156a == null) goto L11;
    L22:
        s17.b.f540156a.getClass();     // Catch: Throwable -> L20
        s17.b.a(r100);     // Catch: Throwable -> L20
        return;
    L11:
        monitor-enter(s17.b.class);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L13:
        if (s17.b.f540156a != null) goto L15;
        s17.b.f540156a = new s17.b();     // Catch: Throwable -> L17
    L15:
        monitor-exit(s17.b.class);     // Catch: Throwable -> L17
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L38;
        throw th;
    }

    public d() {
    }
}
