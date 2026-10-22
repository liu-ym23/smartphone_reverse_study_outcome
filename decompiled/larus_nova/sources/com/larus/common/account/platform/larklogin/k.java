package com.larus.common.account.platform.larklogin;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class k extends sa7.h<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f326228a;

    public k(String r100) {
        this.f326228a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        FLogger.f375446a.i("LarkLogin", "update authorize info success");
        LarkLogin.f326156h.c(this.f326228a, new LarkOAuthSessionCoordinator.c.d(null));
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.c r102 = (xa7.c) r100;
        FLogger.f375446a.i("LarkLogin", "update authorize info fail, error: " + r101);
        LarkOAuthSessionCoordinator r103 = LarkLogin.f326156h;
        String r104 = this.f326228a;
        String r105 = String.valueOf(r101);
        if (r102 == null) goto L5;
        String r106 = r102.f549255i;
    L6:
        r103.c(r104, new LarkOAuthSessionCoordinator.c.C4181c(r105, r106, null, null));
        return;
    L5:
        r106 = null;
        goto L6
    }
}
