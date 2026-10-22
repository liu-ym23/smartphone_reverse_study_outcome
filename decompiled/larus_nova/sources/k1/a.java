package k1;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.apm.lite.e;
import com.apm.lite.k.k;
import com.apm.lite.k.n;
import com.apm.lite.k.p;
import com.apm.lite.k.u;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f501330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f501331b;

    public a() {
        this.f501330a = new JSONObject();
    }

    public a(JSONObject r100) {
        this.f501330a = r100;
    }

    public static void g(JSONObject r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r104 = r100.optJSONObject(r101);
        if (r104 == null) goto L10;
    L7:
        r104.put(r102, r103);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L10:
        r104 = new JSONObject();     // Catch: Throwable -> L9
        r100.put(r101, r104);     // Catch: Throwable -> L9
        goto L7
    }

    public static void h(JSONObject r100, Throwable r101) {
        String r102 = "npth_err_info";
        if (r100.opt("npth_err_info") == null) goto L11;
        int r103 = 0;
    L7:
        if (r103 >= 5) goto L20;
        if (r100.opt("npth_err_info" + r103) == null) goto L16;
        r103 = r103 + 1;
        goto L7
    L16:
        r102 = "npth_err_info" + r103;     // Catch: Throwable -> L15
    L19:
        return;
    L20:
        return;
    L11:
        r100.put(r102, u.b(r101));     // Catch: Throwable -> L15
    }

    public static void i(JSONObject r100, Map<? extends String, ? extends String> r101) {
        if (r101 != null) goto L10;
        return;
    L10:
        Iterator<Map.Entry<? extends String, ? extends String>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<? extends String, ? extends String> r103 = r102.next();     // Catch: Throwable -> L9
        r100.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L9
    L15:
        return;
    }

    public static void j(JSONObject r210, JSONObject r211) {
        r210.put("storage", r211);     // Catch: Throwable -> L5
    L6:
        long r100 = r211.optLong(Scraps.INNER_FREE);
        long r101 = r211.optLong(Scraps.SDCARD_FREE);
        long r102 = r211.optLong("inner_free_real");
        String r103 = "1M - 64M";
        if (r100 > 1024) goto L10;
        String r104 = "0 - 1K";
    L23:
        if (r102 > 1024) goto L26;
        String r105 = "0 - 1K";
    L39:
        if (r101 > 1024) goto L42;
        r103 = "0 - 1K";
    L54:
        g(r210, "filters", Scraps.INNER_FREE, r104);
        g(r210, "filters", "inner_free_real", r105);
        g(r210, "filters", Scraps.SDCARD_FREE, r103);
        return;
    L42:
        if (r101 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L45;
        r103 = "1K - 64K";
        goto L54
    L45:
        if (r101 > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L48;
        r103 = "64K - 512K";
        goto L54
    L48:
        if (r101 > 1048576) goto L51;
        r103 = "512K - 1M";
        goto L54
    L51:
        if (r101 <= 67108864) goto L54;
        r103 = "64M - ";
        goto L54
    L26:
        if (r102 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L29;
        r105 = "1K - 64K";
        goto L39
    L29:
        if (r102 > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L32;
        r105 = "64K - 512K";
        goto L39
    L32:
        if (r102 > 1048576) goto L35;
        r105 = "512K - 1M";
        goto L39
    L35:
        if (r102 > 67108864) goto L37;
        r105 = "1M - 64M";
        goto L39
    L37:
        r105 = "64M - ";
        goto L39
    L10:
        if (r100 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L13;
        r104 = "1K - 64K";
        goto L23
    L13:
        if (r100 > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L16;
        r104 = "64K - 512K";
        goto L23
    L16:
        if (r100 > 1048576) goto L19;
        r104 = "512K - 1M";
        goto L23
    L19:
        if (r100 > 67108864) goto L21;
        r104 = "1M - 64M";
        goto L23
    L21:
        r104 = "64M - ";
        goto L23
    }

    public static void m(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L55;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L57;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L34
    L8:
        if (r102.hasNext() == false) goto L58;
        String r103 = r102.next();     // Catch: JSONException -> L34
        Object r104 = r100.opt(r103);     // Catch: JSONException -> L34
        if (r104 == null) goto L12;
        if ((r104 instanceof JSONObject) == true) goto L16;
        if ((r104 instanceof JSONArray) == false) goto L32;
        JSONArray r105 = r101.optJSONArray(r103);     // Catch: JSONException -> L34
        if (r105 == null) goto L8;
        JSONArray r106 = (JSONArray) r104;     // Catch: JSONException -> L34
        int r107 = 0;
        if (r106.length() != 1) goto L30;
        if ((r106.opt(0) instanceof JSONObject) == false) goto L30;
        if ((r105.opt(0) instanceof JSONObject) == false) goto L30;
        JSONObject r108 = JSONArrayProtectorUtils.getJSONObject(r106, 0);     // Catch: JSONException -> L34
        JSONObject r109 = JSONArrayProtectorUtils.getJSONObject(r105, 0);     // Catch: JSONException -> L34
    L17:
        m(r108, r109);     // Catch: JSONException -> L34
    L30:
        if (r107 >= r105.length()) goto L8;
        r106.put(r105.get(r107));     // Catch: JSONException -> L34
        r107 = r107 + 1;     // Catch: JSONException -> L34
        goto L30
    L32:
        Object r110 = r101.opt(r103);     // Catch: JSONException -> L34
    L13:
        r100.put(r103, r110);     // Catch: JSONException -> L34
        goto L8
    L16:
        r108 = JSONObjectProtectorUtils.getJSONObject(r100, r103);     // Catch: JSONException -> L34
        r109 = JSONObjectProtectorUtils.getJSONObject(r101, r103);     // Catch: JSONException -> L34
        goto L17
    L12:
        r110 = r101.opt(r103);     // Catch: JSONException -> L34
        goto L13
    L58:
        return;
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L57:
        return;
    }

    public final void a(long r100) {
        b("app_start_time", Long.valueOf(r100));     // Catch: Exception -> L4
        b("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(r100)));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b(String r100, Object r101) {
        this.f501330a.put(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        p.c();
    }

    public final void d(List r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L5;
    L13:
        b("patch_info", r101);
        return;
    L5:
        if (r100.isEmpty() == true) goto L13;
        Iterator r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r101.put((String) r102.next());
        goto L9
    L11:
        b("patch_info", r101);
    }

    public final void e(Map r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L6;
        this.f501330a.put("plugin_info", r101);     // Catch: Exception -> L12
        return;
    L6:
        Iterator r102 = r100.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();     // Catch: Exception -> L12
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        r104.put("package_name", r103);     // Catch: Exception -> L12
        r104.put("version_code", r100.get(r103));     // Catch: Exception -> L12
        r101.put(r104);     // Catch: Exception -> L12
        goto L8
    L10:
        this.f501330a.put("plugin_info", r101);     // Catch: Exception -> L12
        return;
    }

    public final boolean k() {
        Object r100 = this.f501330a.opt("data");
        if ((r100 instanceof JSONArray) == false) goto L7;
        JSONObject r101 = ((JSONArray) r100).optJSONObject(0);
    L6:
        return !k.d(r101);
    L7:
        r101 = this.f501330a;
        goto L6
    }

    public final c q() {
        if (this.f501331b != null) goto L6;
        Context r100 = e.f29909a;
        c r101 = new c();
        this.f501331b = r101;
        f(r101);
    L6:
        return this.f501331b;
    }

    public static boolean o(String r100) {
        if (new q1.d.a(new PolarisFileWrapper(n.b(e.f29909a, r100), "fds.txt")).a() <= 960) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean p(String r100) {
        if (new q1.d.C7263d(new PolarisFileWrapper(n.b(e.f29909a, r100), "threads.txt")).a() <= 350) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(c r100) {
        b("header", r100.f501337a);
        this.f501331b = r100;
    }

    public final void n(Map r100) {
        if (r100 == null) goto L28;
        Object r101 = this.f501330a.opt("data");
        if ((r101 instanceof JSONArray) == false) goto L6;
        JSONObject r102 = ((JSONArray) r101).optJSONObject(0);
    L8:
        if (r102 != null) goto L10;
        JSONObject r103 = new JSONObject();
    L13:
        Iterator r104 = ((HashMap) r100).entrySet().iterator();
    L15:
        if (r104.hasNext() == false) goto L20;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), r105.getValue());     // Catch: JSONException -> L19
        goto L15
    L20:
        b("filters", r103);
        return;
    L10:
        r103 = r102.optJSONObject("filters");
        if (r103 != null) goto L13;
        r103 = new JSONObject();
        b("filters", r103);
        goto L13
    L6:
        r102 = this.f501330a;
        goto L8
    }

    public final void c(String r100, String r101) {
        Object r102 = this.f501330a.opt("data");
        if ((r102 instanceof JSONArray) == false) goto L5;
        JSONObject r103 = ((JSONArray) r102).optJSONObject(0);
    L6:
        g(r103, "filters", r100, r101);
        return;
    L5:
        r103 = this.f501330a;
        goto L6
    }

    public final void l(String r100, String r101) {
        Object r102 = this.f501330a.opt("data");
        if ((r102 instanceof JSONArray) == false) goto L5;
        JSONObject r103 = ((JSONArray) r102).optJSONObject(0);
    L6:
        g(r103, "custom", r100, r101);
        return;
    L5:
        r103 = this.f501330a;
        goto L6
    }
}
