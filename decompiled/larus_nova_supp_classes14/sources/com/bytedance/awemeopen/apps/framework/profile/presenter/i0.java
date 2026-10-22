package com.bytedance.awemeopen.apps.framework.profile.presenter;

import com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final DmtTabLayout e;
    public final h0 f;

    @Override // f04.a
    public final void k() {
        this.d.b.getServerUserInfo().removeObserver(this.f);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.h0] */
    public i0(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = (DmtTabLayout) i(2131392060);
        this.f = new h0(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.d.b.getServerUserInfo().observe(this.d.c, this.f);
    }
}
