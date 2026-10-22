package gvc;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes42.dex */
public final class h extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f482936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f482937d;

    @Override // cvc.b
    public final void a() {
        this.f482937d.f482895j.getClass();
        this.f482937d.f482906u.g(this.f482935b, ErrorCode.CANCEL);     // Catch: IOException -> L12
        e r100 = this.f482937d;     // Catch: IOException -> L12
        monitor-enter(r100);     // Catch: IOException -> L12
        this.f482937d.f482908w.remove(Integer.valueOf(this.f482935b));     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        goto L16
    L11:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L12
    }

    public h(e r100, Object[] r101, int r102, List r103, boolean r104) {
        this.f482937d = r100;
        this.f482935b = r102;
        this.f482936c = r103;
        super("OkHttp %s Push Headers[%s]", r101);
    }
}
