package com.bytedance.ee.bear.quoto;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f236397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f236398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f236399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f0 f236400f;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SingleFileExceedQuotaFragment r101 = this.f236400f.f236366b;
        r101.f236329o = false;
        SingleFileExceedQuotaFragment.da0(r101);
        y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236397c, Boolean.valueOf(this.f236398d), this.f236399e, "already_know");
    }

    public h0(f0 r100, String r101, boolean r102, String r103) {
        this.f236400f = r100;
        this.f236397c = r101;
        this.f236398d = r102;
        this.f236399e = r103;
    }
}
