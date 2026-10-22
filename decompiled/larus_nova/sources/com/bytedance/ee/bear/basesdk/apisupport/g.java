package com.bytedance.ee.bear.basesdk.apisupport;

import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements pn4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.f f206553b;

    @Override // pn4.f
    public final void a(Map<Integer, String> r100) {
        tt5.a.h("Apisupport", "api call: setPassportUrlRegex");
        ((w) this.f206552a).d();
        this.f206553b.a(r100);
    }

    @Override // pn4.f
    public final void b(String r100) {
        tt5.a.h("Apisupport", "api call: setPassportHost");
        ((w) this.f206552a).d();
        this.f206553b.b(r100);
    }

    public g(n r100, pn4.f r101) {
        this.f206552a = r100;
        this.f206553b = r101;
    }
}
