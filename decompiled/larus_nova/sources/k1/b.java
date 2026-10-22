package k1;

import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.k.h;
import com.apm.lite.k.k;
import com.apm.lite.k.p;
import com.apm.lite.k.u;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.e;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<com.apm.lite.d> f501332a = null;

    public interface a {
        void a(JSONObject r100);
    }

    static {
        f501332a = new ConcurrentLinkedQueue();
        new ConcurrentHashMap();
    }

    public static JSONArray b(String r100, JSONArray r101) {
        JSONArray r102 = new JSONArray();
        int r103 = 0;
    L4:
        if (r103 >= r101.length()) goto L32;
        JSONObject r104 = r101.optJSONObject(r103);
        if (r104 == null) goto L31;
        JSONObject r105 = r104.optJSONObject("header");
        if (r105 == null) goto L31;
        String r106 = String.valueOf(r105.opt("aid"));
        if (r1.a.d(r106) == false) goto L31;
        String r107 = com.apm.lite.d.f(r106);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r107) == true) goto L20;
        r105.put("x-auth-token", r107);     // Catch: Throwable -> L18
    L20:
        if (TextUtils.isEmpty(r105.optString("package")) == true) goto L29;
        JSONArray r108 = r105.optJSONArray("so_list");
        if (k.c(r108) == true) goto L31;
        int r109 = 0;
    L26:
        if (r109 >= r108.length()) goto L31;
        if (r100.contains(r108.optString(r109)) == true) goto L29;
        r109 = r109 + 1;
    L29:
        r102.put(r104);
    L31:
        r103 = r103 + 1;
        goto L4
    L32:
        return r102;
    }

    public static void d(JSONObject r100, JSONArray r101, a r110) {
        p.a("uploadFromFile with allData " + r101);
        JSONArray r102 = new JSONArray();
        int r103 = 0;
    L4:
        if (r103 >= r101.length()) goto L17;
        JSONObject r104 = r101.optJSONObject(r103);
        if (r104 == null) goto L17;
        if (k.a(r104, 0, new String[]{"header", "single_upload"}) != 1) goto L29;
        JSONObject r105 = new JSONObject();
        k1.a.m(r105, r100);
        k1.a.m(r105, r104);
        r110.a(r105);
    L15:
        r103 = r103 + 1;
        goto L4
    L29:
        String r106 = com.apm.lite.d.f(k.e(r104, new String[]{"header", "aid"}));     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r106) == true) goto L14;
        JSONObject r107 = (JSONObject) r104.remove("header");     // Catch: Throwable -> L26
        r107.put("x-auth-token", r106);     // Catch: Throwable -> L26
        r104.put("header", r107);     // Catch: Throwable -> L26
    L14:
        r102.put(r104);
    L17:
        if (r102.length() != 0) goto L19;
        return;
    L19:
        JSONObject r108 = new JSONObject();
        k1.a.m(r108, r100);
        r108.put("all_data", r102);     // Catch: JSONException -> L22
    L24:
        r110.a(r108);
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static JSONArray e() {
        JSONArray r100 = new JSONArray();
        Iterator<com.apm.lite.d> r101 = f501332a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        com.apm.lite.d r102 = r101.next();
        if (r102 == null) goto L8;
        r100.put(r102.c(null, null));
    L8:
        return r100;
    }

    public static JSONArray a(String r100) {
        JSONArray r101 = new JSONArray();
        String[] r102 = r100.split("\n");
        Iterator<com.apm.lite.d> r103 = f501332a.iterator();
    L4:
        if (r103.hasNext() == false) goto L30;
        com.apm.lite.d r104 = r103.next();
        if (r104 == null) goto L30;
        String r105 = r104.e();
        int r106 = r1.a.f535545a;
        HashMap<String, e> r107 = e.f535556b;
        boolean r108 = false;
        if (r107.get(r105) == null) goto L10;
        boolean r109 = true;
    L11:
        if (r109 == true) goto L13;
        com.apm.lite.j.a.a();
    L13:
        e r110 = r107.get(r105);
        if (r110 == null) goto L25;
        JSONObject r111 = r110.f535557a;
        if (r111 != null) goto L18;
    L20:
        boolean r112 = false;
    L21:
        if (r112 == false) goto L25;
        if (r110.a() == false) goto L25;
        r108 = true;
        goto L25
    L18:
        if (1 != k.a(r111, 0, new String[]{"crash_module", "switcher"})) goto L20;
        r112 = true;
    L25:
        if (r108 == false) goto L4;
        JSONArray r113 = r104.b(r102);
        if (k.c(r113) == true) goto L4;
        r101.put(r104.c(CrashType.ANR, r113));
        goto L4
    L10:
        r109 = false;
    L30:
        return r101;
    }

    public static JSONArray c(Throwable r110, PolarisFileWrapper r111) {
        JSONArray r100 = new JSONArray();
        StackTraceElement r101 = u.f30016a;
        ArrayList r102 = new ArrayList();
        u.i(r110, r102);     // Catch: Throwable -> L38
    L4:
        StackTraceElement[] r103 = (StackTraceElement[]) r102.toArray(new StackTraceElement[r102.size()]);
        Iterator<com.apm.lite.d> r104 = f501332a.iterator();
    L6:
        if (r104.hasNext() == false) goto L33;
        com.apm.lite.d r105 = r104.next();
        if (r105 == null) goto L33;
        String r106 = r105.e();
        int r107 = r1.a.f535545a;
        HashMap<String, e> r108 = e.f535556b;
        boolean r109 = false;
        if (r108.get(r106) == null) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == true) goto L15;
        com.apm.lite.j.a.a();
    L15:
        e r113 = r108.get(r106);
        if (r113 == null) goto L27;
        JSONObject r114 = r113.f535557a;
        if (r114 != null) goto L20;
    L22:
        boolean r115 = false;
    L23:
        if (r115 == false) goto L27;
        if (r113.a() == false) goto L27;
        r109 = true;
        goto L27
    L20:
        if (1 != k.a(r114, 0, new String[]{"crash_module", "switcher"})) goto L22;
        r115 = true;
    L27:
        if (r109 == false) goto L28;
        JSONArray r116 = r105.a(r103, r110);
        if (k.c(r116) == true) goto L6;
        r100.put(r105.c(CrashType.JAVA, r116));
        goto L6
    L28:
        p.a("not enable javaCrash aid: " + r105.e());
        goto L6
    L12:
        r112 = false;
    L33:
        if (k.c(r100) == false) goto L40;
        return null;
    L40:
        h.f(new PolarisFileWrapper(r111, "all_data.json"), r100);     // Catch: IOException -> L39
    L37:
        return r100;
    }
}
