package js3;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.j;
import com.bytedance.crash.dumper.Scraps;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements hs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f500217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f500219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f500220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f500221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f500222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f500223g;

    @Override // hs3.c
    public final boolean b() {
        return true;
    }

    @Override // hs3.c
    public final String d() {
        return UploadTypeInf.PERFORMANCE;
    }

    @Override // hs3.c
    public final JSONObject a() {
    L24:
        return null;
    L3:
        if (this.f500223g != null) goto L5;
        this.f500223g = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.f500223g.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.PERFORMANCE);     // Catch: JSONException -> L24
        this.f500223g.put("service", this.f500217a);     // Catch: JSONException -> L24
        if (j.c(this.f500220d) == true) goto L9;
        this.f500223g.put("extra_values", this.f500220d);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.f500217a) == false) goto L17;
        if (TextUtils.equals("from", this.f500223g.optString("monitor-plugin")) == false) goto L17;
        if (this.f500221e != null) goto L15;
        this.f500221e = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f500221e.put("start_mode", com.bytedance.apm.d.f190525m);     // Catch: JSONException -> L24
    L17:
        if (j.c(this.f500221e) == true) goto L20;
        this.f500223g.put("extra_status", this.f500221e);     // Catch: JSONException -> L24
    L20:
        if (j.c(this.f500222f) == true) goto L22;
        this.f500223g.put("filters", this.f500222f);     // Catch: JSONException -> L24
    L22:
        return this.f500223g;
    }

    public e() {
    }

    @Override // hs3.c
    public final String e() {
        return this.f500217a;
    }

    public e(JSONObject r100) {
        this("thread", "", null, null, r100, 0);
    }

    @Override // hs3.c
    public final boolean c(JSONObject r100) {
        if ("fps".equals(this.f500217a) == false) goto L5;
    L35:
        String r101 = this.f500217a;
        String r102 = this.f500218b;
        boolean r103 = zs3.c.f573475a.d(r101, r102);
    L37:
        if (this.f500219c == true) goto L42;
        if (r103 == true) goto L43;
        return false;
    L43:
        return true;
    L42:
        return true;
    L5:
        if (FilterTypeStringDef.FPS_DROP.equals(this.f500217a) == true) goto L35;
        if (IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE.equals(this.f500217a) == false) goto L11;
        r103 = zs3.c.b(this.f500217a);
        goto L37
    L11:
        if (Scraps.BATTERY.equals(this.f500217a) == false) goto L14;
    L21:
        r103 = true;
        goto L37
    L14:
        if ("start".equals(this.f500217a) == false) goto L23;
        if (zs3.c.a(this.f500217a) == true) goto L21;
        String r104 = this.f500218b;
        if (zs3.c.f573475a.c(r104) == true) goto L21;
        r103 = false;
        goto L37
    L23:
        if ("start_trace".equals(this.f500217a) == false) goto L34;
        if (r100 != null) goto L26;
    L33:
        r103 = zs3.c.a(this.f500217a);
        goto L37
    L26:
        if (zs3.c.b("enable_perf_data_collect") == true) goto L29;
        r100.remove("perf_data");
    L29:
        if (zs3.c.a(this.f500217a) == true) goto L33;
        JSONObject r105 = r100.optJSONObject("trace");
        if (r105 == null) goto L33;
        r105.remove("spans");
        goto L33
    L34:
        r103 = zs3.c.a(this.f500217a);
        goto L37
    }

    public e(String r100, String r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        this(r100, r101, r110, r111, r112, 0);
    }

    public e(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, int r105) {
        this.f500217a = r100;
        this.f500218b = r101;
        this.f500219c = false;
        this.f500220d = r102;
        this.f500221e = r103;
        this.f500223g = r104;
    }
}
