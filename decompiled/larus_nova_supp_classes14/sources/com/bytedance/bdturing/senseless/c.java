package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements d.InterfaceC0115d {
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
    public final void a(int r4, JSONObject r5) {
        d r0 = this.d;
        int r1 = r0.e + 1;
        r0.e = r1;
        if (r1 >= 3) goto L5;
        String r6 = r5.toString();
        EventReport.C(SenselessVerifyService.getInstance().getRiskRequest(), this.d.e, "pre_collect", r6);
        d r7 = this.d;
        String r8 = this.b;
        String r2 = this.c;
        r7.getClass();
        d.d(r8, r2, this, 1000);
        return;
    L5:
        d.e r3 = this.a;
        if (r3 == null) goto L10;
        r3.onFail(r4, r5);
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.InterfaceC0115d
    public final void onFail(int r2, JSONObject r3) {
        d.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(r2, r3);
        return;
    }

    public c(d r1, SenselessVerifyService$b r2, String r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
