package com.larus.bmhome.notification;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotifyRedDotLifecycleObserver f313467a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        NotifyRedDotLifecycleObserver r100 = this.f313467a;
        int r101 = NotifyRedDotLifecycleObserver.f313416h;
        r100.getClass();
        FLogger.f375446a.i("NotifyRedDotLifecycleObserver", "stopUnreadPollingTask");
        r100.f313419c.removeCallbacks(r100.f313420d);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        NotifyRedDotLifecycleObserver r100 = this.f313467a;
        int r101 = NotifyRedDotLifecycleObserver.f313416h;
        r100.b();
    }

    public d(NotifyRedDotLifecycleObserver r100) {
        this.f313467a = r100;
    }
}
