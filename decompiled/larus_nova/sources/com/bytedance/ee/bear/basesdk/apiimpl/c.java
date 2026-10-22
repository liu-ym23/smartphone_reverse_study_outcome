package com.bytedance.ee.bear.basesdk.apiimpl;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements pn4.b {
    public c() {
    }

    @Override // pn4.b
    public final void setIsAppInFront(boolean r100) {
        tt5.a.h("AppStatusImpl", "setIsAppInBackground()... process  = " + eu5.g.c() + ",  isAppFront = " + r100);
        com.bytedance.ee.bear.contract.u.f217197a.postValue(Boolean.valueOf(r100));
    }
}
