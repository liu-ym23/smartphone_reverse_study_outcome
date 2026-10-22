package hu;

import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final void a(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("status_code", String.valueOf(r100));
        LiveTracingMonitor.EventModule r103 = LiveTracingMonitor.EventModule.REAL_NAME;
        JSONObject r104 = new JSONObject();
        r104.put("status_code", r100);     // Catch: JSONException -> L8
    L12:
        r104.put("category_1", r101);     // Catch: JSONException -> L9
    L6:
        com.bytedance.android.gamecp.common.monitor.a r105 = new com.bytedance.android.gamecp.common.monitor.a();
        r105.f56543d = r104;
        r105.f56541b = r103;
        r105.f56540a = "ttlive_cert_minor_intercept";
        r105.f56542c = r102;
        r105.f56544e = null;
        r105.f56545f = false;
        r105.f56546g = false;
        r105.f56547h = true;
        r105.f56548i = false;
        r105.a();
    }
}
