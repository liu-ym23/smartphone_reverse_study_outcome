package com.bytedance.awemeopen.apps.framework.profile.presenter;

import com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i0 extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.m f197444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DmtTabLayout f197445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f197446f;

    @Override // f04.a
    public final void k() {
        this.f197444d.f197362b.getServerUserInfo().removeObserver(this.f197446f);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.h0] */
    public i0(com.bytedance.awemeopen.apps.framework.profile.m r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f197361a);
        this.f197444d = r100;
        this.f197445e = (DmtTabLayout) i(R.id.user_profile_tab_layout);
        this.f197446f = new h0(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f197444d.f197362b.getServerUserInfo().observe(this.f197444d.f197363c, this.f197446f);
    }
}
