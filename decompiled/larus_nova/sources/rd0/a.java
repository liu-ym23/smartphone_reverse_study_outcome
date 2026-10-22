package rd0;

import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.zb1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import od0.c;
import od0.d;
import org.json.JSONObject;
import vm2.i;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f537202a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r100, String r101, String r102, int r103, String r110, JSONObject r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "traceBusiness");
        Intrinsics.checkNotNullParameter(r101, "traceEvent");
        Intrinsics.checkNotNullParameter(r102, "traceStep");
        Intrinsics.checkNotNullParameter(r111, "extraInfo");
        Intrinsics.checkNotNullParameter(r112, "traceIndexMap");
        c.a(r111);
        od0.a.a(r111);
        d.a(r111);
        int r104 = b.f537203a;
        Intrinsics.checkNotNullParameter(r100, "traceBusiness");
        Intrinsics.checkNotNullParameter(r101, "traceEvent");
        Intrinsics.checkNotNullParameter(r102, "traceStep");
        Intrinsics.checkNotNullParameter(r112, "traceIndexMap");
        int r105 = e.f64997m;
        e.a r106 = e.b.a(r101, r100);
        r106.f65012c = "webcast_client_multi_scene";
        r106.f65013d = r102;
        com.bytedance.android.livesdk.user.e r107 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user();
        if (r107 == null) goto L6;
        String r108 = r107.n();
        if (r108 == null) goto L6;
    L7:
        r106.f65016g = r108;
        m<IRoom> r109 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r109 == null) goto L14;
        IRoom r113 = r109.getValue();
        if (r113 == null) goto L14;
        String r114 = r113.getOwnerUserIdString();
        if (r114 == null) goto L14;
    L15:
        r106.f65015f = r114;
        m<IRoom> r115 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r115 == null) goto L20;
        IRoom r116 = r115.getValue();
        if (r116 == null) goto L20;
        String r117 = r116.getIdStr();
    L21:
        r106.f65014e = r117;
        r106.f65017h = Integer.valueOf(r103);
        r106.f65018i = r110;
        Intrinsics.checkNotNullParameter(r112, "index");
        r106.f65019j = r112;
        String r118 = r106.a().toString();
        KmpEnv r119 = KmpEnv.f255139a;
        if (v.a() == false) goto L25;
        jy0.b.a("MultiTraceMonitor", "traceMeta : " + r118 + " | extra : " + r111);
    L25:
        if (hd0.c.f().h() == true) goto L38;
        zb1 r120 = (zb1) i.E.getValue(null, i.f556291a[29]);
        if (r120.B4().contains(r100) == false) goto L29;
    L34:
        boolean r121 = true;
    L35:
        if (r121 == false) goto L38;
        jy0.b.f("MultiTraceMonitor", "current trace event in blackList skip", null, 4);
        return;
    L29:
        if (r120.D2().contains(r101) == true) goto L34;
        if (r120.E6().contains(r102) == true) goto L34;
        r121 = false;
    L38:
        j01.e r122 = new j01.e(r101, r100);
        JSONObject r123 = new JSONObject();
        JSONObject r124 = new JSONObject();
        JSONObject r125 = new JSONObject();
        Intrinsics.checkNotNullParameter(r122, "metaBuilder");
        Intrinsics.checkNotNullParameter(r124, "category");
        Intrinsics.checkNotNullParameter(r125, "metric");
        Intrinsics.checkNotNullParameter(r123, "extra");
        r122.d(ProductId.MULTI_SCENE);
        r122.g(r102);
        r122.a(b.a());
        String r126 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
        if (r126 == null) goto L41;
        r122.i(r126);
    L41:
        r122.e(b.b());
        r122.f(r103);
        if (r110 != null) goto L44;
        r110 = "";
    L44:
        Intrinsics.checkNotNullParameter(r110, "msg");
        r122.f496788a.f522483k = r110;
        r122.b(r112);
        Intrinsics.checkNotNullParameter(r123, "json");
        Intrinsics.checkNotNullParameter(r111, "jsonObject");
        j01.d.a(r123, r111);
        ((j01.b) f.a(j01.b.class)).R4(r122.f496788a, r124, r125, r123);
        return;
    L20:
        r117 = null;
    L14:
        r114 = null;
    L6:
        r108 = "";
        goto L7
    }

    public static void b(MultiTraceData$TraceBusiness r100, MultiTraceData$TraceEvent r101, String r102, int r110, String r111, JSONObject r112, int r113) {
        if ((r113 & 8) == 0) goto L5;
        int r103 = 0;
    L7:
        if ((r113 & 16) == 0) goto L9;
        r111 = "";
    L9:
        String r104 = r111;
        if ((r113 & 32) == 0) goto L12;
        r112 = new JSONObject();
    L12:
        JSONObject r105 = r112;
        if ((r113 & 64) == 0) goto L15;
        LinkedHashMap r114 = new LinkedHashMap();
    L16:
        LinkedHashMap r106 = r114;
        Intrinsics.checkNotNullParameter(r100, "traceBusiness");
        Intrinsics.checkNotNullParameter(r101, "traceEvent");
        Intrinsics.checkNotNullParameter(r102, "traceStep");
        Intrinsics.checkNotNullParameter(r105, "extraInfo");
        Intrinsics.checkNotNullParameter(r106, "traceIndexMap");
        a(r100.getBusName(), r101.getEventName(), r102, r103, r104, r105, r106);
        return;
    L15:
        r114 = null;
        goto L16
    L5:
        r103 = r110;
        goto L7
    }

    @Deprecated(message = "新增trace使用多人场景monitor接口上报")
    public static void c(LinkMonitorData r100, ProductId r101, String r102, JSONObject r103, MultiLinkEventModule r104, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r101, "productId");
        Intrinsics.checkNotNullParameter(r102, "businessType");
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("tracing_event_type", r100.getServiceName());
        r105.put("tracing_event_module", r104.getName());
        nd0.c.f518746a.getClass();
        Intrinsics.checkNotNullParameter(r100, "linkMonitorData");
        r105.put("tracing_common_key", nd0.c.u(r100.getEventType()));
        j01.e r106 = new j01.e(r100.getServiceName(), r102);
        JSONObject r107 = new JSONObject();
        JSONObject r108 = new JSONObject();
        JSONObject r109 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "metaBuilder");
        Intrinsics.checkNotNullParameter(r108, "category");
        Intrinsics.checkNotNullParameter(r109, "metric");
        Intrinsics.checkNotNullParameter(r107, "extra");
        r106.a(b.a());
        String r112 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
        if (r112 == null) goto L5;
        r106.i(r112);
    L5:
        r106.e(b.b());
        String r113 = r103.optString("channel_id");
        if (r113 == null) goto L8;
        r106.h(r113);
    L8:
        String r114 = r103.optString("log_id");
        if (r114 == null) goto L11;
        r106.c(r114);
    L11:
        r106.d(r101);
        r106.g(r100.getEventTypeValue());
        r106.b(r105);
        r106.f(r110);
        Intrinsics.checkNotNullParameter(r111, "msg");
        r106.f496788a.f522483k = r111;
        Intrinsics.checkNotNullParameter(r107, "json");
        Intrinsics.checkNotNullParameter(r103, "jsonObject");
        j01.d.a(r107, r103);
        ((j01.b) f.a(j01.b.class)).R4(r106.f496788a, r108, r109, r107);
    }
}
