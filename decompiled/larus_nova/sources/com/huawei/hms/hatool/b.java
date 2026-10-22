package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    s0 f277292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    s0 f277293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f277294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f277295d;

    public b(Context r100) {
        if (r100 == null) goto L5;
        this.f277294c = r100.getApplicationContext();
    L5:
        this.f277292a = new s0();
        this.f277293b = new s0();
    }

    public b a(int r100, String r101) {
        v.a("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + r100);
        if (p1.b(r101) == true) goto L5;
        r101 = "";
    L5:
        if (r100 != 0) goto L7;
        s0 r102 = this.f277292a;
    L11:
        r102.b(r101);
    L12:
        return this;
    L7:
        if (r100 == 1) goto L9;
        v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
        goto L12
    L9:
        r102 = this.f277293b;
        goto L11
    }

    public b a(String r100) {
        v.a("hmsSdk", "Builder.setAppID is execute");
        this.f277295d = r100;
        return this;
    }

    public b a(boolean r100) {
        v.a("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f277292a.j().a(r100);
        this.f277293b.j().a(r100);
        return this;
    }

    public void a() {
        if (this.f277294c != null) goto L6;
        v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
        return;
    L6:
        v.a("hmsSdk", "Builder.create() is execute.");
        z0 r100 = new z0("_hms_config_tag");
        r100.b(new s0(this.f277292a));
        r100.a(new s0(this.f277293b));
        m.a().a(this.f277294c);
        g0.a().a(this.f277294c);
        q.c().a(r100);
        m.a().a(this.f277295d);
    }

    public b b(boolean r100) {
        v.a("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f277292a.j().b(r100);
        this.f277293b.j().b(r100);
        return this;
    }

    public b c(boolean r100) {
        v.a("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f277292a.j().c(r100);
        this.f277293b.j().c(r100);
        return this;
    }
}
