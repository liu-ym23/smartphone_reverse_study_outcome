package xg4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f563712a;

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (com.bytedance.crash.util.b.e(com.bytedance.crash.i.getContext(), com.bytedance.crash.util.b.c()) == false) goto L11;
        p r100 = p.f563716h;     // Catch: Throwable -> L8
        if (r100 == null) goto L15;
        i r101 = r100.f563723c;     // Catch: Throwable -> L8
        String r102 = this.f563712a;     // Catch: Throwable -> L8
        r101.getClass();     // Catch: Throwable -> L8
        new f(r101, r102, r102).startWatching();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }

    public n(String r100) {
        this.f563712a = r100;
    }
}
