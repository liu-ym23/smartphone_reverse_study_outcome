package js3;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f500211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f500212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f500213d;

    @Override // hs3.c
    public final boolean b() {
        return true;
    }

    @Override // hs3.c
    public final JSONObject a() {
        JSONObject r100 = this.f500211b;
        if (r100 != null) goto L17;
        return null;
    L17:
        r100.put("timestamp", this.f500213d);     // Catch: JSONException -> L15
        this.f500211b.put("crash_time", this.f500213d);     // Catch: JSONException -> L15
        this.f500211b.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: JSONException -> L15
        this.f500211b.put("process_name", com.bytedance.apm.d.c());     // Catch: JSONException -> L15
        this.f500211b.put(FrescoMonitorConst.LOG_TYPE, this.f500210a);     // Catch: JSONException -> L15
        if (com.bytedance.apm.d.f190527o > com.bytedance.apm.d.h()) goto L10;
        long r101 = com.bytedance.apm.d.f190527o;     // Catch: JSONException -> L15
        if (r101 == 0) goto L10;
        this.f500211b.put("app_launch_start_time", r101);     // Catch: JSONException -> L15
    L16:
    L10:
        this.f500211b.put("app_launch_start_time", com.bytedance.apm.d.h());     // Catch: JSONException -> L15
    L12:
        return this.f500211b;
    }

    public final String toString() {
        return "ExceptionLogData{eventType='" + this.f500210a + "', logJson=" + this.f500211b + ", forceSampled=" + this.f500212c + ", time=" + this.f500213d + '}';
    }

    @Override // hs3.c
    public final String d() {
        return this.f500210a;
    }

    @Override // hs3.c
    public final String e() {
        return this.f500210a;
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        if (this.f500212c == false) goto L5;
    L8:
        return true;
    L5:
        if (zs3.c.b(this.f500210a) == true) goto L8;
        return false;
    }

    public c(String r100, JSONObject r101) {
        this(r100, r101, System.currentTimeMillis());
    }

    public c(String r100, JSONObject r101, long r102) {
        this.f500210a = r100;
        this.f500211b = r101;
        this.f500213d = r102;
    }
}
