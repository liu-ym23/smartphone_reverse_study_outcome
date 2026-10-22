package ss3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static void a(JSONObject r100) throws JSONException {
        r100.put("timestamp", System.currentTimeMillis());
        r100.put("crash_time", System.currentTimeMillis());
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());
        r100.put("process_name", com.bytedance.apm.d.c());
        r100.put("event_type", UploadTypeInf.BATTERY_EXCEPTION_TRACE);
        r100.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }
}
