package ux1;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.dy;
import com.bytedance.android.livesdk.gecko.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f551966a;

    public b(Context r100) {
        this.f551966a = r100;
    }

    public final void a() {
        String r100 = n.f125818b.b();     // Catch: Throwable -> L8
        List<String> r101 = dy.f120072a.getValue().a();     // Catch: Throwable -> L8
        uy5.c r102 = new uy5.c(this.f551966a, r100);     // Catch: Throwable -> L8
        c.a(r102, r101);     // Catch: Throwable -> L6
    L15:
        r102.b();
        return;
    L6:
        th = th;
    L23:
        String r103 = th.getMessage();     // Catch: Throwable -> L17
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        ALogger.e("GPGeckoHelper", "fail to activate GameCP gecko Resource, error msg: ".concat(r103));     // Catch: Throwable -> L17
        if (r102 != null) goto L15;
        return;
    L17:
        th = move-exception;
        if (r102 == null) goto L20;
        r102.b();
    L20:
        throw th;
    L8:
        th = th;
        r102 = null;
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
