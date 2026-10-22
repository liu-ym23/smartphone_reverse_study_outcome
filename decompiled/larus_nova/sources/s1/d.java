package s1;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.AttachUserData;
import com.apm.lite.CrashType;
import com.apm.lite.ICommonParams;
import com.apm.lite.k.u;
import com.apm.lite.k.v;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashType f540104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f540105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ICommonParams f540106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f540107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f540108e;

    public interface a {
        k1.a a(int r100, k1.a r101);

        void a();

        k1.a b(int r100, k1.a r101);
    }

    public k1.a b(k1.a r100) {
        return r100;
    }

    public boolean d() {
        return this instanceof s1.a;
    }

    public void e() {
    }

    public void f() {
    }

    public k1.a a(int r110, k1.a r111) {
        if (r111 != null) goto L4;
        r111 = new k1.a();
    L4:
        int r100 = 0;
        if (r110 != 0) goto L7;
        Context r112 = com.apm.lite.e.f29909a;
        r111.f501330a.put("miniapp_id", 0);     // Catch: JSONException -> L89
        r111.f501330a.put("miniapp_version", null);     // Catch: JSONException -> L89
    L91:
        Context r113 = com.apm.lite.e.f29909a;
        r111.e(this.f540106c.getPluginInfo());     // Catch: Throwable -> L94
    L96:
        Context r114 = com.apm.lite.e.f29909a;
        r111.b("process_name", com.apm.lite.k.a.i());
    L97:
        return r111;
    L94:
        th = move-exception;
        HashMap r101 = new HashMap();     // Catch: Throwable -> L100
        r101.put("Fetch info failed:\n" + u.b(th), 0);     // Catch: Throwable -> L100
        r111.e(r101);     // Catch: Throwable -> L100
    L89:
        e = move-exception;
        e.printStackTrace();
        goto L91
    L7:
        if (r110 == 1) goto L27;
        if (r110 == 2) goto L22;
        if (r110 == 4) goto L19;
        if (r110 != 5) goto L97;
        if ((!(this instanceof k)) == false) goto L97;
        k1.a.j(r111.f501330a, v.a());
        goto L97
    L19:
        if (d() == false) goto L97;
        f();
        goto L97
    L22:
        if (this.f540108e == null) goto L25;
        r100 = 60;
    L25:
        r111.b(Scraps.BATTERY, Integer.valueOf(r100));
        r111.n(com.apm.lite.e.f29914f.f29902c);
        goto L97
    L27:
        if (com.apm.lite.k.a.h(com.apm.lite.e.f29909a) == true) goto L29;
        r111.b("remote_process", 1);
    L29:
        r111.b("pid", Integer.valueOf(Process.myPid()));
        r111.a(com.apm.lite.e.f29911c);
        c r115 = this.f540107d;
        if (r115 == null) goto L109;
        JSONObject r102 = new JSONObject();
        r102.put("last_create_activity", c.a(r115.f540087f, r115.f540088g));     // Catch: JSONException -> L98
        r102.put("last_start_activity", c.a(r115.f540089h, r115.f540090i));     // Catch: JSONException -> L98
        r102.put("last_resume_activity", c.a(r115.f540091j, r115.f540092k));     // Catch: JSONException -> L98
        r102.put("last_pause_activity", c.a(r115.f540093l, r115.f540094m));     // Catch: JSONException -> L98
        r102.put("last_stop_activity", c.a(r115.f540095n, r115.f540096o));     // Catch: JSONException -> L98
        r102.put("alive_activities", r115.d());     // Catch: JSONException -> L98
        r102.put("finish_activities", r115.e());     // Catch: JSONException -> L98
    L33:
        r111.b("activity_trace", r102);
        JSONArray r103 = new JSONArray();
        Iterator r116 = new ArrayList(r115.f540086e).iterator();
    L35:
        if (r116.hasNext() == false) goto L37;
        r103.put(((c.a) r116.next()).toString());
        goto L35
    L37:
        JSONObject r117 = r111.f501330a.optJSONObject("custom_long");
        if (r117 != null) goto L119;
        r117 = new JSONObject();
        r111.b("custom_long", r117);
    L119:
        r117.put("activity_track", r103);     // Catch: JSONException -> L99
    L109:
        r111.d(this.f540106c.getPatchInfo());     // Catch: Throwable -> L43
    L47:
        Context r118 = com.apm.lite.e.f29909a;
        r111.b("business", "default");
        r111.b(LocationMonitorConst.IS_BACKGROUND, Boolean.valueOf(!com.apm.lite.k.a.f(this.f540105b)));
        List r119 = (List) ((HashMap) com.apm.lite.e.f29914f.f29900a).get(this.f540104a);
        HashMap r104 = new HashMap();
        JSONObject r105 = r111.f501330a.optJSONObject("custom");
        if (r105 != null) goto L51;
        r105 = new JSONObject();
        r111.b("custom", r105);
    L51:
        if (r119 == null) goto L101;
        int r106 = 0;
    L54:
        if (r106 >= r119.size()) goto L101;
        AttachUserData r107 = (AttachUserData) ListProtector.get(r119, r106);     // Catch: Throwable -> L57
        long r108 = SystemClock.uptimeMillis();     // Catch: Throwable -> L57
        k1.a.i(r105, r107.getUserData(this.f540104a));     // Catch: Throwable -> L57
        r104.put("custom_cost_" + r107.getClass().getName() + "_" + r104.size(), Long.valueOf(SystemClock.uptimeMillis() - r108));     // Catch: Throwable -> L57
    L59:
        r106 = r106 + 1;
    L57:
        th = move-exception;
        k1.a.h(r105, th);
    L101:
        int r109 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/fd").listFiles().length;     // Catch: Throwable -> L63
    L64:
        r105.put("fd_count", r109);     // Catch: Throwable -> L66
    L63:
        r109 = -1;
    L67:
        List r120 = (List) ((HashMap) com.apm.lite.e.f29914f.f29901b).get(this.f540104a);
        if (r120 == null) goto L79;
        JSONObject r121 = r111.f501330a.optJSONObject("custom_long");
        if (r121 != null) goto L73;
        r121 = new JSONObject();
        r111.b("custom_long", r121);
    L73:
        if (r100 >= r120.size()) goto L79;
        AttachUserData r122 = (AttachUserData) ListProtector.get(r120, r100);     // Catch: Throwable -> L76
        long r123 = SystemClock.uptimeMillis();     // Catch: Throwable -> L76
        k1.a.i(r121, r122.getUserData(this.f540104a));     // Catch: Throwable -> L76
        r104.put("custom_cost_" + r122.getClass().getName() + "_" + r104.size(), Long.valueOf(SystemClock.uptimeMillis() - r123));     // Catch: Throwable -> L76
    L78:
        r100 = r100 + 1;
    L76:
        th = move-exception;
        k1.a.h(r121, th);
    L79:
        Iterator r124 = r104.entrySet().iterator();
    L81:
        if (r124.hasNext() == false) goto L97;
        Map.Entry r125 = (Map.Entry) r124.next();
        r105.put((String) r125.getKey(), r125.getValue());     // Catch: Throwable -> L85
    L43:
        th = move-exception;
        r111.d(Arrays.asList(new String[]{"Fetch info failed:\n" + u.b(th)}));     // Catch: Throwable -> L46
        goto L47
    }

    public final k1.a c(k1.a r100, a r101, boolean r110) {
        if (r100 != null) goto L4;
        r100 = new k1.a();
    L4:
        k1.a r102 = r100;
        int r103 = 0;
    L5:
        e();
        if (r103 >= 6) goto L27;
        long r104 = SystemClock.uptimeMillis();
        if (r101 != null) goto L32;
    L30:
        r102 = a(r103, r102);     // Catch: Throwable -> L14
    L16:
        if (r101 == null) goto L25;
        e();     // Catch: Throwable -> L19
        r102 = r101.b(r103, r102);     // Catch: Throwable -> L19
    L20:
        if (r110 == false) goto L25;
        if (r103 == 0) goto L23;
        k1.a.m(r100.f501330a, r102.f501330a);
    L24:
        r102 = new k1.a();
        goto L25
    L23:
        r100 = r102;
    L19:
        r101.a();
    L25:
        r100.l("step_cost_" + r103, String.valueOf(SystemClock.uptimeMillis() - r104));
        r103 = r103 + 1;
    L14:
        if (r101 == null) goto L16;
        r101.a();
        goto L16
    L32:
        r102 = r101.a(r103, r102);     // Catch: Throwable -> L11
    L11:
        r101.a();
        goto L30
    L27:
        return b(r100);
    }

    public d(CrashType r100, Context r101, c r102, e r103) {
        this.f540104a = r100;
        this.f540105b = r101;
        this.f540107d = r102;
        this.f540108e = r103;
        this.f540106c = com.apm.lite.e.b().f535555b;
    }
}
