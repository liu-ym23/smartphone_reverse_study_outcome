package kw7;

import com.hihonor.cloudservice.common.ApiException;

/* JADX INFO: loaded from: classes23.dex */
public final class e<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lw7.d<TResult> f506402a;

    public e() {
        this.f506402a = new lw7.d();
    }

    public final void a(ApiException r100) {
        lw7.d<TResult> r101 = this.f506402a;
        Object r102 = r101.f511041a;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r101.f511042b == true) goto L7;
        r101.f511042b = true;     // Catch: Throwable -> L9
        r101.f511044d = r100;     // Catch: Throwable -> L9
        r101.f511041a.notifyAll();     // Catch: Throwable -> L9
        r101.g();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }

    public void setResult(TResult r100) {
        lw7.d<TResult> r101 = this.f506402a;
        Object r102 = r101.f511041a;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r101.f511042b == true) goto L7;
        r101.f511042b = true;     // Catch: Throwable -> L9
        r101.f511043c = r100;     // Catch: Throwable -> L9
        r101.f511041a.notifyAll();     // Catch: Throwable -> L9
        r101.g();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }
}
