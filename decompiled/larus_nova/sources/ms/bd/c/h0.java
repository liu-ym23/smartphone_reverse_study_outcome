package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes42.dex */
public final class h0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f515154a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = ((i0[]) i0.f515161e.clone())[r100.what].ordinal();
        if (r101 != 1) goto L5;
    L7:
        r0 r102 = this.f515154a.f515179b;
        if (r102 == null) goto L16;
        int r103 = r100.what;     // Catch: Exception -> L11
        r102.b((String) r100.obj, r103);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.getMessage();
        return;
    L16:
        return;
    L5:
        if (r101 == 2) goto L7;
    }

    public h0(k0 r100, Looper r101) {
        this.f515154a = r100;
        super(r101);
    }
}
