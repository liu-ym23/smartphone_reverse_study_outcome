package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SenselessVerifyService$b implements d.e {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ f b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ SenselessVerifyService f;

    @Override // com.bytedance.bdturing.senseless.d.e
    public final void onSuccess() {
        SenselessVerifyService.access$200(this.f);
        SenselessVerifyService.access$302(this.f, false);
        EventReport.E(SenselessVerifyService.access$000(this.f), 0, "pre_collect", "");
        if (this.a == false) goto L6;
        this.b.onSuccess(0, null);
        return;
    }

    @Override // com.bytedance.bdturing.senseless.d.e
    public final void onFail(int r9, JSONObject r10) {
        EventReport.E(SenselessVerifyService.access$000(this.f), r9, "pre_collect", r10.toString());
        SenselessVerifyService.access$200(this.f);
        if (this.a == true) goto L5;
        SenselessVerifyService.access$302(this.f, false);
        return;
    L5:
        if (r9 == 10) goto L7;
        String r1 = r10.optString("message");
        String r2 = r10.optString("sec_message");
        SenselessVerifyService.access$100(this.f, r1, r2, this.a, this.c, this.d, this.e, this.b);
        return;
    L7:
        SenselessVerifyService.access$302(this.f, false);
        this.b.onFail(10, r10);
    }

    public SenselessVerifyService$b(SenselessVerifyService r1, boolean r2, f r3, String r4, String r5, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
