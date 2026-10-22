package j37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.settings.SettingsConfigProviderImpl;
import ft9.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m37.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f497119h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f497120i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f497121j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile long f497122k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile long f497123l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f497124m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ConcurrentHashMap f497125n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static b f497126o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile h37.a f497127p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f497128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f497129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f497130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f497131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences.Editor f497132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedPreferences.Editor f497133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f497134g;

    static {
        f497124m = new ConcurrentHashMap();
        f497125n = new ConcurrentHashMap();
    }

    public static long c() {
        if (f497122k >= 0) goto L5;
        f497122k = System.currentTimeMillis();
    L5:
        f497123l = System.currentTimeMillis() - f497122k;
        return f497123l;
    }

    public final String a() {
        if (this.f497128a == null) goto L15;
        StringBuilder r100 = new StringBuilder();
        Iterator<?> r101 = this.f497131d.getAll().values().iterator();     // Catch: Exception -> L13
    L6:
        if (r101.hasNext() == false) goto L17;
        Object r102 = r101.next();     // Catch: Exception -> L13
        if (r100.length() <= 0) goto L11;
        r100.append(",");     // Catch: Exception -> L13
    L11:
        r100.append(r102);     // Catch: Exception -> L13
    L17:
        if (this.f497130c == null) goto L33;
        if (r100 != null) goto L37;
        r100 = new StringBuilder();
    L37:
        Iterator<Map.Entry<String, ?>> r103 = this.f497130c.getAll().entrySet().iterator();     // Catch: Exception -> L31
    L21:
        if (r103.hasNext() == false) goto L33;
        Map.Entry<String, ?> r104 = r103.next();     // Catch: Exception -> L31
        if (TextUtils.equals(r104.getKey(), "key_update_version_code") == true) goto L21;
        Object r105 = r104.getValue();     // Catch: Exception -> L31
        if (r100.length() <= 0) goto L29;
        r100.append(",");     // Catch: Exception -> L31
    L29:
        r100.append(r105);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        if (r100 != null) goto L35;
        return null;
    L35:
        return r100.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L15:
        r100 = null;
        goto L17
    }

    public static boolean d() {
        return f497120i;
    }

    public a(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("__ab_vid_info.sp", 0);
        this.f497129b = r101;
        SharedPreferences r102 = r100.getSharedPreferences("__ab_exposed_info.sp", 0);
        this.f497131d = r102;
        SharedPreferences r103 = r100.getSharedPreferences("__ab_local_exposed_info.sp", 0);
        this.f497130c = r103;
        this.f497133f = r103.edit();
        this.f497132e = r102.edit();
        String r104 = r101.getString("key_vid_info", "");
        if (TextUtils.isEmpty(r104) == true) goto L11;
        this.f497128a = new JSONObject(r104);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static a b(Context r100) {
        if (f497119h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f497119h != null) goto L9;
        f497119h = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f497119h;
    }

    public static boolean g(String r100) {
        if (f497121j == false) goto L8;
        ConcurrentHashMap r101 = f497124m;
        if (r101.containsKey(r100) == true) goto L10;
        r101.put(r100, "");
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final void e(String r100) {
        long r101 = System.currentTimeMillis();
        f497125n.put(r100, Long.valueOf(r101));
        if (f497127p == null) goto L10;
        ((c) f497127p).getClass();
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L10;
        b r102 = f497126o;
        if (r102 == null) goto L10;
        r102.a();
    L10:
        if (this.f497128a == null) goto L31;
        monitor-enter(this);
        JSONObject r103 = this.f497128a;     // Catch: Throwable -> L28
        if (r103 == null) goto L26;
        long r104 = r103.optLong(r100);     // Catch: Throwable -> L28
        if (r104 <= 0) goto L26;
        if (this.f497131d.contains(r100) == true) goto L32;
        this.f497132e.putString(r100, String.valueOf(r104)).apply();     // Catch: Throwable -> L28
        goto L26
    L32:
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        goto L26
    L21:
        if (r104 == Long.parseLong(this.f497131d.getString(r100, "0"))) goto L26;
        this.f497132e.putString(r100, String.valueOf(r104)).apply();     // Catch: Exception -> L24 Throwable -> L28
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public final void f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.f497130c == null) goto L18;
        monitor-enter(this);
        SharedPreferences r101 = this.f497130c;     // Catch: Throwable -> L15
        if (r101 != null) goto L11;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L11:
        if (r101.contains(r100) == true) goto L13;
        this.f497130c.edit().putString(r100, r100).apply();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final void h(String r100) {
        if (this.f497134g == false) goto L5;
        return;
    L5:
        this.f497134g = true;
        SharedPreferences r101 = this.f497130c;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f497133f == null) goto L20;
        String r102 = r101.getString("key_update_version_code", "");
        if (TextUtils.isEmpty(r102) == false) goto L16;
        if (TextUtils.isEmpty(r100) == false) goto L14;
        this.f497133f.putString("key_update_version_code", "").apply();
        return;
    L14:
        this.f497133f.putString("key_update_version_code", r100).apply();
        return;
    L16:
        if (TextUtils.equals(r102, r100) == true) goto L23;
        this.f497133f.clear().apply();
        return;
    L23:
        return;
    }

    public final synchronized void i(JSONObject r100) {
        monitor-enter(this);
        this.f497128a = r100;     // Catch: Throwable -> L19
        this.f497129b.edit().putString("key_vid_info", r100.toString()).apply();     // Catch: Throwable -> L19
        Iterator<String> r101 = this.f497131d.getAll().keySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();     // Catch: Throwable -> L19
        if (this.f497128a.has(r102) == false) goto L8;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L5
    L11:
        if (this.f497128a.optLong(r102) == CastLongProtector.parseLong(this.f497131d.getString(r102, "0"))) goto L5;
        this.f497132e.remove(r102);     // Catch: Exception -> L14 Throwable -> L19
    L8:
        this.f497132e.remove(r102);     // Catch: Throwable -> L19
        goto L5
    L16:
        this.f497132e.apply();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
