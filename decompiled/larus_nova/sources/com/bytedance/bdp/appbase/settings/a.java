package com.bytedance.bdp.appbase.settings;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.appbase.base.event.c;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends c.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f201004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f201005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f201006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f201007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f201008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f201009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f201010h;

    @Override // com.bytedance.bdp.appbase.base.event.c.d
    public final void b() {
        a(BdpAppEventConstant.PARAMS_BDP_ID, this.f201004b);
        a("index", Integer.valueOf(this.f201005c));
        a("duration", Long.valueOf(this.f201006d));
        a("key", this.f201007e);
        a("settings_time", Long.valueOf(this.f201008f));
        a(BdpAppEventConstant.PARAMS_SETTINGS_INTERVAL_TIME, Long.valueOf(this.f201009g));
        a("result", this.f201010h);
    }

    public a(String r100, int r101, long r102, String r103, long r104, long r105, String r110) {
        this.f201004b = r100;
        this.f201005c = r101;
        this.f201006d = r102;
        this.f201007e = r103;
        this.f201008f = r104;
        this.f201009g = r105;
        this.f201010h = r110;
    }
}
