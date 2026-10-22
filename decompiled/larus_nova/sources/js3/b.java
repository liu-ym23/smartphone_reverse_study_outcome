package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f500208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f500209c;

    @Override // hs3.c
    public final boolean b() {
        return true;
    }

    @Override // hs3.c
    public final String d() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    @Override // hs3.c
    public final String e() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    @Override // hs3.c
    public final JSONObject a() {
        if (this.f500209c != null) goto L12;
        this.f500209c = new JSONObject();
    L12:
        this.f500209c.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L10
        this.f500209c.put("service", this.f500207a);     // Catch: JSONException -> L10
        this.f500209c.put("status", 0);     // Catch: JSONException -> L10
        JSONObject r100 = this.f500208b;     // Catch: JSONException -> L10
        if (r100 == null) goto L8;
        this.f500209c.put("category", r100);     // Catch: JSONException -> L10
    L8:
        return this.f500209c;
    L10:
        return null;
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        String r101 = this.f500207a;
        return zs3.c.f573475a.getServiceSwitch(r101);
    }

    public b(String r100, JSONObject r101) {
        this.f500207a = r100;
        this.f500208b = r101;
        this.f500209c = null;
    }
}
