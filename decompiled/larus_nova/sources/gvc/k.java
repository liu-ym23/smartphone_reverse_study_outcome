package gvc;

import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes42.dex */
public final class k extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f482944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e.g f482945c;

    @Override // cvc.b
    public final void a() {
        this.f482945c.f482930c.f482887b.b(this.f482944b);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        hvc.g.f487396a.m(4, "Http2Connection.Listener failure for " + this.f482945c.f482930c.f482889d, e);
        this.f482944b.c(ErrorCode.PROTOCOL_ERROR);     // Catch: IOException -> L8
        return;
    }

    public k(e.g r100, Object[] r101, o r102) {
        this.f482945c = r100;
        this.f482944b = r102;
        super("OkHttp %s stream %d", r101);
    }
}
