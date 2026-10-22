package qd3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f532560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f532561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f532562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f532563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f532564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f532565f;

    /* JADX INFO: renamed from: qd3.a$a, reason: collision with other inner class name */
    public static final class C7312a {
    }

    static {
    }

    public a() {
        super("ec_inflow_lynx_card_monitor");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f532560a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("type", r100, r101);
        appendParam("status", this.f532561b, r101);
        appendParam("uid", r.f48132a.getCurrentUserId(), r101);
        String r102 = ECAppInfoService.f48114e.getServerDeviceId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        appendParam(com.bytedance.android.ec.core.event.a.KEY_DID, r102, r101);
        appendParam("log_id", this.f532562c, r101);
        appendParam("error_code", this.f532563d, r101);
        appendParam("error_msg", this.f532564e, r101);
        appendParam("error_type", this.f532565f, r101);
    }

    public final String getType() {
        return this.f532560a;
    }
}
