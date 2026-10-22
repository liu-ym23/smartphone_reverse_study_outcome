package gvc;

import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes42.dex */
public final class j extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f482943c;

    @Override // cvc.b
    public final void a() {
        this.f482943c.f482895j.getClass();
        e r100 = this.f482943c;
        monitor-enter(r100);
        this.f482943c.f482908w.remove(Integer.valueOf(this.f482942b));     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public j(e r100, Object[] r101, int r102, ErrorCode r103) {
        this.f482943c = r100;
        this.f482942b = r102;
        super("OkHttp %s Push Reset[%s]", r101);
    }
}
