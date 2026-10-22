package fh4;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.common.wschannel.WsConstants;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f477053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f477055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f477056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f477057f;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: Exception -> L5
        r100.put("event_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);     // Catch: Exception -> L5
        r100.put("service", this.f477054c);     // Catch: Exception -> L5
        r100.put("status", this.f477055d);     // Catch: Exception -> L5
        r100.put("category", this.f477056e);     // Catch: Exception -> L5
        r100.put("metric", this.f477057f);     // Catch: Exception -> L5
        r100.put(WsConstants.KEY_SESSION_ID, com.bytedance.crash.i.b());     // Catch: Exception -> L5
        r100.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L5
        r100.put("crash_time", this.f477053b);     // Catch: Exception -> L5
        r100.put("process_name", com.bytedance.crash.util.b.c());     // Catch: Exception -> L5
        r100.put("crash_thread_name", this.f477052a);     // Catch: Exception -> L5
    L4:
        return r100;
    }

    public j(String r100, long r101, String r102, int r103, JSONObject r104, JSONObject r105) {
        this.f477052a = r100;
        this.f477053b = r101;
        this.f477054c = r102;
        this.f477055d = r103;
        this.f477056e = r104;
        this.f477057f = r105;
    }
}
