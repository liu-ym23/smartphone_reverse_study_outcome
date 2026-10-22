package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.ss.android.lark.location.dto.LarkLocation;

/* JADX INFO: loaded from: classes36.dex */
public final class b1 implements ew4.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.location.service.g.a f427842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f427843b;

    public b1(LocationHelper.d.a r100, z0 r101) {
        this.f427842a = r100;
        this.f427843b = r101;
    }

    @Override // ew4.p
    public final void a(ew4.o r100) {
        com.ss.android.lark.location.service.g.a r101 = this.f427842a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        LarkLocation r102 = z0.h(this.f427843b, r100);
    L7:
        r101.a(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }
}
