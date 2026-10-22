package com.bytedance.ee.bear.basesdk.apisupport;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements pn4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pn4.j f206573a;

    public r(pn4.j r100) {
        this.f206573a = r100;
    }

    @Override // pn4.j
    public final void setCCMConfig(String r100) {
        tt5.a.h("Apisupport", "api call: setCCMConfig");
        this.f206573a.setCCMConfig(r100);
    }

    @Override // pn4.j
    public final void timingCleanData(long r100) {
        tt5.a.h("Apisupport", "api call: timingCleanData");
        this.f206573a.timingCleanData(r100);
    }
}
