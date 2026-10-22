package qd3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: qd3.a$a, reason: collision with other inner class name */
    public static final class C0229a {
    }

    static {
    }

    public a() {
        super("ec_inflow_lynx_card_monitor");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("type", r0, r1);
        appendParam("status", this.b, r1);
        appendParam("uid", r.a.getCurrentUserId(), r1);
        String r2 = ECAppInfoService.e.getServerDeviceId();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        appendParam("did", r2, r1);
        appendParam("log_id", this.c, r1);
        appendParam("error_code", this.d, r1);
        appendParam("error_msg", this.e, r1);
        appendParam("error_type", this.f, r1);
    }

    public final String getType() {
        return this.a;
    }
}
