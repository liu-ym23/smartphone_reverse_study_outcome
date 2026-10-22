package com.bytedance.ee.bear.basesdk.apisupport;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements pn4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pn4.b f206544a;

    public b(pn4.b r100) {
        this.f206544a = r100;
    }

    @Override // pn4.b
    public final void setIsAppInFront(boolean r100) {
        tt5.a.h("Apisupport", "api call: setIsAppInFront");
        this.f206544a.setIsAppInFront(r100);
    }
}
