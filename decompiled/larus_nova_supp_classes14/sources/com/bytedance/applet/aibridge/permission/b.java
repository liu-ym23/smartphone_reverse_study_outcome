package com.bytedance.applet.aibridge.permission;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.larus.common_ui.dialog.p0;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import java.util.List;
import org.json.JSONObject;
import tx9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements p0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ List<String> d;
    public final /* synthetic */ c e;

    public final void confirm() {
        ((Keva) uv3.b.a.getValue()).storeBoolean("is_first_request_calendar_permission", false);
        String r0 = this.a;
        JSONObject r1 = this.b.getTraceInfo();
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        s.a("business_popup", r0, "authorize", r1);
        i2 r2 = i2.b;
        g1.a.b(this.c, this.d, this.e, null, null, 56);
    }

    public b(String r1, AbsRequestPermissionMethodIDL.b r2, FragmentActivity r3, List<String> r4, c r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
