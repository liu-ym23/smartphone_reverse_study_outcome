package gvc;

import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;
import okio.Buffer;

/* JADX INFO: loaded from: classes42.dex */
public final class i extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f482938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Buffer f482939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f482940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f482941e;

    @Override // cvc.b
    public final void a() {
        r.a r100 = this.f482941e.f482895j;     // Catch: IOException -> L11
        Buffer r101 = this.f482939c;     // Catch: IOException -> L11
        int r102 = this.f482940d;     // Catch: IOException -> L11
        r100.getClass();     // Catch: IOException -> L11
        r101.skip(r102);     // Catch: IOException -> L11
        this.f482941e.f482906u.g(this.f482938b, ErrorCode.CANCEL);     // Catch: IOException -> L11
        e r103 = this.f482941e;     // Catch: IOException -> L11
        monitor-enter(r103);     // Catch: IOException -> L11
        this.f482941e.f482908w.remove(Integer.valueOf(this.f482938b));     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        goto L15
    L10:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: IOException -> L11
    }

    public i(e r100, Object[] r101, int r102, Buffer r103, int r104, boolean r105) {
        this.f482941e = r100;
        this.f482938b = r102;
        this.f482939c = r103;
        this.f482940d = r104;
        super("OkHttp %s Push Data[%s]", r101);
    }
}
