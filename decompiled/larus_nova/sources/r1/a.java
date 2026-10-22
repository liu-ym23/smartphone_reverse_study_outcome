package r1;

import com.apm.lite.MonitorCrash;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535545a = 0;

    static {
        new ConcurrentLinkedQueue();
    }

    public static int a(String... r100) {
        return com.apm.lite.k.k.a(b(), -1, r100);
    }

    public static boolean e() {
        if (a(new String[]{"custom_event_settings", "npth_simple_setting", "disable_looper_monitor"}) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static JSONObject b() {
        d r100 = com.apm.lite.e.b();
        r100.getClass();
        String r101 = String.valueOf(r100.f535555b.getCommonParams().get("aid"));     // Catch: Throwable -> L5
    L6:
        e r102 = e.f535556b.get(r101);
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.f535557a;
    L5:
        r101 = "4444";
        goto L6
    }

    public static boolean d(String r100) {
        HashMap<String, e> r101 = e.f535556b;
        if (r101.get(r100) == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        com.apm.lite.j.a.a();
    L8:
        e r103 = r101.get(r100);
        if (r103 == null) goto L21;
        JSONObject r104 = r103.f535557a;
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == true) goto L18;
        return false;
    L18:
        if (r103.a() == false) goto L23;
        return true;
    L23:
        return false;
    L13:
        if (1 != com.apm.lite.k.k.a(r104, 0, new String[]{"crash_module", "switcher"})) goto L15;
        r105 = true;
        goto L16
    L21:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static void c(JSONArray r100, boolean r101) {
        com.apm.lite.k.p.b("fromnet " + r101 + " : " + r100);
        if (r101 == false) goto L7;
        Map<String, String> r102 = com.apm.lite.j.j.f29984d;
        if (r102 == null) goto L7;
        r102.clear();
    L7:
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r104 >= r100.length()) goto L24;
        JSONObject r105 = r100.optJSONObject(r104);     // Catch: Throwable -> L60
        String r106 = r105.keys().next();     // Catch: Throwable -> L60
        JSONObject r107 = r105.optJSONObject(r106);     // Catch: Throwable -> L60
        com.apm.lite.k.p.a("update config " + r106 + " : " + r107);     // Catch: Throwable -> L60
        e r108 = e.f535556b.get(r106);     // Catch: Throwable -> L60
        if (r108 == null) goto L17;
        r108.f535557a = r107;     // Catch: Throwable -> L60
        if (r107 == null) goto L18;
        JSONObject r109 = r107.optJSONObject("error_module");     // Catch: Throwable -> L60
        if (r109 == null) goto L18;
        r109.optInt("switcher");     // Catch: Throwable -> L60
        r109.optInt("err_sampling_rate");     // Catch: Throwable -> L60
    L18:
        if (r101 == false) goto L23;
        if (com.apm.lite.j.j.f29984d != null) goto L22;
        com.apm.lite.j.j.f29984d = new HashMap();     // Catch: Throwable -> L60
    L22:
        com.apm.lite.j.j.f29984d.put(r106, String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L60
        MonitorCrash.reInitAppLog(r106);     // Catch: Throwable -> L60
        goto L23
    L17:
        new e(r107, r106);     // Catch: Throwable -> L60
    L23:
        r104 = r104 + 1;
        goto L9
    L24:
        d r110 = com.apm.lite.e.b();
        r110.getClass();
        String r111 = String.valueOf(r110.f535555b.getCommonParams().get("aid"));     // Catch: Throwable -> L27
    L28:
        String r112 = null;
        if (r100.length() != 0) goto L32;
    L37:
        JSONObject r113 = null;
    L38:
        JSONObject r114 = j.f535565a;
        if (r113 != null) goto L69;
    L51:
        if (r101 == false) goto L75;
        com.apm.lite.k.h.f(new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/configCrash/configFile"), r100);     // Catch: IOException -> L59
    L67:
        if (com.apm.lite.j.j.f29981a != null) goto L56;
        com.apm.lite.j.j.f29981a = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/configCrash/configInvalid");     // Catch: Throwable -> L58
    L56:
        com.apm.lite.k.h.i(com.apm.lite.j.j.f29981a, com.apm.lite.j.j.f29984d);     // Catch: Throwable -> L58
        return;
    L76:
        return;
    L75:
        return;
    L69:
        JSONObject r115 = r113.optJSONObject("exception_modules");     // Catch: Throwable -> L49 JSONException -> L50
        if (r115 == null) goto L44;
        r112 = r115.optString("npth");     // Catch: Throwable -> L49 JSONException -> L50
    L44:
        PolarisFileWrapper r116 = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/configCrash/configNative");     // Catch: Throwable -> L49 JSONException -> L50
        if (r112 == null) goto L47;
        JSONObject r117 = new JSONObject(r112);     // Catch: Throwable -> L49 JSONException -> L50
        j.f535565a = r117;     // Catch: Throwable -> L49 JSONException -> L50
        com.apm.lite.k.h.g(r116, j.e(r117));     // Catch: Throwable -> L49 JSONException -> L50
        goto L51
    L47:
        j.f535565a = new JSONObject();     // Catch: Throwable -> L49 JSONException -> L50
    L49:
        com.apm.lite.c.a();
    L32:
        if (r103 >= r100.length()) goto L37;
        r113 = r100.optJSONObject(r103).optJSONObject(r111);
        if (r113 != null) goto L38;
        r103 = r103 + 1;
    L27:
        r111 = "4444";
        goto L28
    }
}
