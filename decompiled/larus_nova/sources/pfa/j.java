package pfa;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes33.dex */
public final class j implements f09.a.b {
    public j() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i("NovaProcessControler", "onAppBackground");
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger.f375446a.i("NovaProcessControler", "onAppForeground");
        Object r100 = i.f529009m;
        monitor-enter(r100);
        i.f529008l = false;     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        i.f528997a.getClass();
        i.a().removeCallbacks(i.f529013q);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
