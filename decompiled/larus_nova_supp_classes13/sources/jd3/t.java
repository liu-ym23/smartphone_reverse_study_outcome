package jd3;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.android.ec.core.event.a {
    public final JSONObject a;
    public final JSONObject b;
    public final List<String> c;
    public Integer d;
    public String e;
    public String f;

    public static final class a {
    }

    static {
    }

    public t() {
        super("commerce_api_feedback");
        this.a = new JSONObject();
        this.b = new JSONObject();
        this.c = new ArrayList();
    }

    public final void a() {
        this.a.put("lost_keys", CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, null, 62, null));
        MonitorUtils.monitorEvent("goods_api_feedback", this.a, this.b, null);
        post(null, null);
    }

    public final void buildParams() {
        String r0 = String.valueOf(this.d);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("status_code", r0, r1);
        appendParam("http_status_code", "null", r1);
        appendParam("type", this.f, r1);
        appendParam("api_path", this.e, r1);
        appendParam("lost_keys", CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, null, 62, null), r1);
    }
}
