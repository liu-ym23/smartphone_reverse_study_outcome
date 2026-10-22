package ss3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static void a(JSONObject r3) throws JSONException {
        r3.put("timestamp", System.currentTimeMillis());
        r3.put("crash_time", System.currentTimeMillis());
        r3.put("is_main_process", d.k());
        r3.put("process_name", d.c());
        r3.put("event_type", UploadTypeInf.BATTERY_EXCEPTION_TRACE);
        r3.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
    }
}
