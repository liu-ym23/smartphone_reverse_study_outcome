package jz2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f501139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f501140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f501141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f501142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f501143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f501144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f501145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f501146h;

    public g() {
    }

    public final String toString() {
        return "FetchError{method='" + this.f501139a + "', url='" + this.f501140b + "', errorMessage='" + this.f501144f + "', errorCode=" + this.f501145g + ", statusCode=" + this.f501141c + ", requestErrorCode=" + this.f501142d + ", requestErrorMsg='" + this.f501143e + "', jsbReturn=0, hitPrefetch=0}";
    }

    public final void a(JSONObject r100) {
        com.bytedance.android.monitorV2.util.l.q(r100, "event_type", "fetchError");
        com.bytedance.android.monitorV2.util.l.n(r100, "error_no", this.f501145g);
        com.bytedance.android.monitorV2.util.l.q(r100, "error_msg", this.f501144f);
        com.bytedance.android.monitorV2.util.l.q(r100, com.alipay.sdk.m.p.e.f25671s, this.f501139a);
        com.bytedance.android.monitorV2.util.l.q(r100, "url", this.f501140b);
        com.bytedance.android.monitorV2.util.l.n(r100, "status_code", this.f501141c);
        com.bytedance.android.monitorV2.util.l.n(r100, "request_error_code", this.f501142d);
        com.bytedance.android.monitorV2.util.l.q(r100, "request_error_msg", this.f501143e);
        com.bytedance.android.monitorV2.util.l.n(r100, "jsb_ret", 0);
        com.bytedance.android.monitorV2.util.l.n(r100, "hit_prefetch", 0);
        com.bytedance.android.monitorV2.util.l.q(r100, "tt_log_id", this.f501146h);
    }
}
