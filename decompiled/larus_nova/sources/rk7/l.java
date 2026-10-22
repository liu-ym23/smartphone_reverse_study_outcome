package rk7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements Runnable {
    public l(int r100) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ik7.d r100 = m.f538354h;     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        r100.a();     // Catch: Throwable -> L6
        return;
    L12:
        return;
    L6:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogApiConfigManager", th.getLocalizedMessage());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
