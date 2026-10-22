package com.ss.android.vesdk;

import com.ss.android.medialib.presenter.ITEVideoController;

/* JADX INFO: loaded from: classes40.dex */
public final class x0 implements ITEVideoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITEVideoController f455943a;

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void pause() {
        this.f455943a.pause();
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void restart() {
        this.f455943a.restart();
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void start() {
        this.f455943a.start();
    }

    public x0(ITEVideoController r100) {
        this.f455943a = null;
        this.f455943a = r100;
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void seek(long r100) {
        this.f455943a.seek(r100);
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void setEnableEffCtrl(boolean r100) {
        this.f455943a.setEnableEffCtrl(r100);
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void setOnDuetProcessListener(ITEVideoController.a r100) {
        this.f455943a.setOnDuetProcessListener(null);
    }

    @Override // com.ss.android.medialib.presenter.ITEVideoController
    public final void setVEOnVideoEOFListener(ITEVideoController.b r100) {
        this.f455943a.setVEOnVideoEOFListener(null);
    }
}
