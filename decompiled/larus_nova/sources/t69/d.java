package t69;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements f09.a.b {
    public d() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i("DoraWearStatusManager", "onAppBackground");
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger.f375446a.i("DoraWearStatusManager", "onAppForeground");
        g.c(null, true, 1);
    }
}
