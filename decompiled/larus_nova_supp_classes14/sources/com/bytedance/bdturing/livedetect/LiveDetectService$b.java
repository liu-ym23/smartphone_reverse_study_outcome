package com.bytedance.bdturing.livedetect;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;
import xb4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LiveDetectService$b implements ec4.c {
    public final /* synthetic */ xb4.b a;
    public final /* synthetic */ LiveDetectService b;

    @Override // ec4.c
    public final void a(a r9) {
        if (r9.a != 200) goto L5;
        boolean r0 = true;
    L6:
        String r1 = r9.c;
        jc4.a r4 = LiveDetectService.access$000(this.b);
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L13
        r5.put("key", "turing_live_create_session");     // Catch: Exception -> L13
        if (r0 == false) goto L10;
        int r2 = 0;
    L11:
        r5.put("result", r2);     // Catch: Exception -> L13
        r5.put("custom", r1);     // Catch: Exception -> L13
        EventReport.w("turing_verify_sdk", r5, r4);     // Catch: Exception -> L13
    L15:
        xb4.b r3 = this.a;
        if (r3 == null) goto L21;
        r3.a(r9.a, r9.b, new String[]{r9.c});
        return;
    L21:
        return;
    L10:
        r2 = 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    @Override // ec4.c
    public final void onError(Throwable r2) {
        xb4.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public LiveDetectService$b(LiveDetectService r1, xb4.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
