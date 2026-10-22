package com.bytedance.bdturing.uc_twiceverify;

import com.bytedance.bdturing.EventReport;
import gc4.b;
import hc4.d;
import jc4.a;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class UCTwiceVerifyService$b implements b {
    public final /* synthetic */ String a;
    public final /* synthetic */ f b;
    public final /* synthetic */ UCTwiceVerifyService c;

    public final void a(int r5, JSONObject r6) {
        a r0 = UCTwiceVerifyService.access$100(this.c);
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("key", "uc_twice_verify_result");     // Catch: Exception -> L5
        r1.put("result", r5);     // Catch: Exception -> L5
        r1.put("custom", r6);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r1, r0);     // Catch: Exception -> L5
    L7:
        if (r6 != null) goto L9;
        r6 = new JSONObject();
    L9:
        JSONObject r2 = new JSONObject();
        d.b(r2, "subtype", this.a);
        d.b(r6, "notify_data", r2);
        UCTwiceVerifyService r3 = this.c;
        if (r5 != 0) goto L12;
        boolean r7 = true;
    L13:
        UCTwiceVerifyService.access$200(r3, r7, r6, this.b);
        return;
    L12:
        r7 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public UCTwiceVerifyService$b(UCTwiceVerifyService r1, String r2, f r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
