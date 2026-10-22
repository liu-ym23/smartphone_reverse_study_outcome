package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SenselessVerifyService$d implements d.e {
    public final /* synthetic */ SenselessVerifyService a;

    @Override // com.bytedance.bdturing.senseless.d.e
    public final void onSuccess() {
        EventReport.E(SenselessVerifyService.access$000(this.a), 0, "async_collect", "");
        SenselessVerifyService.access$602(this.a, false);
    }

    public SenselessVerifyService$d(SenselessVerifyService r1) {
        this.a = r1;
    }

    @Override // com.bytedance.bdturing.senseless.d.e
    public final void onFail(int r3, JSONObject r4) {
        EventReport.E(SenselessVerifyService.access$000(this.a), r3, "async_collect", r4.toString());
        SenselessVerifyService.access$602(this.a, false);
    }
}
