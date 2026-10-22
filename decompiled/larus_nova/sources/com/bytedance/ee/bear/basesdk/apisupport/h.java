package com.bytedance.ee.bear.basesdk.apisupport;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements pn4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.g f206555b;

    @Override // pn4.g
    public final com.bytedance.ee.bear.drive.sdk.service.g d0() {
        tt5.a.h("Apisupport", "api call: transferManager");
        ((w) this.f206554a).d();
        return this.f206555b.d0();
    }

    public h(n r100, pn4.g r101) {
        this.f206554a = r100;
        this.f206555b = r101;
    }

    @Override // pn4.g
    public final void a(Context r100, SpaceThirdPartyOpenEntity r101) {
        tt5.a.h("Apisupport", "api call: openPreview");
        ((w) this.f206554a).d();
        this.f206555b.a(r100, r101);
    }

    @Override // pn4.g
    public final void b(Context r100, SpaceThirdPartyOpenEntity r101) {
        tt5.a.h("Apisupport", "api call: downloadFile");
        ((w) this.f206554a).d();
        this.f206555b.b(r100, r101);
    }
}
