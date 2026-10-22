package xh8;

import com.bytedance.apm.ApmAgent;
import com.facebook.common.statfs.StatFsHelper;
import com.larus.utils.logger.FLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    public static void a(Throwable r100, String r101) {
        StatFsHelper r102 = StatFsHelper.getInstance();
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L5
        r103.put("exp_type", r100.getClass().getSimpleName());     // Catch: JSONException -> L5
        r103.put("exp_msg", r100.getMessage());     // Catch: JSONException -> L5
        r103.put("exp_method", r101);     // Catch: JSONException -> L5
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L5
        r104.put("avl_internal_space", r102.getAvailableStorageSpace(StatFsHelper.StorageType.INTERNAL));     // Catch: JSONException -> L5
        r104.put("avl_external_space", r102.getAvailableStorageSpace(StatFsHelper.StorageType.EXTERNAL));     // Catch: JSONException -> L5
        ApmAgent.monitorEvent("flow_sqlite_monitor", r103, r104, null);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FlowSQLiteMonitor", "monitor err", e);
    }
}
