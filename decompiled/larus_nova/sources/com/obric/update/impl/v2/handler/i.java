package com.obric.update.impl.v2.handler;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricInstallHandler f404122a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
        FLogger.f375446a.i("ObricInstallHandler", "registerAppBackGroundListener: onAllActivityDestroyed triggered");
        this.f404122a.getClass();
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i("ObricInstallHandler", "registerAppBackGroundListener: onAppBackground triggered");
        this.f404122a.onAppBackground();
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger.f375446a.i("ObricInstallHandler", "registerAppBackGroundListener: onAppForeground triggered");
        this.f404122a.onAppForeground();
    }

    public i(ObricInstallHandler r100) {
        this.f404122a = r100;
    }
}
