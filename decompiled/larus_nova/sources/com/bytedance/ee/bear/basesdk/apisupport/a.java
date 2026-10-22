package com.bytedance.ee.bear.basesdk.apisupport;

import com.bytedance.ee.bear.contract.config.DocDynamicConfig;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements pn4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.a f206543b;

    @Override // pn4.a
    public final void a(DocDynamicConfig r100) {
        tt5.a.h("Apisupport", "api call: updateDynamicConfig");
        ((w) this.f206542a).d();
        this.f206543b.a(r100);
    }

    @Override // pn4.a
    public final void b(String r100) {
        tt5.a.h("Apisupport", "api call: syncCookie");
        ((w) this.f206542a).d();
        this.f206543b.b(r100);
    }

    @Override // pn4.a
    public final void onLoginStatusChangedEvent(int r100) {
        tt5.a.h("Apisupport", "api call: onLoginStatusChangedEvent");
        ((w) this.f206542a).d();
        this.f206543b.onLoginStatusChangedEvent(r100);
    }

    public a(n r100, pn4.a r101) {
        this.f206542a = r100;
        this.f206543b = r101;
    }
}
