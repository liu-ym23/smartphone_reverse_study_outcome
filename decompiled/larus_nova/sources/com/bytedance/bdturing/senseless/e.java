package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements d.InterfaceC2913d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.e f202056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f202057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f202058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f202059d;

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void onSuccess() {
        d.e r100 = this.f202056a;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void a(int r100, JSONObject r110) {
        d r101 = this.f202059d;
        int r102 = r101.f202042f + 1;
        r101.f202042f = r102;
        if (r102 >= 3) goto L5;
        String r103 = r110.toString();
        EventReport.C(SenselessVerifyService.getInstance().getRiskRequest(), this.f202059d.f202042f, "async_collect", r103);
        this.f202059d.c(this.f202057b, this.f202058c, this, 1000);
        return;
    L5:
        d.e r104 = this.f202056a;
        if (r104 == null) goto L10;
        r104.onFail(r100, r110);
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void onFail(int r100, JSONObject r101) {
        d.e r102 = this.f202056a;
        if (r102 == null) goto L6;
        r102.onFail(r100, r101);
        return;
    }

    public e(d r100, d.e r101, String r102, String r103) {
        this.f202059d = r100;
        this.f202056a = r101;
        this.f202057b = r102;
        this.f202058c = r103;
    }
}
