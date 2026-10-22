package s57;

import com.bytedance.platform.godzilla.common.Logger;
import java.util.concurrent.TimeoutException;
import t57.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    @Override // t57.a
    public final String b() {
        return "FinalizeTimeoutPlugin";
    }

    @Override // t57.c
    public final void f() {
    }

    public a() {
    }

    @Override // t57.c, t57.a
    public final void d() {
        super.d();
    }

    @Override // p57.g
    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (r100.getName().equals("FinalizerWatchdogDaemon") == false) goto L9;
        if ((r101 instanceof TimeoutException) == false) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        Logger.a("FinalizeTimeoutPlugin", "Hint FinalizeTimeout case ,fix it.");
    L12:
        return r102;
    L9:
        r102 = false;
        goto L10
    }
}
