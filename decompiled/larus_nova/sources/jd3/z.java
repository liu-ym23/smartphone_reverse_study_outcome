package jd3;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class z extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498577e;

    public static final class a {
    }

    static {
    }

    public z() {
        super("livesdk_live_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498573a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("enter_from_merge", r100, r101);
        appendParam("enter_method", this.f498574b, r101);
        appendParam("action_type", this.f498575c, r101);
        appendParam("video_id", this.f498576d, r101);
        appendParam("room_id", null, r101);
        appendParam("anchor_id", null, r101);
        appendParam("follow_status", null, r101);
        appendParam("click_order", null, r101);
        appendParam("product_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, null, r101);
        appendParam("request_id", null, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live", r101);
        appendParam("action_type", "click", r101);
        appendParam("is_other_channel", null, r101);
        appendParam("creative_id", null, r101);
        appendParam("log_extra", null, r101);
        appendParam("outflow_order", null, r101);
        appendParam("btm_id", this.f498577e, r101);
    }

    public final void a(String r100) {
        JSONObject r101 = new JSONObject(r100);
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        String r104 = r101.optString(r103);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(r103, r104, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        goto L4
    }
}
