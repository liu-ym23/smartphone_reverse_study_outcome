package com.bytedance.timon_monitor_impl.call.consumer;

import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.report.TMDataCollector;
import e06.c;
import hh7.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class ApiCallApplogConsumer implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f270750b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270751a;

    public static final class a {
    }

    static {
    }

    public ApiCallApplogConsumer() {
        this.f270751a = LazyKt.lazy(new ApiCallApplogConsumer$releaseBuildStr$2(this));
    }

    @Override // com.bytedance.timon_monitor_impl.call.consumer.b
    public final void a(hh7.a r100) {
        String r101 = "";
        if (r100.d() == null) goto L5;
        String r102 = c.c(r100.d());
    L6:
        JSONObject r103 = new JSONObject();
        r103.put("id", r100.c());
        r103.put("event_type", r100.b());
        r103.put("client_invoke_time", r100.a());
        r103.put("privacy_api_call_data", r102);
        r103.put("release_build", (String) this.f270751a.getValue());
        f r104 = r100.d();
        if (r104 == null) goto L9;
        r103.put("privacy_api_call_id", r104.a());
    L9:
        boolean r105 = TMEnv.f270767a;
        Pair[] r106 = new Pair[3];
        f r107 = r100.d();
        if (r107 == null) goto L14;
        String r108 = String.valueOf(r107.a());
        if (r108 == null) goto L14;
    L15:
        r106[0] = TuplesKt.to("api_id", r108);
        f r109 = r100.d();
        if (r109 == null) goto L20;
        String r110 = r109.c();
        if (r110 == null) goto L20;
    L21:
        r106[1] = TuplesKt.to("class_name", r110);
        f r111 = r100.d();
        if (r111 == null) goto L26;
        String r112 = r111.f();
        if (r112 == null) goto L26;
        r101 = r112;
    L26:
        r106[2] = TuplesKt.to("method_name", r101);
        Map r113 = MapsKt.mapOf(r106);
        Function0<? extends Map<String, Object>> r114 = TMDataCollector.f270824a;
        TMDataCollector.d("timon_privacy_action_data_log", r103, true, r113);
        if (TMEnv.f270767a == false) goto L30;
        int r115 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("ApiMonitorCall-applog", r103.toString());
        return;
    L30:
        return;
    L20:
        r110 = "";
    L14:
        r108 = "";
        goto L15
    L5:
        r102 = "";
        goto L6
    }
}
