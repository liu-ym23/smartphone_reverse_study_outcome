package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import com.bytedance.bdturing.EventReport;
import hc4.d;
import org.json.JSONObject;
import qb4.f;
import qb4.n;
import ub4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class IdentityVerifyService$c implements a {
    public final /* synthetic */ jc4.a a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ f c;
    public final /* synthetic */ IdentityVerifyService d;

    @Override // ub4.a
    public final void onCancel() {
        int r0 = n.a;
        EventReport.k(1, IdentityVerifyService.access$300(this.d));
        this.b.getApplication().unregisterActivityLifecycleCallbacks(this.d);
        IdentityVerifyService.access$500(this.d, false);
        JSONObject r1 = new JSONObject();
        d.b(r1, "errorMsg", "cert verify cancel by user");
        IdentityVerifyService.access$600(this.d, false, r1, this.c);
    }

    @Override // ub4.a
    public final void onConfirm() {
        int r0 = n.a;
        EventReport.k(0, IdentityVerifyService.access$300(this.d));
        IdentityVerifyService.access$400(this.d, this.a, this.b, this.c);
    }

    public IdentityVerifyService$c(IdentityVerifyService r1, jc4.a r2, Activity r3, f r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
