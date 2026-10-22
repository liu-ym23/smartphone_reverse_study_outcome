package y50;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f566210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f566211b = null;

    static {
        f566210a = TokenCert.Companion.with("bpea-broadcastfulllink_get_network_type");
        f566211b = new LinkedHashMap();
    }

    public static JSONObject a(Map r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$asArgs");
        JSONObject r102 = new JSONObject();
        Iterator r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.putOpt((String) r104.getKey(), String.valueOf(r104.getValue()));
        goto L4
    L6:
        Iterator r105 = ((LinkedHashMap) f566211b).entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.putOpt((String) r106.getKey(), String.valueOf(r106.getValue()));
        goto L8
    L11:
        if (r101 == Integer.MIN_VALUE) goto L13;
        r102.put("status_code", String.valueOf(r101));
    L13:
        r102.put("network_status", NetworkUtils.a(TTMiddlewareLiveSDK.hostMiddlewareService().appContext().context(), f566210a));
        r102.put("role_type", 2);
        return r102;
    }

    public static void b(LiveTracingMonitor.EventModule r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "args");
        LiveTracingMonitor.d("ttlive_anchor_server_api_call", r100, LiveTracingMonitor.EventType.SERVER_API_CALL, r101);
    }
}
