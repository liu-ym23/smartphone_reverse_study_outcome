package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.f;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SenselessVerifyService$a implements a.InterfaceC0114a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ f e;
    public final /* synthetic */ SenselessVerifyService f;

    @Override // com.bytedance.bdturing.senseless.a.InterfaceC0114a
    public final void T0() {
        jc4.a r0 = SenselessVerifyService.access$000(this.f);
        JSONObject r1 = new JSONObject();
        r1.put("key", "senseless_report_timeout");     // Catch: JSONException -> L5
        EventReport.w("turing_verify_sdk", r1, r0);
    L7:
        SenselessVerifyService.access$100(this.f, "", "", this.a, this.b, this.c, this.d, this.e);
        return;
    L5:
        e = move-exception;
        int r2 = n.a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        goto L7
    }

    public SenselessVerifyService$a(SenselessVerifyService r1, boolean r2, String r3, String r4, String r5, f r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
