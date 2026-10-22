package jd3;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class t extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f498466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f498467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f498468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f498469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f498470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498471f;

    public static final class a {
    }

    static {
    }

    public t() {
        super("commerce_api_feedback");
        this.f498466a = new JSONObject();
        this.f498467b = new JSONObject();
        this.f498468c = new ArrayList();
    }

    public final void a() {
        this.f498466a.put("lost_keys", CollectionsKt.joinToString$default(this.f498468c, ",", null, null, 0, null, null, 62, null));
        MonitorUtils.monitorEvent("goods_api_feedback", this.f498466a, this.f498467b, null);
        post(null, null);
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f498469d);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("status_code", r100, r101);
        appendParam("http_status_code", "null", r101);
        appendParam("type", this.f498471f, r101);
        appendParam("api_path", this.f498470e, r101);
        appendParam("lost_keys", CollectionsKt.joinToString$default(this.f498468c, ",", null, null, 0, null, null, 62, null), r101);
    }
}
