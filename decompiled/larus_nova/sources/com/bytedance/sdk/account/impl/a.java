package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    protected wa7.a mJobController;

    public a() {
    }

    public void cancelApi() {
        wa7.a r100 = this.mJobController;
        if (r100 == null) goto L8;
        c0 r101 = (c0) r100;
        r101.f268956e = null;
        c0.c r102 = r101.f268960i;
        if (r102 == null) goto L9;
        r102.f269214b.compareAndSet(false, true);
        return;
    L9:
        return;
    }

    public void attachController(wa7.a r100) {
        this.mJobController = r100;
    }
}
