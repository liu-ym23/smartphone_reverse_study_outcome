package y86;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.b;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.EventSubType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f566911a = 0;

    static {
    }

    public static void c(String r100, JSONObject r101) {
        b r102 = b.a.f245076a;
        GeckoGlobalConfig r103 = b.a();
        if (r103 == null) goto L16;
        az5.a r104 = r103.getStatisticMonitor();
        if (r104 == null) goto L17;
        r101.put("params_for_special", "gecko");
        r101.put("os", 0);
        r101.put("sdk_version", "5.3.22.1-bugfix");
        long r105 = System.currentTimeMillis();
        r101.put("local_time", r105);
        GeckoGlobalConfig r106 = b.a();
        if (r106 == null) goto L14;
        r101.put("aid", r106.getAppId());
        r101.put("dur_from_cold_start", r105 - r106.getAppColdStartTime());
    L14:
        r104.a(r100, r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        GeckoLogger.w("UploadStatistic.uploadEventWithJson", th);
        return;
    L17:
        return;
    }

    public static void a(EventSubType r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("sub_type", r100.getType());
        if (r101 == null) goto L5;
        r103.put(LocationMonitorConst.ERR_MSG, r101);
    L5:
        if (r102 == null) goto L7;
        r103.put("extra", r102);
    L7:
        c("geckosdk_event_message", r103);
    }

    public static void b(EventSubType r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("sub_type", r100.getType());
        if (r101 == null) goto L5;
        r104.put("access_key", r101);
    L5:
        if (r102 == null) goto L7;
        r104.put("channels", r102);
    L7:
        if (r103 == null) goto L9;
        r104.put(LocationMonitorConst.ERR_MSG, r103);
    L9:
        c("geckosdk_event_message", r104);
    }
}
