package lt3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements nu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f510670a;

    @Override // nu3.c
    public final String getLogType() {
        return UploadTypeInf.TRACING;
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // nu3.c
    public final JSONObject a() {
        JSONArray r100 = this.f510670a;
        JSONObject r101 = new JSONObject().put("wrapper_array_data", r100);     // Catch: Exception -> L5
        r101.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.TRACING);     // Catch: Exception -> L5
        r101.put("wrapper_type_description", 1);     // Catch: Exception -> L5
        return r101;
    L5:
        return null;
    }

    public d(JSONObject r100) {
        JSONArray r101 = new JSONArray();
        r101.put(r100);
        this.f510670a = r101;
    }

    public d(JSONArray r100) {
        this.f510670a = r100;
    }
}
