package com.bytedance.bdturing.senseless;

import qb4.c0;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements a.InterfaceC2912a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f202028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f202029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.e f202030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f202031d;

    @Override // com.bytedance.bdturing.senseless.a.InterfaceC2912a
    public final void T0() {
        d r100 = this.f202031d;
        String r101 = this.f202028a;
        String r102 = this.f202029b;
        d.e r103 = this.f202030c;
        a r104 = r100.f202037a;
        if (r104 == null) goto L7;
        r104.f202027b = false;
        c0.b r105 = c0.a.f532328a.f532327b;
        if (r105 == null) goto L7;
        r105.removeCallbacks(r104);
    L7:
        r100.f202042f = 0;
        r100.c(r101, r102, new e(r100, r103, r101, r102), 0);
    }

    public b(d r100, String r101, String r102, SenselessVerifyService.d r103) {
        this.f202031d = r100;
        this.f202028a = r101;
        this.f202029b = r102;
        this.f202030c = r103;
    }
}
