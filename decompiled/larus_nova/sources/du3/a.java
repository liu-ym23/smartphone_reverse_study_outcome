package du3;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends xu3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f470025c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f470026d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f470027e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f470028f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f470029g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f470030h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f470031i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f470032j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f470033k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f470034l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f470035m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f470036n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static JSONObject f470037o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Map<String, String> f470038p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f470039q = -1;

    public static int b() {
        return f470025c.getAid();
    }

    public static String c() {
        if (TextUtils.isEmpty(f470032j) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f470032j) == false) goto L9;
        f470032j = f470025c.getAppVersion();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470032j;
    }

    public static String d() {
        if (f470028f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470028f != null) goto L9;
        f470028f = f470025c.getChannel();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470028f;
    }

    public static String e() {
        if (f470026d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470026d != null) goto L9;
        f470026d = f470025c.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470026d;
    }

    public static String f() {
        return f470025c.getDeviceId();
    }

    public static long g() {
        if (f470035m > 0) goto L6;
        f470035m = System.currentTimeMillis();
    L6:
        return f470035m;
    }

    public static String h() {
        if (f470036n != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470036n != (-1)) goto L9;
        f470036n = f470025c.getManifestVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return String.valueOf(f470036n);
    }

    public static String i() {
        if (TextUtils.isEmpty(f470033k) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f470033k) == false) goto L9;
        f470033k = f470025c.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470033k;
    }

    public static JSONObject j() {
        if (f470037o != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470037o != null) goto L9;
        f470037o = f470025c.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470037o;
    }

    public static long k() {
        if (f470034l >= 0) goto L6;
        f470034l = System.currentTimeMillis();
    L6:
        return f470034l;
    }

    public static int l() {
        if (f470029g != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470029g != (-1)) goto L9;
        f470029g = f470025c.getUpdateVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470029g;
    }

    public static Map<String, String> m() {
        if (f470038p != null) goto L5;
        HashMap r100 = new HashMap();
        f470038p = r100;
        r100.put("aid", String.valueOf(b()));
        f470038p.put("os", "Android");
        f470038p.put("device_platform", "android");
        f470038p.put("os_api", Build.VERSION.SDK_INT + "");
        f470038p.put("update_version_code", String.valueOf(l()));
        f470038p.put("version_code", c());
        f470038p.put("channel", d());
        f470038p.put("device_model", Build.MODEL);
        f470038p.put("device_brand", Build.BRAND);
    L5:
        f470038p.put("device_id", f());
        if (xu3.a.a() == false) goto L20;
        f470038p.put("_log_level", "debug");
    L20:
        Map<String, String> r101 = f470025c.e();     // Catch: Throwable -> L19
        if (r101 == null) goto L18;
        if (r101.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Throwable -> L19
        f470038p.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L19
    L18:
        return f470038p;
    }

    public static int n() {
        if (f470031i != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470031i != (-1)) goto L9;
        f470031i = f470025c.getVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470031i;
    }

    public static boolean o() {
        if (f470027e != null) goto L25;
        monitor-enter(a.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f470027e != null) goto L19;
        String r100 = e();     // Catch: Throwable -> L21
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L15;
    L17:
        boolean r101 = false;
    L18:
        f470027e = Boolean.valueOf(r101);     // Catch: Throwable -> L21
        goto L19
    L15:
        if (r100.equals(xu3.a.getContext().getPackageName()) == false) goto L17;
        r101 = true;
        goto L18
    L11:
        if (r100.contains(":") == false) goto L13;
        f470027e = Boolean.FALSE;     // Catch: Throwable -> L21
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
    L25:
        return f470027e.booleanValue();
    }

    public a() {
    }
}
