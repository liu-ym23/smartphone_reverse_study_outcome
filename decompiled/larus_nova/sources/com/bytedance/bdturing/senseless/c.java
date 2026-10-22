package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements d.InterfaceC2913d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.e f202032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f202033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f202034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f202035d;

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void onSuccess() {
        d.e r100 = this.f202032a;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void a(int r100, JSONObject r101) {
        d r102 = this.f202035d;
        int r103 = r102.f202041e + 1;
        r102.f202041e = r103;
        if (r103 >= 3) goto L5;
        String r104 = r101.toString();
        EventReport.C(SenselessVerifyService.getInstance().getRiskRequest(), this.f202035d.f202041e, "pre_collect", r104);
        d r105 = this.f202035d;
        String r106 = this.f202033b;
        String r107 = this.f202034c;
        r105.getClass();
        d.d(r106, r107, this, 1000);
        return;
    L5:
        d.e r108 = this.f202032a;
        if (r108 == null) goto L10;
        r108.onFail(r100, r101);
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC2913d
    public final void onFail(int r100, JSONObject r101) {
        d.e r102 = this.f202032a;
        if (r102 == null) goto L6;
        r102.onFail(r100, r101);
        return;
    }

    public c(d r100, SenselessVerifyService.b r101, String r102, String r103) {
        this.f202035d = r100;
        this.f202032a = r101;
        this.f202033b = r102;
        this.f202034c = r103;
    }
}
