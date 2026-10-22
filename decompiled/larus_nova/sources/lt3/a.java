package lt3;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements nu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f510661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f510662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f510663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f510664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f510665f;

    @Override // nu3.c
    public final String getLogType() {
        return UploadTypeInf.SERVICE_MONITOR;
    }

    @Override // nu3.c
    public final JSONObject a() {
        JSONObject r100 = this.f510665f;     // Catch: Exception -> L15
        if (r100 != null) goto L5;
        r100 = new JSONObject();     // Catch: Exception -> L15
    L5:
        r100.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: Exception -> L15
        r100.put("service", this.f510660a);     // Catch: Exception -> L15
        r100.put("status", this.f510661b);     // Catch: Exception -> L15
        JSONObject r101 = this.f510662c;     // Catch: Exception -> L15
        if (r101 == null) goto L8;
        r100.put("value", r101);     // Catch: Exception -> L15
    L8:
        JSONObject r102 = this.f510663d;     // Catch: Exception -> L15
        if (r102 == null) goto L11;
        r100.put("category", r102);     // Catch: Exception -> L15
    L11:
        JSONObject r103 = this.f510664e;     // Catch: Exception -> L15
        if (r103 == null) goto L14;
        r100.put("metric", r103);     // Catch: Exception -> L15
    L14:
        return r100;
    L16:
        if (xu3.a.a() == false) goto L24;
        av3.a r104 = av3.b.f16366a;
        if (r104 == null) goto L25;
        r104.b();
        return null;
    L25:
        return null;
    L24:
        return null;
    }

    public final void b() {
        this.f510662c = xu3.d.h(this.f510662c);
        this.f510663d = xu3.d.h(this.f510663d);
        this.f510664e = xu3.d.h(this.f510664e);
        this.f510665f = xu3.d.h(this.f510665f);
    }

    @Override // nu3.c
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f510660a);
    }

    public final String toString() {
        return "CommonEvent{serviceName='" + this.f510660a + "'}";
    }

    public a(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        this.f510660a = r100;
        this.f510661b = r101;
        this.f510662c = r102;
        this.f510663d = r103;
        this.f510664e = r104;
        this.f510665f = r105;
    }
}
