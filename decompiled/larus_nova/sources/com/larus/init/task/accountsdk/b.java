package com.larus.init.task.accountsdk;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d48.c.a f351136a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        this.f351136a.onAppLifeCycleChange(true);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        this.f351136a.onAppLifeCycleChange(false);
    }

    public b(com.larus.account.saas.mfa.assist.c r100) {
        this.f351136a = r100;
    }
}
