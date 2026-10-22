package pt3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements nu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f530643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f530644b;

    @Override // nu3.c
    public final String getLogType() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // nu3.c
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L4
        r100.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: Exception -> L4
        r100.put("service", "apm_error");     // Catch: Exception -> L4
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        r101.put("type", "large_data");     // Catch: Exception -> L4
        r101.put("error_service", this.f530643a);     // Catch: Exception -> L4
        r101.put("error_log_type", this.f530644b);     // Catch: Exception -> L4
        r100.put("category", r101);     // Catch: Exception -> L4
        return r100;
    L4:
        return null;
    }

    public d(JSONObject r100, JSONObject r101) {
        this.f530643a = r100;
        this.f530644b = r101;
    }
}
