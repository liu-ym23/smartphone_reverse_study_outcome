package iz6;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements pn6.b {

    public static final class a {
    }

    static {
    }

    @Override // pn6.b
    public final boolean a(Request r100, SsResponse<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "ssResponse");
        return true;
    }

    public b() {
    }

    @Override // pn6.b
    public final void b(nn6.a r100, Request r101, SsResponse<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "poiDurationMonitor");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "ssResponse");
        HashMap<String, String> r103 = new HashMap();
        Object r104 = r102.body();
        BaseHttpRequestInfo r105 = null;
        if ((r104 instanceof JsonObject) == false) goto L5;
        JsonObject r106 = (JsonObject) r104;
    L6:
        if (r106 != null) goto L8;
    L20:
        hz6.a r107 = hz6.a.f487703a;
        monitor-enter(r107);
        Intrinsics.checkNotNullParameter(r100, "poiDurationMonitor");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r103, "params");     // Catch: Throwable -> L34
        String r108 = hz6.a.b();     // Catch: Throwable -> L34
        if (r108 != null) goto L26;
        monitor-exit(r107);
        return;
    L26:
        hz6.a.f487707e.put(r108, r103);     // Catch: Throwable -> L34
        Map<String, PoiChainDurationMonitor> r109 = hz6.a.f487705c;     // Catch: Throwable -> L34
        if (r109.containsKey(r108) == false) goto L31;
        PoiChainDurationMonitor r110 = (PoiChainDurationMonitor) ((LinkedHashMap) r109).get(r108);     // Catch: Throwable -> L34
        if (r110 == null) goto L32;
        hz6.a.c(r110, r100);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r107);
        return;
    L31:
        hz6.a.f487706d.put(r108, r100);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L8:
        if (r106.has("total_cost") == false) goto L10;
        int r111 = r106.get("total_cost").getAsInt();
    L11:
        r103.put("server_task_duration", String.valueOf(r111));
        Response r112 = r102.raw();
        if (r112 == null) goto L20;
        Object r113 = r112.getExtraInfo();
        if (r113 == null) goto L20;
        if ((r113 instanceof BaseHttpRequestInfo) == false) goto L18;
        r105 = (BaseHttpRequestInfo) r113;
    L18:
        if (r105 == null) goto L20;
        long r114 = r105.totalTime;
        r103.put("total_request_duration", String.valueOf(r114));
        r103.put("network_duration", String.valueOf(r114 - ((long) r111)));
        String r115 = r103.put("network_total_received_bytes", String.valueOf(r105.receivedByteCount));
        goto L20
    L10:
        r111 = 0;
        goto L11
    L5:
        r106 = null;
        goto L6
    }
}
