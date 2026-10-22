package com.ss.android.lark.framework.assembly.appconfig;

import c0c.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.j;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends b {
    public a(j r100) {
        super(r100);
    }

    @Override // c0c.b
    public final void nf(f0c.b r100) {
        Log.i("InitSettingsTask", "onPrepared");
        Scene r101 = r100.f475024b.f475036b;
        if (Scene.FIRST_ONLINE.equals(r101) == false) goto L5;
    L8:
        InitSettingsTask.k();
        return;
    L5:
        if (Scene.FAST_ONLINE.equals(r101) == true) goto L8;
        if (Scene.SWITCH_ONLINE.equals(r101) == true) goto L8;
    }
}
