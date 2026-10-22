package com.bytedance.applet.aibridge.permission;

import com.bytedance.keva.Keva;
import com.larus.common_ui.dialog.u;
import org.json.JSONObject;
import tx9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements u {
    public final /* synthetic */ RequestPermissionMethod a;
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b b;
    public final /* synthetic */ String c;

    public final void cancel() {
        RequestPermissionMethod r0 = this.a;
        String r1 = this.b.getRequestId();
        String r2 = this.b.getPermission();
        int r3 = RequestPermissionMethod.b;
        r0.getClass();
        RequestPermissionMethod.e(r1, r2, false);
        s.c("0");
        ((Keva) uv3.b.a.getValue()).storeBoolean("is_first_request_calendar_permission", false);
        String r4 = this.c;
        JSONObject r5 = this.b.getTraceInfo();
        if (r5 != null) goto L5;
        r5 = new JSONObject();
    L5:
        s.a("business_popup", r4, "next_time", r5);
    }

    public a(RequestPermissionMethod r1, AbsRequestPermissionMethodIDL.b r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
