package fd7;

import com.alipay.sdk.m.p.e;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.BridgeManager;
import com.bytedance.services.apm.api.IApmAgent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476541a = 0;

    public a() {
    }

    static {
    }

    public static JSONObject a(String r100, JSONObject r101) {
        JSONObject r102 = null;
        if (Intrinsics.areEqual(StringsKt.substringAfterLast$default(r100, ".", null, 2, null), "fetch") == false) goto L16;
        r102 = new JSONObject();
        r102.put("bridge_name", r100);
        String r103 = "";
        if (r101 == null) goto L9;
        String r104 = r101.optString(e.f25671s);
        if (r104 == null) goto L9;
    L10:
        r102.put("fetch_method", r104);
        if (r101 == null) goto L15;
        String r105 = r101.optString("url");
        if (r105 == null) goto L15;
        r103 = r105;
    L15:
        r102.put("fetch_url", r103);
    L9:
        r104 = "";
    L16:
        return r102;
    }

    public static void b(int r100, String r101, JSONObject r102, JSONObject r103) {
        JSONObject r104 = new JSONObject();
        r104.put(r101, r100);
        IApmAgent r105 = (IApmAgent) ServiceManager.getService(IApmAgent.class);
        if (r105 == null) goto L5;
        r105.monitorEvent("component_bridge_sdk_monitor", r104, r102, r103);
    L5:
        BridgeManager.INSTANCE.getBridgeConfig().getBridgeMonitorInterceptor();
    }
}
