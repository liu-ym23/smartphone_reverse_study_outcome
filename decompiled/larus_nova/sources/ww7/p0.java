package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f561689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f561690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f561691c;

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f561689a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onFailure(this.f561690b, this.f561691c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public p0(a r100, int r101, String r102) {
        this.f561689a = r100;
        this.f561690b = r101;
        this.f561691c = r102;
    }
}
