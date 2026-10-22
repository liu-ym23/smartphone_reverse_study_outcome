package hu;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f487197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f487198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f487199c;

    public e(String r100, Throwable r101, String r102) {
        this.f487197a = r100;
        this.f487198b = r101;
        this.f487199c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.crash.d.f(this.f487197a, this.f487198b, this.f487199c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
