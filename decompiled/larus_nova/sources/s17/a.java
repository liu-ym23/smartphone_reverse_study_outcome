package s17;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        long r100 = com.bytedance.memory.heap.a.b().d().getLong("lastDumpTime", 0);     // Catch: Throwable -> L8
        if (r100 != 0) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - r100) <= 604800000) goto L20;
        x17.a.f562123j.c("deleteExpiredWidgetFolder");     // Catch: Throwable -> L8
        com.bytedance.memory.heap.a.b().a();     // Catch: Throwable -> L8
        return;
    L20:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public a() {
    }
}
