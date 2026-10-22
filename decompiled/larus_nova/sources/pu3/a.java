package pu3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import nu3.c;
import org.json.JSONException;
import org.json.JSONObject;
import xu3.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f530721a;

    public abstract JSONObject c();

    public abstract JSONObject d();

    public abstract JSONObject e();

    public abstract String f();

    @Override // nu3.c
    public final String getLogType() {
        return UploadTypeInf.PERFORMANCE;
    }

    @Override // nu3.c
    public final JSONObject a() {
    L16:
        return null;
    L3:
        if (this.f530721a != null) goto L5;
        this.f530721a = b();     // Catch: JSONException -> L16
    L5:
        this.f530721a.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.PERFORMANCE);     // Catch: JSONException -> L16
        this.f530721a.put("service", f());     // Catch: JSONException -> L16
        JSONObject r100 = d();     // Catch: JSONException -> L16
        if (d.c(r100) == true) goto L8;
        this.f530721a.put("extra_values", r100);     // Catch: JSONException -> L16
    L8:
        JSONObject r101 = c();     // Catch: JSONException -> L16
        if (d.c(r101) == true) goto L11;
        this.f530721a.put("extra_status", r101);     // Catch: JSONException -> L16
    L11:
        JSONObject r102 = e();     // Catch: JSONException -> L16
        if (d.c(r102) == true) goto L14;
        this.f530721a.put("filters", r102);     // Catch: JSONException -> L16
    L14:
        return this.f530721a;
    }

    public JSONObject b() {
        return new JSONObject();
    }

    public a() {
    }
}
