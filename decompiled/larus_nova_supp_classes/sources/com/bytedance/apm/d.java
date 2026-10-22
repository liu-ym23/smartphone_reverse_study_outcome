package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.q;
import com.bytedance.apm.util.r;
import com.bytedance.keva.KevaPreloadHolder;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.provider.ContentProviderManager;
import ff7.h;
import gs3.a;
import gs3.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static long A;
    public static long B;
    public static long C;
    public static Context a;
    public static boolean b;
    public static boolean c;
    public static long d;
    public static long e;
    public static long f;
    public static JSONObject g;
    public static b h;
    public static Map<String, String> i;
    public static IHttpService j;
    public static h k;
    public static long l;
    public static volatile int m;
    public static boolean n;
    public static long o;
    public static long p;
    public static String q;
    public static boolean r;
    public static boolean s;
    public static boolean t;
    public static final boolean u = false;
    public static List<String> v;
    public static String w;
    public static f x;
    public static gs3.d y;
    public static long z;

    static {
        g = new JSONObject();
        h = new a();
        i = Collections.emptyMap();
        j = new DefaultHttpServiceImpl();
        l = -1;
        m = -1;
        n = false;
        u = true;
        y = null;
    }

    public static String c() {
        if (TextUtils.isEmpty(q) == false) goto L6;
        q = com.bytedance.apm.util.a.a(Process.myPid());
    L6:
        return q;
    }

    public static JSONObject d() {
        return new JSONObject(String.valueOf(g));
    L5:
        return new JSONObject();
    }

    public static long e() {
        if (p != 0) goto L6;
        p = System.currentTimeMillis();
    L6:
        return p;
    }

    public static synchronized f f() {
        monitor-enter(d.class);
        f r1 = x;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> g() {
        monitor-enter(d.class);
        ApmDelegate.f.a r1 = y;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        r1.getClass();     // Catch: Throwable -> L16
        Map<String, String> r2 = g();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        HashMap r3 = new HashMap(i);     // Catch: Throwable -> L16
        r3.putAll(r2);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r3;
    L13:
        Map<String, String> r4 = i;     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    public static long h() {
        if (l != (-1)) goto L6;
        l = System.currentTimeMillis();
    L6:
        return l;
    }

    public static boolean j() {
        if (b == true) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean k() {
        boolean r1 = true;
        if (r == false) goto L6;
        return true;
    L6:
        if (a == null) goto L8;
        String r0 = c();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        r = r1;
    L21:
        return r;
    L16:
        if (r0.equals(a.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(":") == false) goto L14;
        r = false;
        goto L21
    L8:
        return l();
    }

    public static boolean l() {
        if (r == false) goto L5;
        return true;
    L5:
        String r0 = c();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(":") == false) goto L11;
        return false;
    }

    public static Context getContext() {
        return a;
    }

    public static String i(long r3) {
        long r4 = r3 - p;
        if (r4 >= KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME) goto L7;
        return "0 - 30s";
    L7:
        if (r4 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r4 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r4 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r4 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r4 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r4 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static synchronized void m(b r4) {
        monitor-enter(d.class);
        h = r4;     // Catch: Throwable -> L39
        Map<String, String> r5 = r4.getCommonParams();     // Catch: Throwable -> L39
        i = r5;     // Catch: Throwable -> L39
        if (r5 != null) goto L8;
        i = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (i.containsKey("aid") == true) goto L11;
        i.put("aid", g.optString("aid"));     // Catch: Throwable -> L39
    L11:
        if (i.containsKey("device_id") == true) goto L14;
        i.put("device_id", g.optString("device_id"));     // Catch: Throwable -> L39
    L14:
        if (i.containsKey("device_platform") == true) goto L16;
        i.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        i.put("os", "Android");     // Catch: Throwable -> L39
        if (i.containsKey("update_version_code") == true) goto L20;
        i.put("update_version_code", g.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (i.containsKey("version_code") == true) goto L23;
        i.put("version_code", g.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (i.containsKey("channel") == true) goto L26;
        i.put("channel", g.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (i.containsKey("os_api") == true) goto L29;
        i.put("os_api", Build.VERSION.SDK_INT + XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L39
    L29:
        if (j() == false) goto L34;
        if (i.containsKey("_log_level") == true) goto L34;
        i.put("_log_level", "debug");     // Catch: Throwable -> L39
    L34:
        if (x != null) goto L36;
        x = new f();     // Catch: Throwable -> L39
    L36:
        x.j = new HashMap(i);     // Catch: Throwable -> L39
        monitor-exit(d.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized void n(JSONObject r5) {
        monitor-enter(d.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (x != null) goto L7;
        x = new f();     // Catch: Throwable -> L24 Exception -> L76
    L7:
        r5.put("os", "Android");     // Catch: Throwable -> L24 Exception -> L76
        r5.put("device_platform", "android");     // Catch: Throwable -> L24 Exception -> L76
        r5.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L24 Exception -> L76
        r5.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L24 Exception -> L76
        r5.put("device_model", Build.MODEL);     // Catch: Throwable -> L24 Exception -> L76
        r5.put("device_brand", Build.BRAND);     // Catch: Throwable -> L24 Exception -> L76
        r5.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L24 Exception -> L76
        r5.put(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.apm.util.a.a(Process.myPid()));     // Catch: Throwable -> L24 Exception -> L76
        r5.put("sid", h());     // Catch: Throwable -> L24 Exception -> L76
        r5.put("phone_startup_time", e());     // Catch: Throwable -> L24 Exception -> L76
        r5.put("verify_info", r.a());     // Catch: Throwable -> L24 Exception -> L76
        r5.put("rom_version", q.c());     // Catch: Throwable -> L24 Exception -> L76
        if (r5.has("version_name") == true) goto L10;
        PackageInfo r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L76
        r5.put("version_name", r1.versionName);     // Catch: Throwable -> L24 Exception -> L76
    L12:
        if (TextUtils.isEmpty(r5.optString("app_version")) == false) goto L15;
        r5.put("app_version", r5.optString("version_name"));     // Catch: Throwable -> L24 Exception -> L76
    L15:
        if (r5.has("version_code") == true) goto L20;
        if (r1 != null) goto L18;
        r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L76
    L18:
        r5.put("version_code", r1.versionCode);     // Catch: Throwable -> L24 Exception -> L76
    L20:
        if (TextUtils.isEmpty(r5.optString("package")) == false) goto L22;
        r5.put("package", getContext().getPackageName());     // Catch: Throwable -> L24 Exception -> L76
    L22:
        r5.put("monitor_version", "5.0.21.46-alpha.1");     // Catch: Throwable -> L24 Exception -> L76
        goto L26
    L10:
        r1 = null;
    L26:
        f r2 = x;     // Catch: Throwable -> L24
        r5.optString(ContentProviderManager.PLUGIN_PROCESS_NAME);     // Catch: Throwable -> L24
        r2.getClass();     // Catch: Throwable -> L24
        f r3 = x;     // Catch: Throwable -> L24
        r3.b = r5.optString("device_id");     // Catch: Throwable -> L24
        f r4 = x;     // Catch: Throwable -> L24 Exception -> L77
        r4.a = r5.optInt("aid");     // Catch: Throwable -> L24 Exception -> L77
        f r6 = x;     // Catch: Throwable -> L24 Exception -> L77
        r6.c = r5.optString("channel");     // Catch: Throwable -> L24 Exception -> L77
        if (r5.has("update_version_code") == false) goto L34;
        if ((r5.get("update_version_code") instanceof String) == false) goto L32;
        f r7 = x;     // Catch: Throwable -> L24 Exception -> L77
        r7.d = CastIntegerProtector.valueOf(r5.optString("update_version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        goto L34
    L32:
        f r8 = x;     // Catch: Throwable -> L24 Exception -> L77
        r8.d = r5.optInt("update_version_code");     // Catch: Throwable -> L24 Exception -> L77
    L34:
        if (r5.has("version_name") == false) goto L37;
        f r9 = x;     // Catch: Throwable -> L24 Exception -> L77
        r9.e = r5.optString("version_name");     // Catch: Throwable -> L24 Exception -> L77
    L37:
        if (r5.has("manifest_version_code") == false) goto L43;
        if ((r5.get("manifest_version_code") instanceof String) == false) goto L41;
        f r10 = x;     // Catch: Throwable -> L24 Exception -> L77
        r10.f = CastIntegerProtector.valueOf(r5.optString("manifest_version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        goto L43
    L41:
        f r11 = x;     // Catch: Throwable -> L24 Exception -> L77
        r11.f = r5.optInt("manifest_version_code");     // Catch: Throwable -> L24 Exception -> L77
    L43:
        if (r5.has("version_code") == false) goto L49;
        if ((r5.get("version_code") instanceof String) == false) goto L47;
        f r12 = x;     // Catch: Throwable -> L24 Exception -> L77
        CastIntegerProtector.valueOf(r5.optString("version_code")).intValue();     // Catch: Throwable -> L24 Exception -> L77
        r12.getClass();     // Catch: Throwable -> L24 Exception -> L77
        goto L49
    L47:
        f r13 = x;     // Catch: Throwable -> L24 Exception -> L77
        r5.optInt("version_code");     // Catch: Throwable -> L24 Exception -> L77
        r13.getClass();     // Catch: Throwable -> L24 Exception -> L77
    L49:
        if (r5.has("app_version") == false) goto L51;
        f r14 = x;     // Catch: Throwable -> L24 Exception -> L77
        r14.g = r5.optString("app_version");     // Catch: Throwable -> L24 Exception -> L77
    L51:
        String r15 = r.a();     // Catch: Throwable -> L24 Exception -> L77
        if (TextUtils.isEmpty(r15) == true) goto L57;
        if (r15.equals("null") == true) goto L57;
        r5.put("release_build", r15);     // Catch: Throwable -> L24 Exception -> L77
        f r16 = x;     // Catch: Throwable -> L24 Exception -> L77
        r16.h = r5.optString("release_build");     // Catch: Throwable -> L24 Exception -> L77
    L57:
        if (r.a().isEmpty() == true) goto L59;
        f r17 = x;     // Catch: Throwable -> L24 Exception -> L77
        r17.h = r.a();     // Catch: Throwable -> L24 Exception -> L77
    L59:
        f r18 = x;     // Catch: Throwable -> L24
        JSONObject r19 = new JSONObject(r5.toString());     // Catch: Throwable -> L62
    L63:
        r18.i = r19;     // Catch: Throwable -> L24
        if (g != null) goto L66;
        g = r5;     // Catch: Throwable -> L24
    L72:
        monitor-exit(d.class);
        return;
    L66:
        Iterator<String> r20 = r5.keys();     // Catch: Throwable -> L24
    L68:
        if (r20.hasNext() == false) goto L72;
        String r21 = r20.next();     // Catch: Throwable -> L24
        g.put(r21, r5.get(r21));     // Catch: Throwable -> L24 JSONException -> L78
    L62:
        r19 = r5;
        goto L63
    }

    public static boolean b(String r2, String r3) {
        if (g != null) goto L6;
        return false;
    L6:
        if (r2.equals("release_build") == false) goto L12;
        return false;
    L12:
        g.put(r2, r3);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static ff7.b a(String r1, byte[] r2, Map<String, String> r3) throws Exception {
        return j.doPost(r1, r2, r3);
    }
}
