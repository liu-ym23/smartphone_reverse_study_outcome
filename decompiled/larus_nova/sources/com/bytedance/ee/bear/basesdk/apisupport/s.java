package com.bytedance.ee.bear.basesdk.apisupport;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes15.dex */
public final class s implements pn4.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.k f206575b;

    @Override // pn4.k
    public final void a() {
        tt5.a.h("Apisupport", "api call: clearLeaderShareTask");
        ((w) this.f206574a).d();
        this.f206575b.a();
    }

    @Override // pn4.k
    public final boolean hasLeader() {
        tt5.a.h("Apisupport", "api call: hasLeader");
        ((w) this.f206574a).d();
        return this.f206575b.hasLeader();
    }

    @Override // pn4.k
    public final void c(vb5.a r100) {
        tt5.a.h("Apisupport", "api call: showAskOwnerPanel");
        ((w) this.f206574a).d();
        this.f206575b.c(r100);
    }

    @Override // pn4.k
    public final boolean getLeaderShareSetting(IGetDataCallback<Boolean> r100) {
        tt5.a.h("Apisupport", "api call: getLeaderShareSetting");
        ((w) this.f206574a).d();
        return this.f206575b.getLeaderShareSetting(r100);
    }

    public s(n r100, pn4.k r101) {
        this.f206574a = r100;
        this.f206575b = r101;
    }

    @Override // pn4.k
    public final void d(qn4.b r100, com.ss.android.lark.integrator.ccm.config.viewbinder.g r101) {
        tt5.a.h("Apisupport", "api call: removeUserPermission");
        ((w) this.f206574a).d();
        this.f206575b.d(r100, r101);
    }

    @Override // pn4.k
    public final void updateLeaderShareSetting(boolean r100, IGetDataCallback<Boolean> r101) {
        tt5.a.h("Apisupport", "api call: updateLeaderShareSetting");
        ((w) this.f206574a).d();
        this.f206575b.updateLeaderShareSetting(r100, r101);
    }

    @Override // pn4.k
    public final void b(Activity r100, String r101, cmb.b r102) {
        tt5.a.h("Apisupport", "api call: showAdjustExternalPanel");
        ((w) this.f206574a).d();
        this.f206575b.b(r100, r101, r102);
    }
}
