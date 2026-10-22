package gvc;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes42.dex */
public final class g extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f482933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f482934d;

    @Override // cvc.b
    public final void a() {
        this.f482934d.f482895j.getClass();
        this.f482934d.f482906u.g(this.f482932b, ErrorCode.CANCEL);     // Catch: IOException -> L12
        e r100 = this.f482934d;     // Catch: IOException -> L12
        monitor-enter(r100);     // Catch: IOException -> L12
        this.f482934d.f482908w.remove(Integer.valueOf(this.f482932b));     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        goto L16
    L11:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L12
    }

    public g(e r100, Object[] r101, int r102, List r103) {
        this.f482934d = r100;
        this.f482932b = r102;
        this.f482933c = r103;
        super("OkHttp %s Push Request[%s]", r101);
    }
}
