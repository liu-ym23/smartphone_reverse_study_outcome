package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f500226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f500227d;

    @Override // hs3.c
    public final boolean b() {
        return true;
    }

    @Override // hs3.c
    public final String d() {
        return UploadTypeInf.UI_ACTION;
    }

    @Override // hs3.c
    public final String e() {
        return UploadTypeInf.UI_ACTION;
    }

    @Override // hs3.c
    public final JSONObject a() {
    L7:
        return null;
    L3:
        if (this.f500227d != null) goto L5;
        this.f500227d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f500227d.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.UI_ACTION);     // Catch: JSONException -> L7
        this.f500227d.put("action", this.f500224a);     // Catch: JSONException -> L7
        this.f500227d.put("page", this.f500225b);     // Catch: JSONException -> L7
        this.f500227d.put(PerfLog.PARAM_KEY_CONTEXT_ID, this.f500226c);     // Catch: JSONException -> L7
        return this.f500227d;
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        return zs3.c.a("ui");
    }

    public f(String r100, String r101, JSONObject r102, JSONObject r103) {
        this.f500224a = r100;
        this.f500225b = r101;
        this.f500226c = r102;
        this.f500227d = r103;
    }
}
