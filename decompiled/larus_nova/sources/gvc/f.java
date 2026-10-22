package gvc;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public final class f extends cvc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f482931b;

    @Override // cvc.b
    public final void a() {
        e r100 = this.f482931b;
        r100.getClass();
        r100.f482906u.f(false, 2, 0);     // Catch: IOException -> L5
        return;
    L5:
        r100.b();
    }

    public f(e r100, Object... r101) {
        this.f482931b = r100;
        super("OkHttp %s ping", r101);
    }
}
