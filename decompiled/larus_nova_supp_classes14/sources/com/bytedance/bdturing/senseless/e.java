package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements d.InterfaceC0115d {
    public final /* synthetic */ d.e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ d d;

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC0115d
    public final void onSuccess() {
        d.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess();
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC0115d
    public final void a(int r9, JSONObject r10) {
        d r0 = this.d;
        int r1 = r0.f + 1;
        r0.f = r1;
        if (r1 >= 3) goto L5;
        String r11 = r10.toString();
        EventReport.C(SenselessVerifyService.getInstance().getRiskRequest(), this.d.f, "async_collect", r11);
        this.d.c(this.b, this.c, this, 1000);
        return;
    L5:
        d.e r2 = this.a;
        if (r2 == null) goto L10;
        r2.onFail(r9, r10);
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC0115d
    public final void onFail(int r2, JSONObject r3) {
        d.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(r2, r3);
        return;
    }

    public e(d r1, d.e r2, String r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
