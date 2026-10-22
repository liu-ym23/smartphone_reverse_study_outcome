package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class o0 implements t39.i {
    public o0() {
    }

    @Override // t39.i
    public final void b(boolean r100) {
    }

    @Override // t39.i
    public final void c(boolean r100) {
    }

    @Override // t39.i
    public final void p(int r100) {
    }

    @Override // t39.i
    public final void a(int r100, int r101) {
        FLogger.f375446a.i("ThumbnailManager", "onIdleStateChanged, state: " + r100 + ", currentState: " + r101);
        ThumbnailManager.f292775m = r100;
    }
}
