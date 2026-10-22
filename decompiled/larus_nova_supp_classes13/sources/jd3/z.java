package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static final class a {
    }

    static {
    }

    public z() {
        super("livesdk_live_show");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("enter_from_merge", r0, r1);
        appendParam("enter_method", this.b, r1);
        appendParam("action_type", this.c, r1);
        appendParam("video_id", this.d, r1);
        appendParam("room_id", null, r1);
        appendParam("anchor_id", null, r1);
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, null, r1);
        appendParam("click_order", null, r1);
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, null, r1);
        appendParam("commodity_id", null, r1);
        appendParam("commodity_type", null, r1);
        appendParam("request_id", null, r1);
        appendParam("_param_live_platform", "live", r1);
        appendParam("action_type", "click", r1);
        appendParam("is_other_channel", null, r1);
        appendParam("creative_id", null, r1);
        appendParam("log_extra", null, r1);
        appendParam("outflow_order", null, r1);
        appendParam("btm_id", this.e, r1);
    }

    public final void a(String r5) {
        JSONObject r0 = new JSONObject(r5);
        Iterator<String> r6 = r0.keys();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r1 = r6.next();
        String r2 = r0.optString(r1);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam(r1, r2, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L4
    }
}
