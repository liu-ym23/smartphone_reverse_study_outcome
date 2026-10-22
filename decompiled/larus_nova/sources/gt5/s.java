package gt5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f482576b;

    public s(ft5.a r100, long r101) {
        this.f482575a = r100;
        this.f482576b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new g("wb_webview_create", e.f482522f, this.f482575a).addCategoryValue("duration", Long.valueOf(this.f482576b)).flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
